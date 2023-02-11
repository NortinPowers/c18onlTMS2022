package by.tms.service;

import by.tms.model.Authenticator;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class SecurityService implements SecurityAware {
    private Authenticator authenticator;

    @Override
    public boolean isVerifiedUser(String name, String password) {
        Map<String, String> authenticators = authenticator.getAuthenticators();
        for (Map.Entry<String, String> entry : authenticators.entrySet()) {
            if (entry.getKey().equals(name) && entry.getValue().equals(password)) {
                return true;
            }
        }
        return false;
    }
}