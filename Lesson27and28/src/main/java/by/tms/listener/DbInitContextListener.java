package by.tms.listener;

import by.tms.model.Authenticator;
import by.tms.repository.*;
import by.tms.service.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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
            JdbcProductRepositoryAware jdbsProductRepository = new JdbcProductRepository(connection);
            ProductServiceAware productService = new ProductService(jdbsProductRepository);
            sce.getServletContext().setAttribute("connection", connection);
            sce.getServletContext().setAttribute("productService", productService);
            JdbcCartRepositoryAware jdbsCartRepository = new JdbcCartRepository(connection);
            CartServiceAware cartService = new CartService(jdbsCartRepository);
            sce.getServletContext().setAttribute("cartService", cartService);
            JdbcCustomerRepositoryAware jdbsCustomerRepository = new JdbcCustomerRepository(connection);
            CustomerServiceAware customerService = new CustomerService(jdbsCustomerRepository);
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