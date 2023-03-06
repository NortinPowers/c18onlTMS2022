package by.tms.service;

import by.tms.model.User;

public interface AuthenticatorService {

    void putUser(User user);

    boolean isVerifiedUser(String login, String password);
}