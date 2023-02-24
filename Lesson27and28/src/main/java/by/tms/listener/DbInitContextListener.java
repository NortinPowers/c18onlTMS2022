package by.tms.listener;

import by.tms.model.Authenticator;
import by.tms.repository.JdbcCartRepository;
import by.tms.repository.JdbcCartRepositoryAware;
import by.tms.repository.JdbcCustomerRepository;
import by.tms.repository.JdbcCustomerRepositoryAware;
import by.tms.repository.JdbcProductRepository;
import by.tms.repository.JdbcProductRepositoryAware;
import by.tms.service.AuthenticatorService;
import by.tms.service.AuthenticatorServiceAware;
import by.tms.service.CartService;
import by.tms.service.CartServiceAware;
import by.tms.service.CustomerService;
import by.tms.service.CustomerServiceAware;
import by.tms.service.ProductService;
import by.tms.service.ProductServiceAware;
import by.tms.service.SecurityAware;
import by.tms.service.SecurityService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DbInitContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String dbURl = sce.getServletContext().getInitParameter("db_url");
        String dbUser = sce.getServletContext().getInitParameter("db_user");
        String dbPassword = sce.getServletContext().getInitParameter("db_password");
        String dbDriver = sce.getServletContext().getInitParameter("db_driver");
        try {
            Class.forName(dbDriver);
            Connection connection = DriverManager.getConnection(dbURl, dbUser, dbPassword);
            JdbcProductRepositoryAware jdbcProductRepository = new JdbcProductRepository(connection);
            ProductServiceAware productService = new ProductService(jdbcProductRepository);
            sce.getServletContext().setAttribute("connection", connection);
            sce.getServletContext().setAttribute("productService", productService);
            JdbcCartRepositoryAware jdbcCartRepository = new JdbcCartRepository(connection);
            CartServiceAware cartService = new CartService(jdbcCartRepository);
            sce.getServletContext().setAttribute("cartService", cartService);
            JdbcCustomerRepositoryAware jdbcCustomerRepository = new JdbcCustomerRepository(connection);
            CustomerServiceAware customerService = new CustomerService(jdbcCustomerRepository);
            sce.getServletContext().setAttribute("customerService", customerService);
            Map<String, String> accessMap = new HashMap<>();
            Authenticator authenticator = new Authenticator(accessMap);
            AuthenticatorServiceAware authenticatorService = new AuthenticatorService(customerService, authenticator);
            authenticatorService.fillAuthenticatorMap();
            sce.getServletContext().setAttribute("authenticatorService", authenticatorService);
            SecurityAware security = new SecurityService(authenticator);
            sce.getServletContext().setAttribute("security", security);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("ContextInitialized exception: " + e.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Connection connection = (Connection) sce.getServletContext().getAttribute("connection");
        try {
            sce.getServletContext().setAttribute("security", null);
            connection.close();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}