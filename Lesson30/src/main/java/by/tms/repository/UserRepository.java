package by.tms.repository;

import by.tms.model.User;
import java.util.List;

public interface UserRepository {

    List<User> getUsers();

    void addUser(User user);

    Long getUserId(String login);
}