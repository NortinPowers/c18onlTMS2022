package by.tms.service;

import by.tms.model.User;

public interface UserService {

    void addUser(User user);

    User getUserByLogin(String login);

    Long getUserId(String login);
}