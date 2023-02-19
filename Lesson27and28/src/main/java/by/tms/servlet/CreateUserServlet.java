package by.tms.servlet;

import by.tms.model.User;
import by.tms.service.AuthenticatorServiceAware;
import by.tms.service.CustomerServiceAware;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.tms.utils.ServletUtils.*;

@WebServlet("/create-user")
public class CreateUserServlet extends HttpServlet {
    private CustomerServiceAware customerService;
    private AuthenticatorServiceAware authenticatorService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        customerService = getCustomerService(config);
        authenticatorService = getAuthenticatorService(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToAddress(req, resp, "/login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String verifyPassword = req.getParameter("verifyPassword");
        if (password.equals(verifyPassword) && !authenticatorService.getAuthenticatorMap().containsKey(login)) {
            authenticatorService.getAuthenticatorMap().put(login, password);
            customerService.addUser(new User(login, password));
            saveUserSession(req, login);
            forwardToAddress(req, resp, "/view/success-register.jsp");
        } else {
            forwardToAddress(req, resp, "/view/fail-register.jsp");
        }
    }
}
