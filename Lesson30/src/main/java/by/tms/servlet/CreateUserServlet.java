package by.tms.servlet;

import static by.tms.utils.ServletUtils.forwardToAddress;
import static by.tms.utils.ServletUtils.getUserService;
import static by.tms.utils.ServletUtils.saveUserSession;
import static by.tms.utils.ValidatorUtils.isVerifyUserData;

import by.tms.model.User;
import by.tms.service.UserService;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create-user")
public class CreateUserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = getUserService(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToAddress(req, resp, "/login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String verifyPassword = req.getParameter("verifyPassword");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        LocalDate birthday = LocalDate.parse(req.getParameter("birthday"));
        User user = User.builder()
                        .login(login)
                        .password(password)
                        .name(name)
                        .surname(surname)
                        .email(email)
                        .birthday(birthday)
                        .build();
        List<String> message = isVerifyUserData(user);
        if (!isNewUserVerify(user.getLogin(), user.getPassword(), verifyPassword)) {
            message.add("This user already exist");
        }
        if (message.isEmpty()) {
            userService.addUser(user);
            saveUserSession(req, login);
            forwardToAddress(req, resp, "/view/success-register.jsp");
        } else {
            req.setAttribute("invalid", message.stream()
                                               .map(Object::toString)
                                               .collect(Collectors.joining(". ")));
            forwardToAddress(req, resp, "/view/fail-register.jsp");
        }
    }

    private boolean isNewUserVerify(String login, String password, String verifyPassword) {
        if (userService.getUserByLogin(login) == null) {
            return password.equals(verifyPassword);
        }
        return false;
    }
}