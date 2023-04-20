package by.tms.validator;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidatorUtils {

//    public static boolean isAgeVerify(LocalDate birthday) {
//        return Period.between(birthday, LocalDate.now()).getYears() > 17;
//    }
//
//    public static boolean isEmailVerify(String email) {
//        return email.matches("[a-zA-z0-9]{1,20}[@][a-zA-Z]{3,10}[.][a-zA-Z]{2,6}");
//    }
//
//    public static boolean isNameVerify(String name) {
//        return name.matches("[A-Za-z]{3,29}");
//    }
//
//    public static boolean isSurnameVerify(String surname) {
//        return surname.matches("[A-Za-z]{3,29}");
//    }
//
//    public static boolean isLoginVerify(String login) {
//        return login.matches("[a-zA-Z0-9]{4,30}");
//    }
//
//    public static boolean isPasswordVerify(String password) {
//        return password.matches("[a-zA-Z0-9]{4,30}");
//    }

    public boolean isPasswordInputVerify(String password, String verifyPassword) {
        return password.equals(verifyPassword);
    }
}