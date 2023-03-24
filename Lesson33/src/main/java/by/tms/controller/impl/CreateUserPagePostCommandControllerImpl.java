package by.tms.controller.impl;

import static by.tms.model.PagesPath.FAIL_REGISTER_PAGE;
import static by.tms.model.PagesPath.SUCCESS_REGISTER_PAGE;
import static by.tms.utils.Constants.Attributes.INVALID;
import static by.tms.utils.Constants.RequestParameters.BIRTHDAY;
import static by.tms.utils.Constants.RequestParameters.EMAIL;
import static by.tms.utils.Constants.RequestParameters.LOGIN;
import static by.tms.utils.Constants.RequestParameters.NAME;
import static by.tms.utils.Constants.RequestParameters.PASSWORD;
import static by.tms.utils.Constants.RequestParameters.SURNAME;
import static by.tms.utils.Constants.RequestParameters.VERIFY_PASSWORD;
import static by.tms.utils.ServletUtils.saveUserSession;
import static by.tms.utils.ValidatorUtils.isVerifyUserData;

import by.tms.controller.CommandController;
import by.tms.exception.CommandException;
import by.tms.model.Inject;
import by.tms.model.PagesPath;
import by.tms.model.User;
import by.tms.service.UserService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import lombok.Setter;

@Setter
public class CreateUserPagePostCommandControllerImpl implements CommandController {

    @Inject
    private UserService userService;
//    private final UserService userService = getUserService();

    //    @Override
//    public String getStringByPOST(HttpServletRequest request, HttpServletResponse response) {
//        String login = request.getParameter(LOGIN.getValue());
//        String verifyPassword = request.getParameter(VERIFY_PASSWORD.getValue());
//        User user = User.builder()
//                        .login(login)
//                        .password(request.getParameter(PASSWORD.getValue()))
//                        .name(request.getParameter(VERIFY_PASSWORD.getValue()))
//                        .surname(request.getParameter(SURNAME.getValue()))
//                        .email(request.getParameter(EMAIL.getValue()))
//                        .birthday(LocalDate.parse(request.getParameter(BIRTHDAY.getValue())))
//                        .build();
//        List<String> errorMessages = isVerifyUserData(user);
//        if (!isNewUserVerify(user.getLogin(), user.getPassword(), verifyPassword)) {
//            errorMessages.add("This user already exist");
//        }
//        String path;
//        if (errorMessages.isEmpty()) {
//            userService.addUser(user);
//            saveUserSession(request, login);
//            path = SUCCESS_REGISTER_PAGE.getPath();
//        } else {
//            request.setAttribute(INVALID.getAttribute(), errorMessages.stream()
//                                                                      .map(Object::toString)
//                                                                      .collect(Collectors.joining(". ")));
//            path = FAIL_REGISTER_PAGE.getPath();
//        }
//        return path;
//    }
//
    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        String login = request.getParameter(LOGIN);
        String verifyPassword = request.getParameter(VERIFY_PASSWORD);
        User user = User.builder()
                        .login(login)
                        .password(request.getParameter(PASSWORD))
                        .name(request.getParameter(NAME))
                        .surname(request.getParameter(SURNAME))
                        .email(request.getParameter(EMAIL))
                        .birthday(LocalDate.parse(request.getParameter(BIRTHDAY)))
                        .build();
        List<String> errorMessages = isVerifyUserData(user);
        if (!isNewUserVerify(user.getLogin(), user.getPassword(), verifyPassword)) {
            errorMessages.add("This user already exist");
        }
        PagesPath path;
        if (errorMessages.isEmpty()) {
            userService.addUser(user);
            saveUserSession(request, login);
            path = SUCCESS_REGISTER_PAGE;
        } else {
            request.setAttribute(INVALID, errorMessages.stream()
                                                       .map(Object::toString)
                                                       .collect(Collectors.joining(". ")));
            path = FAIL_REGISTER_PAGE;
        }
        return path;
    }

    private boolean isNewUserVerify(String login, String password, String verifyPassword) {
        if (userService.getUserByLogin(login) == null) {
            return password.equals(verifyPassword);
        }
        return false;
    }
}