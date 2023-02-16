package by.tms.repository;

import by.tms.model.User;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class JdbcCustomerRepository implements JdbcCustomerRepositoryAware {
    private Connection connection;
    private static final String GET_USERS = "select * from customers";
    private static final String ADD_USER = "insert into customers (login, password) values (?, ?)";
    private static final String GET_USER_ID = "select id from customers where login=?";

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_USERS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                users.add(new User(id, login, password));
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