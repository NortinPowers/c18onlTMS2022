package by.tms.utils;

import lombok.experimental.UtilityClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@UtilityClass
public class ServletUtils {

    public static LocalDate getLocalDate(HttpServletRequest req) {
        return LocalDate.parse(req.getParameter("date"));
    }

    public static void forward(HttpServletRequest req, HttpServletResponse resp, String address) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(address).forward(req, resp);
    }
}