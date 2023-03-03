package by.tms.service;

import by.tms.model.User;
import java.util.List;

public interface UserService {

    List<User> getUsers();

    void addUser(User user);

    Long getUserId(String login);
}