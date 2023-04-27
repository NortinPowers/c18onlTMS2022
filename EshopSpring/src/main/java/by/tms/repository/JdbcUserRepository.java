package by.tms.repository;

import by.tms.model.User;

import java.util.Optional;

public interface JdbcUserRepository {

    Optional<User> getUserByLogin(String login);

    void addUser(User user);

    Optional<User> getUserByEmail(String email);
}