package by.tms.utils;

import by.tms.model.User;
import by.tms.service.AuthenticatorService;
import by.tms.service.SecurityService;
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

    public static String getLogin(HttpServletRequest req) {
        return req.getSession().getAttribute("userName").toString();
    }

    public static UserService getUserService(ServletConfig config) {
        return (UserService) config.getServletContext().getAttribute("customerService");
    }

    public static SecurityService getSecurity(ServletConfig config) {
        return (SecurityService) config.getServletContext().getAttribute("security");
    }

    public static AuthenticatorService getAuthenticatorService(ServletConfig config) {
        return (AuthenticatorService) config.getServletContext().getAttribute("authenticatorService");
    }
}