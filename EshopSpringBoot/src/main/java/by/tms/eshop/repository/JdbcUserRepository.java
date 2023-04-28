package by.tms.eshop.repository;

import by.tms.eshop.model.User;

public interface JdbcUserRepository {

    User getUserByLogin(String login);

    void addUser(User user);

    User getUserByEmail(String email);
}