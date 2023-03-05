package by.tms.service;

import java.util.Map;

public interface AuthenticatorService {

    void fillAuthenticatorMap();

    Map<String, String> getAuthenticatorMap();
}