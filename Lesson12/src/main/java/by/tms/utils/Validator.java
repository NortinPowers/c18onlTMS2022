package by.tms.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Validator {
    public boolean isNotValidationAuthorization(String login) {
        return !(login.matches("([a-zA-Z_0-9])+$") && login.length() < 20);
    }
}
