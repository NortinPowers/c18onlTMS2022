package by.tms.servlet;

import by.tms.service.SecurityAware;
import lombok.Getter;
import lombok.Setter;

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
    @Setter
    @Getter
    private static Object access = null;

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
            access = new Object();
            session.setAttribute("accessPermission", access);
            getRedirect(req, resp, "/open-page.jsp");
        } else {
            getRedirect(req, resp, "/index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (access != null) {
            getRedirect(req, resp, "/open-page.jsp");
        } else {
            getRedirect(req, resp, "/index.jsp");
        }
    }

    private void getRedirect(HttpServletRequest req, HttpServletResponse resp, String address) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(address);
        requestDispatcher.forward(req, resp);
    }
}