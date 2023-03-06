package by.tms.servlet;

import static by.tms.utils.ServletUtils.forwardToAddress;
import static by.tms.utils.ServletUtils.getUserService;
import static by.tms.utils.ServletUtils.saveUserSession;
import static by.tms.utils.ValidatorUtils.isAgeVerify;
import static by.tms.utils.ValidatorUtils.isEmailVerify;
import static by.tms.utils.ValidatorUtils.isLoginPasswordVerify;
import static by.tms.utils.ValidatorUtils.isNameSurnameVerify;

import by.tms.model.User;
import by.tms.service.UserService;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
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
        DataResult verifyUserData = isVerifyUserData(user, verifyPassword);
        if (verifyUserData.checkResult()) {
            userService.addUser(user);
            saveUserSession(req, login);
            forwardToAddress(req, resp, "/view/success-register.jsp");
        } else {
            req.setAttribute("invalid", verifyUserData.message().stream()
                                                      .map(Object::toString)
                                                      .collect(Collectors.joining(". ")));
            forwardToAddress(req, resp, "/view/fail-register.jsp");
        }
    }

    private DataResult isVerifyUserData(User user, String verifyPassword) {
        List<String> message = new ArrayList<>();
        if (!isLoginPasswordVerify(user.getLogin(), user.getPassword())) {
            message.add("Incorrect login or password");
        }
        if (!isNewUserVerify(user.getLogin(), user.getPassword(), verifyPassword)) {
            message.add("This user already exist");
        }
        if (!isNameSurnameVerify(user.getName(), user.getSurname())) {
            message.add("Incorrect name or surname");
        }
        if (!isEmailVerify(user.getEmail())) {
            message.add("Incorrect email");
        }
        if (!isAgeVerify(user.getBirthday())) {
            message.add("Registration is available from the age of 18");
        }
        return new DataResult(message.isEmpty(), message);
    }

    private boolean isNewUserVerify(String login, String password, String verifyPassword) {
        if (userService.getUserByLogin(login) == null) {
            return password.equals(verifyPassword);
        }
        return false;
    }
}

record DataResult(boolean checkResult, List<String> message) {

}