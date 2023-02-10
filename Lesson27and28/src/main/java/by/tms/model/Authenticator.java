package by.tms.model;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

@AllArgsConstructor
public class Authenticator {
    private Map<String, String> authenticators;

    public Map<String, String> getAuthenticators() {
        return nonNull(authenticators) ? authenticators : new HashMap<>();
    }
}