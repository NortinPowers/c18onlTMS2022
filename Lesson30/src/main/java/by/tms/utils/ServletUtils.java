package by.tms.utils;

import by.tms.model.User;
import by.tms.service.AuthenticatorService;
import by.tms.service.UserService;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ServletUtils {

    public static void forwardToAddress(HttpServletRequest req, HttpServletResponse resp, String address) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(address).forward(req, resp);
    }

    public static void saveUserSession(HttpServletRequest req, String login) {
        HttpSession session = req.getSession();
        session.setAttribute("accessPermission", new User(login));
        session.setAttribute("userName", login);
    }

    public static UserService getUserService(ServletConfig config) {
        return (UserService) config.getServletContext().getAttribute("userService");
    }

    public static AuthenticatorService getAuthenticatorService(ServletConfig config) {
        return (AuthenticatorService) config.getServletContext().getAttribute("authenticatorService");
    }
}