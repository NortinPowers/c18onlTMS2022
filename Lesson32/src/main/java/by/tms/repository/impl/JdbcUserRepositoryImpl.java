package by.tms.repository.impl;

import by.tms.model.User;
import by.tms.repository.ConnectionPool;
import by.tms.repository.JdbcUserRepository;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JdbcUserRepositoryImpl implements JdbcUserRepository {

    private ConnectionPool connectionPool;
    private static final String ADD_USER = "insert into users (login, password, name, surname, email, birthday) values (?, ?, ?, ?, ?, ?)";
    private static final String GET_USER_BY_LOGIN = "select * from users where login=?";
    private static final String GET_USER_ID = "select id from users where login=?";

    @Override
    public void addUser(User user) {
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(ADD_USER);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.setString(5, user.getEmail());
            statement.setDate(6, Date.valueOf(user.getBirthday()));
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception (addUser()): " + e.getMessage());
        } finally {
            if (connectionPool != null) {
                try {
                    connectionPool.closeConnection(connection);
                } catch (Exception e) {
                    System.out.println("Exception (addUser().connectionPool): " + e.getMessage());
                }
            }
        }
    }

    @Override
    public User getUserByLogin(String login) {
        User user = null;
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_USER_BY_LOGIN);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String email = resultSet.getString("email");
                LocalDate birthday = LocalDate.parse(resultSet.getString("birthday"));
                user = User.builder()
                           .id(id)
                           .login(login)
                           .password(password)
                           .name(name)
                           .surname(surname)
                           .email(email)
                           .birthday(birthday)
                           .build();
            }
        } catch (Exception e) {
            System.out.println("Exception (getUser()): " + e.getMessage());
        } finally {
            if (connectionPool != null) {
                try {
                    connectionPool.closeConnection(connection);
                } catch (Exception e) {
                    System.out.println("Exception (getUser().connectionPool): " + e.getMessage());
                }
            }
        }
        return user;
    }

    @Override
    public Long getUserId(String login) {
        Long id = null;
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_USER_ID);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getLong("id");
            }
        } catch (Exception e) {
            System.out.println("Exception (getUserId()): " + e.getMessage());
        } finally {
            if (connectionPool != null) {
                try {
                    connectionPool.closeConnection(connection);
                } catch (Exception e) {
                    System.out.println("Exception (getUserId().connectionPool): " + e.getMessage());
                }
            }
        }
        return id;
    }
}