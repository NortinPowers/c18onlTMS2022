package by.tms.model;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class Authenticator {
    private Map<String, String> authenticators;

    public Map<String, String> getAuthenticators() {
        if (authenticators == null) {
            authenticators = new HashMap<>();
        }
        return authenticators;
//        return nonNull(authenticators) ? authenticators : new HashMap<>();
    }
}