package by.tms.model;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

@Getter
public class Authenticator {
    private final Map<String, String> authenticators;

    public Authenticator(Map<String, String> authenticators) {
        this.authenticators = nonNull(authenticators) ? authenticators : new HashMap<>();
    }
}