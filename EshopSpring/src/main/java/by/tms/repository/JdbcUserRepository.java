package by.tms.repository;

import by.tms.model.User;

public interface JdbcUserRepository {

    User getUserByLogin(String login);

    void addUser(User user);

    User getUserByEmail(String email);
}