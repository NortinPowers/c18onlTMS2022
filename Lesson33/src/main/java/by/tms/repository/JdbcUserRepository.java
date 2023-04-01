package by.tms.repository;

import by.tms.model.User;

public interface JdbcUserRepository extends BaseRepository {

    void addUser(User user);

    User getUserByLogin(String login);

    Long getUserId(String login);
}