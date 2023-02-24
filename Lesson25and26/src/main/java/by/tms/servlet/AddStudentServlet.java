package by.tms.servlet;

import by.tms.model.City;
import by.tms.model.Student;
import by.tms.service.StudentService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view/create")
public class AddStudentServlet extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        studentService = (StudentService) config.getServletContext().getAttribute("studentService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sendForward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            Integer age = Integer.parseInt(req.getParameter("age"));
            City city = new City(req.getParameter("cityName"));
            String course = req.getParameter("course");
            studentService.addNewStudent(new Student(name, surname, age, city, course));
            resp.sendRedirect(req.getContextPath() + "/view/students");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            sendForward(req, resp);
        }
    }

    private void sendForward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view/create.jsp");
        requestDispatcher.forward(req, resp);
    }
}