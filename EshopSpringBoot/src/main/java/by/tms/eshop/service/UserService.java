package by.tms.eshop.service;

import by.tms.eshop.model.User;

public interface UserService {

    User getUserByLogin(String login);

    void addUser(User user);

    User getUserByEmail(String email);
}