package by.tms.model;

import static java.util.Objects.nonNull;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Authenticator {

    private Map<String, String> authenticators;

    public Map<String, String> getAuthenticators() {
        return nonNull(authenticators) ? authenticators : new HashMap<>();
    }
}