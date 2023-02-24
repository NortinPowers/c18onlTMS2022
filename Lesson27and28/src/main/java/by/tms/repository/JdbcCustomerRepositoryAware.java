package by.tms.repository;

import by.tms.model.User;
import java.util.List;

public interface JdbcCustomerRepositoryAware {

    List<User> getUsers();

    void addUser(User user);

    Long getUserId(String login);
}