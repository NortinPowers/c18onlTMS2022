package by.tms.service;

import by.tms.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserByLogin(String login);
//    User getUserByLogin(String login);

    void addUser(User user);

    Optional<User> getUserByEmail(String email);
//    User getUserByEmail(String email);
}