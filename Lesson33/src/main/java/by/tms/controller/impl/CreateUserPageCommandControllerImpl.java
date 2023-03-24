package by.tms.controller.impl;

import static by.tms.model.PagesPath.LOGIN_PAGE;

import by.tms.controller.CommandController;
import by.tms.exception.CommandException;
import by.tms.model.PagesPath;
import javax.servlet.http.HttpServletRequest;
import lombok.Setter;

@Setter
public class CreateUserPageCommandControllerImpl implements CommandController {

//    @Inject
//    private UserService userService;
////    private final UserService userService = getUserService();
//
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

//    @Override
//    public String getStringByGET(HttpServletRequest request, HttpServletResponse response) {
//        return LOGIN_PAGE.getPath();
//    }

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        return LOGIN_PAGE;
    }
//
//    private boolean isNewUserVerify(String login, String password, String verifyPassword) {
//        if (userService.getUserByLogin(login) == null) {
//            return password.equals(verifyPassword);
//        }
//        return false;
//    }
}