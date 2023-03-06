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
        if (verifyUserData.checkResult) {
            userService.addUser(user);
            saveUserSession(req, login);
            forwardToAddress(req, resp, "/view/success-register.jsp");
        } else {
            req.setAttribute("invalid", verifyUserData.message);
            forwardToAddress(req, resp, "/view/fail-register.jsp");
        }
    }

    private DataResult isVerifyUserData(User user, String verifyPassword) {
        String message = "";
        if (!isLoginPasswordVerify(user.getLogin(), user.getPassword())) {
            message = message + "Incorrect login or password.\n";
        }
        if (!isNewUserVerify(user.getLogin(), user.getPassword(), verifyPassword)) {
            message = message + "This user already exist.\n";
        }
        if (!isNameSurnameVerify(user.getName(), user.getSurname())) {
            message = message + "Incorrect name or surname.\n";
        }
        if (!isEmailVerify(user.getEmail())) {
            message = message + "Incorrect email.\n";
        }
        if (!isAgeVerify(user.getBirthday())) {
            message = message + "Registration is available from the age of 18.\n";
        }
        boolean checkResult = message.length() == 0;
        return new DataResult(checkResult, message);
    }

    private record DataResult(boolean checkResult, String message) {
    }

    private boolean isNewUserVerify(String login, String password, String verifyPassword) {
        if (userService.getUserByLogin(login) == null) {
            return password.equals(verifyPassword);
        }
        return false;
    }
}