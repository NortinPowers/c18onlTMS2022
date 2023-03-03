package by.tms.model;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Authenticator {

    private Map<String, String> authenticators;

    public Map<String, String> getAuthenticators() {
        return authenticators == null ? new HashMap<>() : authenticators;
    }
}