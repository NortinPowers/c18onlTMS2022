package by.tms.listener;

import by.tms.model.Authenticator;
import by.tms.repository.ConnectionPool;
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
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DbInitContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        sce.getServletContext().setAttribute("connectionPool", connectionPool);
        JdbcProductRepository jdbcProductRepository = new JdbcProductRepositoryImpl(connectionPool);
        ProductService productService = new ProductServiceImpl(jdbcProductRepository);
        sce.getServletContext().setAttribute("productService", productService);
        JdbcCartRepository jdbcCartRepository = new JdbcCartRepositoryImpl(connectionPool);
        CartService cartService = new CartServiceImpl(jdbcCartRepository);
        sce.getServletContext().setAttribute("cartService", cartService);
        JdbcUserRepository jdbcUserRepository = new JdbcUserRepositoryImpl(connectionPool);
        UserService userService = new UserServiceImpl(jdbcUserRepository);
        sce.getServletContext().setAttribute("userService", userService);
        Map<String, String> accessMap = new HashMap<>();
        Authenticator authenticator = new Authenticator(accessMap);
        AuthenticatorService authenticatorService = new AuthenticatorServiceImpl(userService, authenticator);
        sce.getServletContext().setAttribute("authenticatorService", authenticatorService);
        JdbcOrderRepository jdbcOrderRepository = new JdbcOrderRepositoryImpl(connectionPool);
        OrderService orderService = new OrderServiceImpl(jdbcOrderRepository);
        sce.getServletContext().setAttribute("orderService", orderService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ConnectionPool connectionPool = (ConnectionPool) sce.getServletContext().getAttribute("connectionPool");
        connectionPool.closeAllConnection();
    }
}