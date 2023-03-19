package by.tms.controller.impl;

import static by.tms.model.Attribute.INVALID;
import static by.tms.model.PagesPath.FAIL_REGISTER_PAGE;
import static by.tms.model.PagesPath.LOGIN_PAGE;
import static by.tms.model.PagesPath.SUCCESS_REGISTER_PAGE;
import static by.tms.model.RequestParameters.BIRTHDAY;
import static by.tms.model.RequestParameters.EMAIL;
import static by.tms.model.RequestParameters.LOGIN;
import static by.tms.model.RequestParameters.PASSWORD;
import static by.tms.model.RequestParameters.SURNAME;
import static by.tms.model.RequestParameters.VERIFY_PASSWORD;
import static by.tms.utils.ServiceUtils.getUserService;
import static by.tms.utils.ServletUtils.saveUserSession;
import static by.tms.utils.ValidatorUtils.isVerifyUserData;

import by.tms.controller.Command;
import by.tms.model.User;
import by.tms.service.UserService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUserPageCommandImpl implements Command {

    private final UserService userService = getUserService();

    @Override
    public String getStringByPOST(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter(LOGIN.getValue());
        String verifyPassword = request.getParameter(VERIFY_PASSWORD.getValue());
        User user = User.builder()
                        .login(login)
                        .password(request.getParameter(PASSWORD.getValue()))
                        .name(request.getParameter(VERIFY_PASSWORD.getValue()))
                        .surname(request.getParameter(SURNAME.getValue()))
                        .email(request.getParameter(EMAIL.getValue()))
                        .birthday(LocalDate.parse(request.getParameter(BIRTHDAY.getValue())))
                        .build();
        List<String> errorMessages = isVerifyUserData(user);
        if (!isNewUserVerify(user.getLogin(), user.getPassword(), verifyPassword)) {
            errorMessages.add("This user already exist");
        }
        String path;
        if (errorMessages.isEmpty()) {
            userService.addUser(user);
            saveUserSession(request, login);
            path = SUCCESS_REGISTER_PAGE.getPath();
        } else {
            request.setAttribute(INVALID.getAttribute(), errorMessages.stream()
                                                                      .map(Object::toString)
                                                                      .collect(Collectors.joining(". ")));
            path = FAIL_REGISTER_PAGE.getPath();
        }
        return path;
    }

    @Override
    public String getStringByGET(HttpServletRequest request, HttpServletResponse response) {
        return LOGIN_PAGE.getPath();
    }

    private boolean isNewUserVerify(String login, String password, String verifyPassword) {
        if (userService.getUserByLogin(login) == null) {
            return password.equals(verifyPassword);
        }
        return false;
    }
}