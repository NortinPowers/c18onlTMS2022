package by.tms.service;

public interface AuthenticatorService {

    boolean isVerifiedUser(String login, String password);
}