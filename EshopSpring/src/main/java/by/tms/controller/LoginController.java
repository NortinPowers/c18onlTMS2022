package by.tms.controller;

import by.tms.dto.UserDto;
import by.tms.model.User;
import by.tms.service.UserService;
import by.tms.service.ValidatorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

import static by.tms.utils.Constants.Attributes.*;
import static by.tms.utils.Constants.MappingPath.*;
import static by.tms.utils.ControllerUtils.isVerifyUser;
import static by.tms.utils.ControllerUtils.saveUserSession;
import static by.tms.utils.DtoUtils.makeUserDtoModelTransfer;

@Controller
@RequiredArgsConstructor
//@Lazy
@Slf4j
public class LoginController {

    private final UserService userService;
    private final ValidatorService validateService;

    //    @GetMapping("/login")
//    public String login(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        String path;
//        if (session.getAttribute(USER_ACCESS_PERMISSION) != null) {
//            path = ESHOP;
//        } else {
//            path = LOGIN;
//        }
//        return path;
//    }
    @GetMapping("/login")
    public ModelAndView login(HttpSession session) {
//        HttpSession session = request.getSession();
        ModelAndView modelAndView;
        if (session.getAttribute(USER_ACCESS_PERMISSION) != null) {
            modelAndView = new ModelAndView(ESHOP);
        } else {
            modelAndView = new ModelAndView(LOGIN);
        }
        return modelAndView;
    }

    //    @PostMapping("/login-verify")
//    public String loginVerify(HttpServletRequest request,
//                              @RequestParam String login,
//                              @RequestParam String password) {
//        String path;
//        User user = userService.getUserByLogin(login);
//        if (user != null && isVerifyUser(user, password)) {
//            UserDto userDto = makeUserDtoModelTransfer(user);
//            saveUserSession(request, userDto);
//            path = ESHOP;
//        } else {
//            path = LOGIN;
//        }
//        return path;
//    }
    @PostMapping("/login-verify")
    public ModelAndView loginVerify(HttpServletRequest request,
                                    @RequestParam String login,
                                    @RequestParam String password) {
        ModelAndView modelAndView;
        User user = userService.getUserByLogin(login);
        if (user != null && isVerifyUser(user, password)) {
            UserDto userDto = makeUserDtoModelTransfer(user);
            saveUserSession(request, userDto);
            modelAndView = new ModelAndView(ESHOP);
        } else {
            modelAndView = new ModelAndView(LOGIN);
        }
        return modelAndView;
    }

    //    @GetMapping("/logout")
//    public String logout(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        UserDto userDto = (UserDto) session.getAttribute(USER_ACCESS_PERMISSION);
//        String userUUID = (String) session.getAttribute(USER_UUID);
//        log.info("User [" + userUUID + "] with a login " + userDto.getLogin() + " logged out of the system");
//        session.removeAttribute(USER_ACCESS_PERMISSION);
//        session.removeAttribute(USER_UUID);
//        session.invalidate();
//        return ESHOP;
//    }
    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        UserDto userDto = (UserDto) session.getAttribute(USER_ACCESS_PERMISSION);
        String userUUID = (String) session.getAttribute(USER_UUID);
        log.info("User [" + userUUID + "] with a login " + userDto.getLogin() + " logged out of the system");
        session.removeAttribute(USER_ACCESS_PERMISSION);
        session.removeAttribute(USER_UUID);
        session.invalidate();
        return new ModelAndView(ESHOP);
    }

    //    @GetMapping("/create-user")
//    public String create() {
//        return CREATE_USER;
//    }
    @GetMapping("/create-user")
    public ModelAndView create() {
        return new ModelAndView(CREATE_USER);
    }

    //    @PostMapping("/create-user")
//    public String createUser(HttpServletRequest request,
//                             @RequestParam String verifyPassword,
//                             @ModelAttribute("user") User user) {
//        List<String> errorMessages = validateService.getValidationErrorMessage(user, verifyPassword);
//        String path;
//        if (errorMessages.isEmpty()) {
//            userService.addUser(user);
//            UserDto userDto = makeUserDtoModelTransfer(user);
//            saveUserSession(request, userDto);
//            path = "success-register";
//        } else {
//            request.setAttribute(INVALID, errorMessages.stream()
//                    .map(Object::toString)
//                    .collect(Collectors.joining(". ")));
//            path = "fail-register";
//        }
//        return path;
//    }
    @PostMapping("/create-user")
    public ModelAndView createUser(HttpServletRequest request,
                                   @RequestParam String verifyPassword,
                                   @ModelAttribute("user") User user) {
        List<String> errorMessages = validateService.getValidationErrorMessage(user, verifyPassword);
        ModelAndView modelAndView;
        if (errorMessages.isEmpty()) {
            userService.addUser(user);
            UserDto userDto = makeUserDtoModelTransfer(user);
            saveUserSession(request, userDto);
            modelAndView = new ModelAndView(SUCCESS_REGISTER);
        } else {
            ModelMap modelMap = new ModelMap(INVALID, errorMessages.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(". ")));
            modelAndView = new ModelAndView(FAIL_REGISTER, modelMap);
        }
        return modelAndView;
    }

    //    @GetMapping("/success-register")
//    public String successRegister() {
//        return SUCCESS_REGISTER;
//    }
//
//    @PostMapping("/fail-register")
//    public String failRegister() {
//        return FAIL_REGISTER;
////    }
//    @GetMapping("/success-register")
//    public ModelAndView successRegister() {
//        return new ModelAndView(SUCCESS_REGISTER);
//    }
//
//    @PostMapping("/fail-register")
//    public ModelAndView failRegister() {
//        return new ModelAndView(FAIL_REGISTER);
//    }
}