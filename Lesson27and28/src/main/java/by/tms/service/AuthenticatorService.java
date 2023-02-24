package by.tms.service;

import by.tms.model.Authenticator;
import by.tms.model.User;
import java.util.Map;
import lombok.AllArgsConstructor;

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