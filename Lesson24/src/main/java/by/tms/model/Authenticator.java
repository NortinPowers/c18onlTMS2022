package by.tms.model;

import static java.util.Objects.nonNull;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public class Authenticator {

    private final Map<String, String> authenticators;

    public Authenticator(Map<String, String> authenticators) {
        this.authenticators = nonNull(authenticators) ? authenticators : new HashMap<>();
    }
}