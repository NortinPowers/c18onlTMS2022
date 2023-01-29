package by.tms.servlets;

import by.tms.model.Student;
import by.tms.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/db")
public class StudentsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/jps");
        StudentService studentService = new StudentService();
        List<Student> students = studentService.getAllStudents();
        request.setAttribute("students", students);
        getServletContext().getRequestDispatcher("/students.jsp").forward(request, response);
        response.sendRedirect("/db");
    }
}