package by.tms.service;

import by.tms.model.User;

public interface UserService {

//    boolean isVerifiedUser(String login, String password);

    User getUserByLogin(String login);


    void addUser(User user);

    User getUserByEmail(String email);
//
//    Long getUserId(String login);
}