package by.tms.servlet;


import by.tms.model.User;
import by.tms.service.SecurityAware;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.tms.utils.ServletUtils.forwardToAddress;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private SecurityAware securityService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        securityService = (SecurityAware) config.getServletContext().getAttribute("security");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (securityService.isVerifiedUser(name, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("accessPermission", new User(name, password));
            session.setAttribute("userName", name);
            forwardToAddress(req, resp, "/index.jsp");
        } else {
            forwardToAddress(req, resp, "/login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object permission = session.getAttribute("accessPermission");
        if (permission != null) {
            forwardToAddress(req, resp, "/index.jsp");
        } else {
            forwardToAddress(req, resp, "/login.jsp");
        }
    }
}