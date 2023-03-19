package by.tms.utils;

import by.tms.model.User;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidatorUtils {

    public static boolean isAgeVerify(LocalDate birthday) {
        return Period.between(birthday, LocalDate.now()).getYears() > 17;
    }

    public static boolean isEmailVerify(String email) {
        return email.matches("[a-zA-z0-9]{1,20}[@][a-zA-Z]{3,10}[\\.][a-zA-Z]{2,6}");
    }

    public static boolean isNameSurnameVerify(String name, String surname) {
        return name.matches("[A-Za-z]{3,29}") && surname.matches("[A-Za-z]{3,29}");
    }

    public static boolean isLoginPasswordVerify(String login, String password) {
        return login.matches("[a-zA-Z0-9]{4,30}") && password.matches("[a-zA-Z0-9]{4,30}");
    }

    public static List<String> isVerifyUserData(User user) {
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
        return errorMessages;
    }
}