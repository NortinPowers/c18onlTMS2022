package by.tms.service;

import by.tms.model.User;

public interface UserService {

    User getUserByLogin(String login);

    void addUser(User user);

    User getUserByEmail(String email);
}