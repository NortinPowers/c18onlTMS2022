package by.tms.service;

import by.tms.model.Authenticator;
import by.tms.model.User;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class AuthenticatorService implements AuthenticatorServiceAware {
    private CustomerServiceAware customerService;
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