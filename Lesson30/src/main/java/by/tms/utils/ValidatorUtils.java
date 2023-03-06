package by.tms.utils;

import java.time.LocalDate;
import java.time.Period;
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
}