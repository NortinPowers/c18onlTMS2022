package by.tms.eshop.validator;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidatorUtils {

    public static boolean isPasswordInputVerify(String password, String verifyPassword) {
        return password.equals(verifyPassword);
    }
}