package by.tms.controller.impl;

import static by.tms.model.PagesPath.LOGIN_JSP_PAGE;
import static by.tms.utils.Constants.Attributes.ACCESS_PERMISSION;
import static by.tms.utils.ControllerUtils.getHomePagePath;

import by.tms.controller.CommandController;
import by.tms.exception.CommandException;
import by.tms.model.PagesPath;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.Setter;

//@Slf4j
@Setter
public class LoginPageCommandControllerImpl implements CommandController {

//    @Inject
//    private UserService userService;
//    private final UserService userService = getUserService();

//    @Override
//    public String getStringByPOST(HttpServletRequest request, HttpServletResponse response) {
//        String login = request.getParameter(NAME.getValue());
//        String password = request.getParameter(PASSWORD.getValue());
//        String path;
//        if (userService.isVerifiedUser(login, password)) {
//            saveUserSession(request, login);
//            path = getHomePagePath();
//        } else {
//            path = LOGIN_JSP_PAGE.getPath();
//        }
//        return path;
//    }

//    @Override
//    public String getStringByGET(HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession();
//        String path;
//        if (session.getAttribute(ACCESS_PERMISSION.getAttribute()) != null) {
//            path = getHomePagePath();
//        } else {
//            path = LOGIN_JSP_PAGE.getPath();
//        }
//        return path;
//    }

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        PagesPath path;
        if (session.getAttribute(ACCESS_PERMISSION) != null) {
            path = getHomePagePath();
        } else {
            path = LOGIN_JSP_PAGE;
        }
        return path;
    }
}