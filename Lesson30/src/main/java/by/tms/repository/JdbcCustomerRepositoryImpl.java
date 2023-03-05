package by.tms.repository;

import by.tms.model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JdbcCustomerRepositoryImpl implements UserRepository {

    private Connection connection;
    private static final String GET_USERS = "select * from users";
    private static final String ADD_USER = "insert into users (login, password, name, surname, email, birthday) values (?, ?, ?, ?, ?, ?)";
    private static final String GET_USER_ID = "select id from users where login=?";

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_USERS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = User.builder()
                                .id(resultSet.getLong("id"))
                                .login(resultSet.getString("login"))
                                .password(resultSet.getString("password"))
                                .name(resultSet.getString("name"))
                                .surname(resultSet.getString("surname"))
                                .email(resultSet.getString("email"))
                                .birthday(LocalDate.parse(resultSet.getString("birthday")))
                                .build();
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("SQLException (getUsers): " + e.getMessage());
        }
        return users;
    }

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