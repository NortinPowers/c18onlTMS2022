package by.tms.servlet;

import static by.tms.model.Commands.HOME_PAGE_COMMAND;
import static by.tms.model.RequestParameters.COMMAND;
import static by.tms.utils.ServletUtils.forwardToAddress;

import by.tms.controller.CommandController;
import by.tms.model.Commands;
import by.tms.model.PagesPath;
import by.tms.utils.ControllerCommandFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/eshop")
public class ApplicationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    //    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        CommandController requestCommandController = defineCommand(req);
//        try {
//            String path = requestCommandController.execute(req, resp);
//            RequestDispatcher dispatcher = req.getRequestDispatcher(path);
//            dispatcher.forward(req, resp);
//        } catch (CommandException e) {
//            log.error("Exception (processRequest())", e);
//            req.getRequestDispatcher(HOME_PAGE.getPath()).forward(req, resp);
//        }
//    }
//    private void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String commandKey = request.getParameter(COMMAND.getValue());
//        if (commandKey == null || commandKey.isEmpty()) {
//            commandKey = HOME_PAGE_COMMAND.getCommand();
//        }
//        try {
//            CommandController baseController = ControllerCommandFactory.defineCommand(Commands.fromString(commandKey));
//            String pagesPath = baseController.execute(request, response);
//            //forward
//            RequestDispatcher dispatcher = request.getRequestDispatcher(pagesPath);
//            dispatcher.forward(request, response);
//        } catch (Exception e) {
//            log.error("It is impossible to go to the address", e);
////       !!!! логируем сообщение а потом должны перенаправить на страницу с ошибкой("Извините что-то поломалось!!!"),
////        https://blog.hubspot.com/marketing/http-500-internal-server-error
////            также можно конверсейшен в URL запроса поместить
//            //forward
//            request.getRequestDispatcher("/404.jsp").forward(request, response);
//        }
//    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String commandKey = request.getParameter(COMMAND.getValue());
        if (commandKey == null || commandKey.isEmpty()) {
            commandKey = HOME_PAGE_COMMAND.getCommand();
        }
        try {
            CommandController baseController = ControllerCommandFactory.defineCommand(Commands.fromString(commandKey));
            PagesPath pagesPath = baseController.execute(request);
            //forward
            forwardToAddress(request, response, pagesPath.getPath());
//            RequestDispatcher dispatcher = request.getRequestDispatcher(pagesPath.getPath());
//            dispatcher.forward(request, response);
        } catch (Exception e) {
//            log.error("It is impossible to go to the address", e);
//       !!!! логируем сообщение а потом должны перенаправить на страницу с ошибкой("Извините что-то поломалось!!!"),
//        https://blog.hubspot.com/marketing/http-500-internal-server-error
//            также можно конверсейшен в URL запроса поместить
            //forward
            forwardToAddress(request, response, "/404.jsp");
//            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }
    }
}