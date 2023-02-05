package by.tms.servlet;

import by.tms.model.User;
import by.tms.service.SecurityAware;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class IndexServlet extends HttpServlet {

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
            sendForward(req, resp, "/open-page.jsp");
        } else {
            sendForward(req, resp, "/index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object permission = session.getAttribute("accessPermission");
        if (permission != null) {
            sendForward(req, resp, "/open-page.jsp");
        } else {
            sendForward(req, resp, "/index.jsp");
        }
    }

    private void sendForward(HttpServletRequest req, HttpServletResponse resp, String address) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(address);
        requestDispatcher.forward(req, resp);
    }
}