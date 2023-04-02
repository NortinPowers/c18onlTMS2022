package by.tms.servlet;

import static by.tms.model.Commands.HOME_PAGE_COMMAND;
import static by.tms.utils.Constants.RequestParameters.COMMAND;
import static by.tms.utils.ControllerUtils.throwCommandException;
import static by.tms.utils.ServletUtils.forwardToAddress;

import by.tms.controller.CommandController;
import by.tms.exception.CommandException;
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
        try {
            processRequest(req, resp);
        } catch (CommandException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (CommandException e) {
            throw new RuntimeException(e);
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, CommandException {
        String commandKey = request.getParameter(COMMAND);
        if (commandKey == null || commandKey.isEmpty()) {
            commandKey = HOME_PAGE_COMMAND.getCommand();
        }
        try {
            CommandController baseController = ControllerCommandFactory.defineCommand(Commands.fromString(commandKey));
            PagesPath pagesPath = baseController.execute(request);
            forwardToAddress(request, response, pagesPath.getPath());
        } catch (Exception e) {
            throwCommandException(request, e, this.getClass());
            log.error("It is impossible to go to the address", e);
            forwardToAddress(request, response, "/500.jsp");
        }
    }
}