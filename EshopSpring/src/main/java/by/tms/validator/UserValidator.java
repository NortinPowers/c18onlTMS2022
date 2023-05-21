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
        checkUserLoginAndEmail(errors, user);
        checkPasswordInputVerify(errors, user);
    }

    private void checkUserLoginAndEmail(Errors errors, User testUser) {
        Optional<User> user = userService.getVerifyUser(testUser.getLogin(), testUser.getEmail());
        if (user.isPresent()) {
            User foundUser = user.get();
            checkUserByLogin(errors, testUser, foundUser);
            checkUserByEmail(errors, testUser, foundUser);
        }
    }

    private static void checkUserByEmail(Errors errors, User testUser, User foundUser) {
        if (foundUser.getEmail().equals(testUser.getEmail())) {
            errors.rejectValue("email", "", EXISTING_EMAIL);
        }
    }

    private static void checkUserByLogin(Errors errors, User testUser, User foundUser) {
        if (foundUser.getLogin().equals(testUser.getLogin())) {
            errors.rejectValue("login", "", EXISTING_USER);
        }
    }

    private void checkPasswordInputVerify(Errors errors, User user) {
        if (!user.getPassword().equals(user.getVerifyPassword())) {
            errors.rejectValue("verifyPassword", "", PASSWORDS_MATCHING);
        }
    }
}