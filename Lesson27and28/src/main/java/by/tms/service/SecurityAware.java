package by.tms.service;

public interface SecurityAware {

    boolean isVerifiedUser(String name, String password);
}