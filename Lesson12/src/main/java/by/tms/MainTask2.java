package by.tms;

import by.tms.exception.WrongLoginException;
import by.tms.exception.WrongPasswordException;

import static by.tms.utils.Validator.isNotValidationAuthorization;

public class MainTask2 {

    public static void main(String[] args) {
        System.out.println("Authorization status: " + checkAuthorization("TestUser", "Password", "Password"));
        System.out.println("Authorization status: " + checkAuthorization("TestUser1", "PasswordA", "Password"));
    }

    public static boolean checkAuthorization(String login, String password, String confirmPassword) {
        try {
            if (isNotValidationAuthorization(login)) {
                throw new WrongLoginException("Login exception");
            }
            if (isNotValidationAuthorization(password) || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("Password exception");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.print("Authorization exception: " + e.getMessage() + "! ");
            return false;
        }
        return true;
    }
}
