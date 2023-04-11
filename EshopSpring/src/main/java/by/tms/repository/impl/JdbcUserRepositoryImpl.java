package by.tms.repository.impl;

import by.tms.mapper.UserMapper;
import by.tms.model.User;
import by.tms.repository.JdbcUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
//@AllArgsConstructor
@Repository
@RequiredArgsConstructor
@Lazy
public class JdbcUserRepositoryImpl implements JdbcUserRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String GET_USER_BY_LOGIN = "select * from users where login=?";

//    private static final String ADD_USER = "insert into users (login, password, name, surname, email, birthday) values (?, ?, ?, ?, ?, ?)";
//    private static final String GET_USER_ID = "select id from users where login=?";

    @Override
    public User getUserByLogin(String login) {
        return jdbcTemplate.query(GET_USER_BY_LOGIN, new UserMapper(), login).stream()
                .findAny()
                .orElse(null);

        //need default constructor ??
//        return jdbcTemplate.query(GET_USER_BY_LOGIN, new BeanPropertyRowMapper<>(User.class), login).stream()
//                .findAny()
//                .orElse(null);

//        User user = null;
//        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(GET_USER_BY_LOGIN)) {
//            statement.setString(1, login);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                user = User.builder()
//                           .id(resultSet.getLong("id"))
//                           .login(login)
//                           .password(resultSet.getString("password"))
//                           .name(resultSet.getString("name"))
//                           .surname(resultSet.getString("surname"))
//                           .email(resultSet.getString("email"))
//                           .birthday(LocalDate.parse(resultSet.getString("birthday")))
//                           .build();
//            }
//        } catch (Exception e) {
//            log.error("Exception (getUser()): ", e);
//        }
//        return user;
    }


//    @Override
//    public void addUser(User user) {
//        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//             PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(ADD_USER)) {
//            statement.setString(1, user.getLogin());
//            statement.setString(2, user.getPassword());
//            statement.setString(3, user.getName());
//            statement.setString(4, user.getSurname());
//            statement.setString(5, user.getEmail());
//            statement.setDate(6, Date.valueOf(user.getBirthday()));
//            statement.executeUpdate();
//        } catch (Exception e) {
//            log.error("Exception (addUser()): ", e);
//        }
//    }
//
//    @Override
//    public Long getUserId(String login) {
//        Long id = null;
//        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(GET_USER_ID)) {
//            statement.setString(1, login);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                id = resultSet.getLong("id");
//            }
//        } catch (Exception e) {
//            log.error("Exception (getUserId()): ", e);
//        }
//        return id;
//    }
}