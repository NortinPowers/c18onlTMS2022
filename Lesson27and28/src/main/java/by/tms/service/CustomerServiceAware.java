package by.tms.service;

import by.tms.model.User;
import java.util.List;

public interface CustomerServiceAware {

    List<User> getUsers();

    void addUser(User user);

    Long getUserId(String login);
}