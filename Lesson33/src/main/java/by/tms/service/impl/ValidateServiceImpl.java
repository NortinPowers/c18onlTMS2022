package by.tms.service.impl;

import static by.tms.utils.ValidatorUtils.isAgeVerify;
import static by.tms.utils.ValidatorUtils.isEmailVerify;
import static by.tms.utils.ValidatorUtils.isLoginPasswordVerify;
import static by.tms.utils.ValidatorUtils.isNameSurnameVerify;

import by.tms.model.Inject;
import by.tms.model.User;
import by.tms.service.UserService;
import by.tms.service.ValidateService;
import java.util.ArrayList;
import java.util.List;
import lombok.Setter;

@Setter
public class ValidateServiceImpl implements ValidateService {

    @Inject
    private UserService userService;

    @Override
    public List<String> getValidationErrorMessage(User user, String verifyPassword) {
        List<String> errorMessages = new ArrayList<>();
        if (!isLoginPasswordVerify(user.getLogin(), user.getPassword())) {
            errorMessages.add("Incorrect login or password");
        }
        if (!isNameSurnameVerify(user.getName(), user.getSurname())) {
            errorMessages.add("Incorrect name or surname");
        }
        if (!isEmailVerify(user.getEmail())) {
            errorMessages.add("Incorrect email");
        }
        if (!isAgeVerify(user.getBirthday())) {
            errorMessages.add("Registration is available from the age of 18");
        }
        if (!isNewUserVerify(user.getLogin(), user.getPassword(), verifyPassword)) {
            errorMessages.add("This user already exist");
        }
        return errorMessages;
    }

    private boolean isNewUserVerify(String login, String password, String verifyPassword) {
        if (userService.getUserByLogin(login) == null) {
            return password.equals(verifyPassword);
        }
        return false;
    }
}
