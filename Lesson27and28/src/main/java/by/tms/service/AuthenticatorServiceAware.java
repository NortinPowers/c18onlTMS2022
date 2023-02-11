package by.tms.service;

import java.util.Map;

public interface AuthenticatorServiceAware {
    void fillAuthenticatorMap();

    Map<String, String> getAuthenticatorMap();
}
