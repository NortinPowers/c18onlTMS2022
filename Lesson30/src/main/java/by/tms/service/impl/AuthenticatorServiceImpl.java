package by.tms.service.impl;

import by.tms.model.Authenticator;
import by.tms.model.User;
import by.tms.service.AuthenticatorService;
import by.tms.service.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthenticatorServiceImpl implements AuthenticatorService {

    private UserService userService;
    private Authenticator authenticator;

    private void putUser(User user) {
        authenticator.getAuthenticators().put(user.getLogin(), user.getPassword());
    }

    @Override
    public boolean isVerifiedUser(String login, String password) {
        User user = userService.getUserByLogin(login);
        if (user != null) {
            putUser(user);
            return true;
        }
        return false;
    }
}