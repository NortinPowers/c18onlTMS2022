package by.tms.service;

public interface SecurityAware {

    Boolean isVerifiedUser(String name, String password);
}