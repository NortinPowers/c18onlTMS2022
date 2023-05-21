package by.tms.service;

import by.tms.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserByLogin(String login);

    void addUser(User user);

    Optional<User> getVerifyUser(String login, String email);
}