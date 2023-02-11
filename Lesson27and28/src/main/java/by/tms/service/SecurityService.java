package by.tms.service;

import by.tms.model.Authenticator;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
public class SecurityService implements SecurityAware {
    private Authenticator authenticator;

    @Override
    public boolean isVerifiedUser(String name, String password) {
        Map<String, String> authenticators = authenticator.getAuthenticators();
        if (authenticators != null && authenticators.containsKey(name)) {
            return Objects.equals(authenticators.get(name), password);
        }
        return false;
    }
}