package by.tms.repository;

import by.tms.model.User;

public interface UserRepository {

    void addUser(User user);

    User getUserByLogin(String login);
}