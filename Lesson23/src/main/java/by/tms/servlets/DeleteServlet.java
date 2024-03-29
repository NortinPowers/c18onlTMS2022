package by.tms.servlets;

import by.tms.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        studentService = (StudentService) getServletContext().getAttribute("studentService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/delete.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            studentService.deleteStudent(id);
            response.sendRedirect(request.getContextPath() + "/students");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/delete.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}