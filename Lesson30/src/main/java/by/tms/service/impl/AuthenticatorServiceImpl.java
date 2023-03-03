package by.tms.service.impl;

import by.tms.model.Authenticator;
import by.tms.model.User;
import by.tms.service.AuthenticatorService;
import by.tms.service.UserService;
import java.util.Map;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthenticatorServiceImpl implements AuthenticatorService {

    private UserService customerService;
    private Authenticator authenticator;

    @Override
    public void fillAuthenticatorMap() {
        for (User user : customerService.getUsers()) {
            authenticator.getAuthenticators().put(user.getLogin(), user.getPassword());
        }
    }

    @Override
    public Map<String, String> getAuthenticatorMap() {
        return authenticator.getAuthenticators();
    }
}