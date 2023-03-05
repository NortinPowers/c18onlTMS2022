package by.tms.servlet;

import static by.tms.utils.ServletUtils.forwardToAddress;
import static by.tms.utils.ServletUtils.getAuthenticatorService;
import static by.tms.utils.ServletUtils.getUserService;
import static by.tms.utils.ServletUtils.saveUserSession;

import by.tms.model.User;
import by.tms.service.AuthenticatorService;
import by.tms.service.UserService;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import javafx.util.Pair;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create-user")
public class CreateUserServlet extends HttpServlet {

    private UserService userService;
    private AuthenticatorService authenticatorService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = getUserService(config);
        authenticatorService = getAuthenticatorService(config);
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
        Pair<Boolean, String> verifyUserData = isVerifyUserData(login, password, verifyPassword, name, surname, email, birthday);
        if (verifyUserData.getKey()) {
            authenticatorService.getAuthenticatorMap().put(login, password);
            userService.addUser(new User(login, password, name, surname, email, birthday));
            saveUserSession(req, login);
            forwardToAddress(req, resp, "/view/success-register.jsp");
        } else {
            req.setAttribute("invalid", verifyUserData.getValue());
            forwardToAddress(req, resp, "/view/fail-register.jsp");
        }
    }

    private Pair<Boolean, String> isVerifyUserData(String login, String password, String verifyPassword, String name,
                                                   String surname, String email, LocalDate birthday) {
        String message = "";
        if (isLoginPasswordVerify(login, password)) {
            if (isNewUserVerify(login, password, verifyPassword)) {
                if (isNameSurnameVerify(name, surname)) {
                    if (isEmailVerify(email)) {
                        if (isAgeVerify(birthday)) {
                            return new Pair<>(true, message);
                        } else {
                            message = "Registration is available from the age of 18";
                        }
                    } else {
                        message = "Incorrect email";
                    }
                } else {
                    message = "Incorrect name or surname";
                }
            } else {
                message = "This user already exist";
            }
        } else {
            message = "Incorrect login or password";
        }
        return new Pair<>(false, message);
    }

    private boolean isAgeVerify(LocalDate birthday) {
        return Period.between(birthday, LocalDate.now()).getYears() > 17;
    }

    private boolean isEmailVerify(String email) {
        return email.matches("[a-zA-z0-9]{1,20}[@][a-zA-Z]{3,10}[\\.][a-zA-Z]{2,6}");
    }

    private boolean isNameSurnameVerify(String name, String surname) {
        return name.matches("[A-Za-z]{3,29}") && surname.matches("[A-Za-z]{3,29}");
    }

    private boolean isNewUserVerify(String login, String password, String verifyPassword) {
        return password.equals(verifyPassword) && !authenticatorService.getAuthenticatorMap().containsKey(login);
    }

    private boolean isLoginPasswordVerify(String login, String password) {
        return login.matches("[a-zA-Z0-9]{4,30}") && password.matches("[a-zA-Z0-9]{4,30}");
    }
}