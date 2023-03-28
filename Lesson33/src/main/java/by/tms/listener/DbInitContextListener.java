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
        for (Commands command : Commands.values()) {
            try {
                ControllerCommandFactory.defineCommand(command);
            } catch (Exception e) {
                log.error("Can not put values in commands map", e);
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ConnectionPool.getInstance().closeAllConnection();
        sce.getServletContext().removeAttribute(USER_UUID);
    }
}