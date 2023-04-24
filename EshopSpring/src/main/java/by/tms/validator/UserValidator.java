package by.tms.validator;

import by.tms.model.User;
import by.tms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

import static by.tms.utils.Constants.ErrorMessage.EXISTING_EMAIL;
import static by.tms.utils.Constants.ErrorMessage.EXISTING_USER;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {

    private final UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        Optional<User> userByLogin = userService.getUserByLogin(user.getLogin());
        if (userByLogin.isPresent()) {
            errors.rejectValue("login", "", EXISTING_USER);
        }
        Optional<User> userByEmail = userService.getUserByEmail(user.getEmail());
        if (userByEmail.isPresent()) {
            errors.rejectValue("email", "", EXISTING_EMAIL);
        }
    }
}
