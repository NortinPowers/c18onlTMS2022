package by.tms.listener;

import by.tms.repository.JdbcStudentsRepository;
import by.tms.repository.StudentRepositoryAware;
import by.tms.service.StudentService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
        try {
            final String dbDriver = "org.postgresql.Driver";
            Class.forName(dbDriver);
            Connection connection = DriverManager.getConnection(dbURl, dbUser, dbPassword);
            StudentRepositoryAware jdbcStudentsRepository = new JdbcStudentsRepository(connection);
            StudentService studentService = new StudentService(jdbcStudentsRepository);
            sce.getServletContext().setAttribute("connection", connection);
            sce.getServletContext().setAttribute("studentService", studentService);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
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