package by.tms.service.impl;

import by.tms.model.User;
import by.tms.repository.JdbcUserRepository;
import by.tms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Lazy
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