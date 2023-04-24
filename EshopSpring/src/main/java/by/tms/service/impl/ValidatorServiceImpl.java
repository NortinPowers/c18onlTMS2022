package by.tms.service.impl;

import by.tms.model.User;
import by.tms.service.ValidatorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static by.tms.utils.Constants.ErrorMessage.PASSWORDS_MATCHING;
import static by.tms.validator.ValidatorUtils.isPasswordInputVerify;

@Service
//@RequiredArgsConstructor
public class ValidatorServiceImpl implements ValidatorService {

//    private final UserService userService;

    @Override
    public List<String> getValidationErrorMessage(User user, String verifyPassword) {
        List<String> errorMessages = new ArrayList<>();
        if (!isPasswordInputVerify(user.getPassword(), verifyPassword)) {
            errorMessages.add(PASSWORDS_MATCHING);
//            errorMessages.add("The entered passwords do not match");
        }
       /* if (!isNewUserVerify(user.getLogin())) {
            errorMessages.add(EXISTING_USER);
//            errorMessages.add("User with such a login has already been registered");
        }
        if (!isNewEmailVerify(user.getEmail())) {
            errorMessages.add(EXISTING_EMAIL);
//            errorMessages.add("User with such an email has already been registered");
        }*/
        return errorMessages;
    }

  /*  private boolean isNewUserVerify(String login) {
        return userService.getUserByLogin(login).isEmpty();
//        return userService.getUserByLogin(login) == null;
    }

    private boolean isNewEmailVerify(String email) {
        return userService.getUserByEmail(email).isEmpty();
//        return userService.getUserByEmail(email) == null;
    }*/
}