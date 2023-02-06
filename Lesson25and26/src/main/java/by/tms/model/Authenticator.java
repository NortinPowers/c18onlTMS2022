package by.tms.model;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;
public class Authenticator {
    private Map<String, String> authenticators;

    public Map<String, String> getAuthenticators() {
        return nonNull(authenticators) ? authenticators : new HashMap<>();
    }
}