package by.tms.listener;

import static by.tms.model.Attribute.CONNECTION_POOL;
import static by.tms.model.Attribute.USER_UUID;

import by.tms.repository.ConnectionPool;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DbInitContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        sce.getServletContext().setAttribute(CONNECTION_POOL.getAttribute(), connectionPool);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ConnectionPool connectionPool = (ConnectionPool) sce.getServletContext().getAttribute(CONNECTION_POOL.getAttribute());
        connectionPool.closeAllConnection();
        sce.getServletContext().removeAttribute(CONNECTION_POOL.getAttribute());
        sce.getServletContext().removeAttribute(USER_UUID.getAttribute());
    }
}