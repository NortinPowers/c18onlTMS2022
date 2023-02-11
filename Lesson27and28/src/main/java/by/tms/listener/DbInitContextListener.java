package by.tms.listener;

import by.tms.model.Product;
import by.tms.repository.JdbsProductRepository;
import by.tms.repository.JdbsProductRepositoryAware;
import by.tms.service.ProductService;
import by.tms.service.ProductServiceAware;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            JdbsProductRepositoryAware jdbsStudentsRepository = new JdbsProductRepository(connection);
            List<Product> cartProducts = new ArrayList<>();
            Set<Product> favoriteProducts = new HashSet<>();
            ProductServiceAware productService = new ProductService(jdbsStudentsRepository, cartProducts, favoriteProducts);
            sce.getServletContext().setAttribute("connection", connection);
            sce.getServletContext().setAttribute("productService", productService);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("ContextInitialized exception: " + e.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Connection connection = (Connection) sce.getServletContext().getAttribute("connection");
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}