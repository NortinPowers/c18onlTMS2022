package by.tms.service.impl;

import by.tms.model.Authenticator;
import by.tms.service.SecurityService;
import java.util.Map;
import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityServiceImpl implements SecurityService {

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