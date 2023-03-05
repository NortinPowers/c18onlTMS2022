package by.tms.service.impl;

import by.tms.model.User;
import by.tms.repository.UserRepository;
import by.tms.service.UserService;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public Long getUserId(String login) {
        return userRepository.getUserId(login);
    }
}