package by.tms.repository.impl;

import by.tms.model.User;
import by.tms.repository.JdbcUserRepository;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JdbcUserRepositoryImpl implements JdbcUserRepository {

    private Connection connection;
    private static final String ADD_USER = "insert into users (login, password, name, surname, email, birthday) values (?, ?, ?, ?, ?, ?)";
    private static final String GET_USER_BY_LOGIN = "select * from users where login=?";
    private static final String GET_USER_ID = "select id from users where login=?";

    @Override
    public void addUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_USER);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.setString(5, user.getEmail());
            statement.setDate(6, Date.valueOf(user.getBirthday()));
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException (addUser): " + e.getMessage());
        }
    }

    @Override
    public User getUserByLogin(String login) {
        User user = null;
        try {
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
        } catch (SQLException e) {
            System.out.println("SQLException (getUser): " + e.getMessage());
        }
        return user;
    }

    @Override
    public Long getUserId(String login) {
        Long id = null;
        try {
            PreparedStatement statement = connection.prepareStatement(GET_USER_ID);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getLong("id");
            }
        } catch (SQLException e) {
            System.out.println("SQLException (getUserId): " + e.getMessage());
        }
        return id;
    }
}