package by.tms.servlet;

import static by.tms.model.PagesPath.HOME_PAGE;

import by.tms.controller.Command;
import by.tms.exception.CommandException;
import by.tms.utils.CommandFactory;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
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

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command requestCommand = CommandFactory.defineCommand(req);
        try {
            String path = requestCommand.execute(req, resp);
            RequestDispatcher dispatcher = req.getRequestDispatcher(path);
            dispatcher.forward(req, resp);
        } catch (CommandException e) {
            log.error("Exception (processRequest())" + e);
            req.getRequestDispatcher(HOME_PAGE.getPath()).forward(req, resp);
        }
    }
}