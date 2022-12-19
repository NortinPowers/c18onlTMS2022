package by.tms.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Validator {
    public static boolean isNotValidationAuthorization(String parameter) {
        return !(parameter.matches("([a-zA-Z_0-9]){0,20}$"));
    }
}