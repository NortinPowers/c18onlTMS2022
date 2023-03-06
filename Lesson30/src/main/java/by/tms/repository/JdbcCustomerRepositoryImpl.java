package by.tms.repository;

import by.tms.model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JdbcCustomerRepositoryImpl implements UserRepository {

    private Connection connection;
    private static final String ADD_USER = "insert into users (login, password, name, surname, email, birthday) values (?, ?, ?, ?, ?, ?)";
    private static final String GET_USER_BY_LOGIN = "select login, password from users where login=?";

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
                String password = resultSet.getString("password");
                user = User.builder()
                           .login(login)
                           .password(password)
                           .build();
            }
        } catch (SQLException e) {
            System.out.println("SQLException (getUser): " + e.getMessage());
        }
        return user;
    }
}