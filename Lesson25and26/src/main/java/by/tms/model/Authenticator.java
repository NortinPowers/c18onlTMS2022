package by.tms.model;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class Authenticator {
    private Map<String, String> authenticators;

    public Map<String, String> getAuthenticators() {
        if (authenticators == null) {
            authenticators = new HashMap<>();
        }
        return authenticators;
    }
}