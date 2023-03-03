package by.tms.service;

public interface SecurityService {

    boolean isVerifiedUser(String name, String password);
}