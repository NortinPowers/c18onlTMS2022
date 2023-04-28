package by.tms.eshop.service.impl;

import by.tms.eshop.model.User;
import by.tms.eshop.repository.JdbcUserRepository;
import by.tms.eshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final JdbcUserRepository jdbcUserRepository;

    @Override
    public User getUserByLogin(String login) {
        return jdbcUserRepository.getUserByLogin(login);
    }

    @Override
    public void addUser(User user) {
        jdbcUserRepository.addUser(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return jdbcUserRepository.getUserByEmail(email);
    }
}