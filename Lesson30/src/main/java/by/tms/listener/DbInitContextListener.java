package by.tms.listener;

import by.tms.model.Authenticator;
import by.tms.repository.JdbcCustomerRepositoryImpl;
import by.tms.repository.UserRepository;
import by.tms.service.AuthenticatorService;
import by.tms.service.UserService;
import by.tms.service.impl.AuthenticatorServiceImpl;
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
            sce.getServletContext().setAttribute("connection", connection);
            UserRepository userRepository = new JdbcCustomerRepositoryImpl(connection);
            UserService userService = new UserServiceImpl(userRepository);
            sce.getServletContext().setAttribute("userService", userService);
            Map<String, String> accessMap = new HashMap<>();
            Authenticator authenticator = new Authenticator(accessMap);
            AuthenticatorService authenticatorService = new AuthenticatorServiceImpl(userService, authenticator);
            sce.getServletContext().setAttribute("authenticatorService", authenticatorService);
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