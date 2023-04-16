package by.tms.service.impl;

import by.tms.model.User;
import by.tms.service.UserService;
import by.tms.service.ValidatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static by.tms.utils.ValidatorUtils.*;

@Service
@RequiredArgsConstructor
@Lazy
public class ValidatorServiceImpl implements ValidatorService {

    private final UserService userService;

    @Override
    public List<String> getValidationErrorMessage(User user, String verifyPassword) {
        List<String> errorMessages = new ArrayList<>();
        if (!isLoginVerify(user.getLogin())) {
            errorMessages.add("Incorrect login");
        }
        if (!isPasswordVerify(user.getPassword())) {
            errorMessages.add("Incorrect password");
        }
        if (!isNameVerify(user.getName())) {
            errorMessages.add("Incorrect name");
        }
        if (!isSurnameVerify(user.getSurname())) {
            errorMessages.add("Incorrect surname");
        }
        if (!isEmailVerify(user.getEmail())) {
            errorMessages.add("Incorrect email");
        }
        if (!isAgeVerify(user.getBirthday())) {
            errorMessages.add("Registration is available from the age of 18");
        }
        if (!isPasswordInputVerify(user.getPassword(), verifyPassword)) {
            errorMessages.add("The entered passwords do not match");
        }
        if (!isNewUserVerify(user.getLogin())) {
            errorMessages.add("User with such a login has already been registered");
        }
        if (!isNewEmailVerify(user.getEmail())) {
            errorMessages.add("User with such an email has already been registered");
        }
        return errorMessages;
    }

    private boolean isNewUserVerify(String login) {
        return userService.getUserByLogin(login) == null;
    }

    private boolean isNewEmailVerify(String email) {
        return userService.getUserByEmail(email) == null;
    }
}