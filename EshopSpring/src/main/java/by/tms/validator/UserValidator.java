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
import static by.tms.utils.Constants.ErrorMessage.PASSWORDS_MATCHING;

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
        checkUserByLogin(errors, user);
        checkUserByEmail(errors, user);
        checkPasswordInputVerify(errors, user);
    }

    private void checkUserByEmail(Errors errors, User user) {
        Optional<User> userByEmail = userService.getUserByEmail(user.getEmail());
        if (userByEmail.isPresent()) {
            errors.rejectValue("email", "", EXISTING_EMAIL);
        }
    }

    private void checkUserByLogin(Errors errors, User user) {
        Optional<User> userByLogin = userService.getUserByLogin(user.getLogin());
        if (userByLogin.isPresent()) {
            errors.rejectValue("login", "", EXISTING_USER);
        }
    }

    private void checkPasswordInputVerify(Errors errors, User user) {
        if (!user.getPassword().equals(user.getVerifyPassword())) {
            errors.rejectValue("verifyPassword", "", PASSWORDS_MATCHING);
        }
    }
}
