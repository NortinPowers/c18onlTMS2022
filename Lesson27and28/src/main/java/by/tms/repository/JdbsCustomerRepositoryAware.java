package by.tms.repository;

import by.tms.model.User;

import java.util.List;

public interface JdbsCustomerRepositoryAware {
    List<User> getUsers();

    void addUser(User user);

}
