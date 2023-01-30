package by.tms.servlets;

import by.tms.service.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CalculatorNewResult")
public class CalculatorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Calculator calculator = new Calculator();
        response.setContentType("text/jsp");
        String value1 = request.getParameter("value1");
        String value2 = request.getParameter("value2");
        String result = "Result: ";
        if (request.getParameter("addition") != null) {
            result = result + calculator.addition(value1, value2);
        } else if (request.getParameter("subtraction") != null) {
            result = result + calculator.subtraction(value1, value2);
        } else if (request.getParameter("multiplication") != null) {
            result = result + calculator.multiplication(value1, value2);
        } else {
            if (!value2.equals("0")) {
                result = result + calculator.division(value1, value2);
            } else {
                result = "Dividing by zero is prohibited!";
            }
        }
        request.setAttribute("result", result);
        getServletContext().getRequestDispatcher("/calc_styler.jsp").forward(request, response);
        response.sendRedirect("/CalculatorNewResult");
    }
}