package by.tms.controller;

import by.tms.dto.UserDto;
import by.tms.model.User;
import by.tms.service.UserService;
import by.tms.validator.ExcludeLogValidation;
import by.tms.validator.UserValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static by.tms.utils.Constants.Attributes.USER_ACCESS_PERMISSION;
import static by.tms.utils.Constants.Attributes.USER_UUID;
import static by.tms.utils.Constants.ErrorMessage.RECHECK_DATA;
import static by.tms.utils.Constants.MappingPath.CREATE_USER;
import static by.tms.utils.Constants.MappingPath.ESHOP;
import static by.tms.utils.Constants.MappingPath.LOGIN;
import static by.tms.utils.Constants.MappingPath.SUCCESS_REGISTER;
import static by.tms.utils.ControllerUtils.fillError;
import static by.tms.utils.ControllerUtils.isVerifyUser;
import static by.tms.utils.ControllerUtils.saveUserSession;
import static by.tms.utils.DtoUtils.makeUserDtoModelTransfer;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final UserService userService;
    private final UserValidator userValidator;

    @GetMapping("/login")

    public ModelAndView showLoginPage(HttpSession session) {
        ModelAndView modelAndView;
        if (session.getAttribute(USER_ACCESS_PERMISSION) != null) {
            modelAndView = new ModelAndView(ESHOP);
        } else {
            modelAndView = new ModelAndView(LOGIN);
        }
        return modelAndView;
    }

    @PostMapping("/login-verify")
    public ModelAndView showLoginVerifyPage(HttpServletRequest request,
                                            @Validated(Default.class) @ModelAttribute("user") User user,
                                            BindingResult bindingResult,
                                            ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            fillError("login", modelAndView, bindingResult);
            fillError("password", modelAndView, bindingResult);
            modelAndView.setViewName(LOGIN);
        } else {
            Optional<User> incomingUser = userService.getUserByLogin(user.getLogin());
            if (incomingUser.isPresent() && isVerifyUser(incomingUser.get(), user.getPassword())) {
                UserDto userDto = makeUserDtoModelTransfer(incomingUser.get());
                saveUserSession(request, userDto);
                modelAndView.setViewName(ESHOP);
            } else {
                modelAndView.addObject("loginError", RECHECK_DATA);
                modelAndView.setViewName(LOGIN);
            }
        }
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView showLogoutPage(HttpSession session) {
        UserDto userDto = (UserDto) session.getAttribute(USER_ACCESS_PERMISSION);
        String userUUID = (String) session.getAttribute(USER_UUID);
        log.info("User [" + userUUID + "] with a login " + userDto.getLogin() + " logged out of the system");
        session.removeAttribute(USER_ACCESS_PERMISSION);
        session.removeAttribute(USER_UUID);
        session.invalidate();
        return new ModelAndView(ESHOP);
    }

    @GetMapping("/create-user")
    public ModelAndView create() {
        return new ModelAndView(CREATE_USER);
    }

    @PostMapping("/create-user")
    public ModelAndView createUser(HttpServletRequest request,
                                   @Validated({Default.class, ExcludeLogValidation.class}) @ModelAttribute("user") User user,
                                   BindingResult bindingResult,
                                   ModelAndView modelAndView) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            fillError("login", modelAndView, bindingResult);
            fillError("password", modelAndView, bindingResult);
            fillError("verifyPassword", modelAndView, bindingResult);
            fillError("name", modelAndView, bindingResult);
            fillError("surname", modelAndView, bindingResult);
            fillError("email", modelAndView, bindingResult);
            fillError("birthday", modelAndView, bindingResult);
            modelAndView.setViewName(CREATE_USER);
        } else {
            userService.addUser(user);
            UserDto userDto = makeUserDtoModelTransfer(user);
            saveUserSession(request, userDto);
            modelAndView.setViewName(SUCCESS_REGISTER);
        }
        return modelAndView;
    }
}