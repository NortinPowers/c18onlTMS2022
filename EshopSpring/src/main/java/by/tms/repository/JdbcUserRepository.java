package by.tms.repository;

import by.tms.model.User;

public interface JdbcUserRepository extends BaseRepository {

    User getUserByLogin(String login);

    void addUser(User user);

    User getUserByEmail(String email);
//
//    Long getUserId(String login);
}