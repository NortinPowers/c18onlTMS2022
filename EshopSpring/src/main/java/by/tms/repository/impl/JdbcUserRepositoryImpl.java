package by.tms.repository.impl;

import by.tms.mapper.UserMapper;
import by.tms.model.User;
import by.tms.repository.JdbcUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class JdbcUserRepositoryImpl implements JdbcUserRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String GET_USER_BY_LOGIN = "select * from users where login=?";
    private static final String GET_USER_BY_LOGIN_OR_EMAIL = "select * from users where login=? or email=?";
    private static final String ADD_USER = "insert into users (login, password, name, surname, email, birthday) values (?, ?, ?, ?, ?, ?)";

    @Override
    public Optional<User> getUserByLogin(String login) {
        return jdbcTemplate.query(GET_USER_BY_LOGIN, new UserMapper(), login).stream()
                .findAny();
    }

    @Override
    public void addUser(User user) {
        jdbcTemplate.update(ADD_USER, user.getLogin(), user.getPassword(), user.getName(), user.getSurname(),
                user.getEmail(), user.getBirthday());
    }

    @Override
    public Optional<User> getVerifyUser(String login, String email) {
        return jdbcTemplate.query(GET_USER_BY_LOGIN_OR_EMAIL, new UserMapper(), login, email).stream()
                .findAny();
    }
}