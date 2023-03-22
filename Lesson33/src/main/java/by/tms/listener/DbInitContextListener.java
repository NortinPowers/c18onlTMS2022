package by.tms.listener;

import static by.tms.utils.Constants.Attributes.USER_UUID;

import by.tms.model.Commands;
import by.tms.repository.ConnectionPool;
import by.tms.utils.ControllerCommandFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;

@WebListener
@Slf4j
public class DbInitContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        ConnectionPool connectionPool = ConnectionPool.getInstance();
//        sce.getServletContext().setAttribute(CONNECTION_POOL.getAttribute(), connectionPool);
        for (Commands command : Commands.values()) {
            try {
                ControllerCommandFactory.defineCommand(command);
            } catch (Exception e) {
                log.error("Can not put values in commands map", e);
//                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        ConnectionPool connectionPool = (ConnectionPool) sce.getServletContext().getAttribute(CONNECTION_POOL.getAttribute());
//        connectionPool.closeAllConnection();
//        sce.getServletContext().removeAttribute(CONNECTION_POOL.getAttribute());
        ConnectionPool.getInstance().closeAllConnection();
        sce.getServletContext().removeAttribute(USER_UUID);
    }
}