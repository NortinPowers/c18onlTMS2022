package by.tms.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import static by.tms.utils.ServletUtils.forward;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private AtomicInteger count;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        count = (AtomicInteger) config.getServletContext().getAttribute("count");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        count.incrementAndGet();
        session.setAttribute("numberOfVisits", count);
        forward(req, resp, "/");
    }
}