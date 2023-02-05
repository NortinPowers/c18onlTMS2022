package by.tms.servlets;

import by.tms.model.Student;
import by.tms.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class StudentsServlet extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        studentService = (StudentService) config.getServletContext().getAttribute("studentService");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        List<Student> students = studentService.getStudents();
        request.setAttribute("students", students);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/students-form.jsp");
        requestDispatcher.forward(request, response);
    }
}