package by.tms.servlet;

import static by.tms.utils.ServletUtils.forwardToAddress;
import static by.tms.utils.ServletUtils.getAuthenticatorService;
import static by.tms.utils.ServletUtils.saveUserSession;

import by.tms.service.AuthenticatorService;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private AuthenticatorService authenticatorService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        authenticatorService = getAuthenticatorService(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("name");
        String password = req.getParameter("password");
        if (authenticatorService.isVerifiedUser(login, password)) {
            saveUserSession(req, login);
            forwardToAddress(req, resp, "/index.jsp");
        } else {
            forwardToAddress(req, resp, "/login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("accessPermission") != null) {
            forwardToAddress(req, resp, "/index.jsp");
        } else {
            forwardToAddress(req, resp, "/login.jsp");
        }
    }
}