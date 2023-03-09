package by.tms.listener;

import by.tms.model.Authenticator;
import by.tms.repository.JdbcCartRepository;
import by.tms.repository.JdbcOrderRepository;
import by.tms.repository.JdbcProductRepository;
import by.tms.repository.JdbcUserRepository;
import by.tms.repository.impl.JdbcCartRepositoryImpl;
import by.tms.repository.impl.JdbcOrderRepositoryImpl;
import by.tms.repository.impl.JdbcProductRepositoryImpl;
import by.tms.repository.impl.JdbcUserRepositoryImpl;
import by.tms.service.AuthenticatorService;
import by.tms.service.CartService;
import by.tms.service.OrderService;
import by.tms.service.ProductService;
import by.tms.service.UserService;
import by.tms.service.impl.AuthenticatorServiceImpl;
import by.tms.service.impl.CartServiceImpl;
import by.tms.service.impl.OrderServiceImpl;
import by.tms.service.impl.ProductServiceImpl;
import by.tms.service.impl.UserServiceImpl;
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
            JdbcProductRepository jdbcProductRepository = new JdbcProductRepositoryImpl(connection);
            ProductService productService = new ProductServiceImpl(jdbcProductRepository);
            sce.getServletContext().setAttribute("connection", connection);
            sce.getServletContext().setAttribute("productService", productService);
            JdbcCartRepository jdbcCartRepository = new JdbcCartRepositoryImpl(connection);
            CartService cartService = new CartServiceImpl(jdbcCartRepository);
            sce.getServletContext().setAttribute("cartService", cartService);
            JdbcUserRepository jdbcUserRepository = new JdbcUserRepositoryImpl(connection);
            UserService userService = new UserServiceImpl(jdbcUserRepository);
            sce.getServletContext().setAttribute("userService", userService);
            Map<String, String> accessMap = new HashMap<>();
            Authenticator authenticator = new Authenticator(accessMap);
            AuthenticatorService authenticatorService = new AuthenticatorServiceImpl(userService, authenticator);
            sce.getServletContext().setAttribute("authenticatorService", authenticatorService);
            JdbcOrderRepository jdbcOrderRepository = new JdbcOrderRepositoryImpl(connection);
            OrderService orderService = new OrderServiceImpl(jdbcOrderRepository);
            sce.getServletContext().setAttribute("orderService", orderService);
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