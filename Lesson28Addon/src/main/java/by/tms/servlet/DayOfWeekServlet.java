package by.tms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import static by.tms.utils.ServletUtils.forward;
import static by.tms.utils.ServletUtils.getLocalDate;

@WebServlet("/day-of-week")
public class DayOfWeekServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDate date = getLocalDate(req);
        req.setAttribute("dayOfWeekDate", date);
        req.setAttribute("dayOfWeek", date.getDayOfWeek());
        forward(req, resp, "/day-of-week.jsp");
    }
}