package by.tms.controller;

import by.tms.dto.UserDto;
import by.tms.model.User;
import by.tms.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static by.tms.utils.Constants.Attributes.USER_ACCESS_PERMISSION;
import static by.tms.utils.Constants.Attributes.USER_UUID;
import static by.tms.utils.Constants.Mapping.ESHOP;
import static by.tms.utils.Constants.Mapping.LOGIN;
import static by.tms.utils.ControllerUtils.isVerifyUser;
import static by.tms.utils.ControllerUtils.saveUserSession;
import static by.tms.utils.DtoUtils.makeUserModelTransfer;

@Controller
@RequiredArgsConstructor
@Lazy
@Slf4j
public class LoginPageController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String path;
        if (session.getAttribute(USER_ACCESS_PERMISSION) != null) {
            path = ESHOP;
        } else {
            path = LOGIN;
        }
        return path;
    }

    @PostMapping("/login-verify")
    public String loginVerify(HttpServletRequest request,
                              @RequestParam String login,
                              @RequestParam String password) {
//        String login = request.getParameter(NAME);
//        String password = request.getParameter(PASSWORD);
        String path;
        User user = userService.getUserByLogin(login);
        if (user != null && isVerifyUser(user, password)) {
            UserDto userDto = makeUserModelTransfer(user);
            saveUserSession(request, userDto);
            path = ESHOP;
        } else {
            path = LOGIN;
        }
        return path;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        UserDto userDto = (UserDto) session.getAttribute(USER_ACCESS_PERMISSION);
        String userUUID = (String) session.getAttribute(USER_UUID);
        log.info("User [" + userUUID + "] with a login " + userDto.getLogin() + " logged out of the system");
        session.removeAttribute(USER_ACCESS_PERMISSION);
        session.removeAttribute(USER_UUID);
        session.invalidate();
        return ESHOP;
    }
}