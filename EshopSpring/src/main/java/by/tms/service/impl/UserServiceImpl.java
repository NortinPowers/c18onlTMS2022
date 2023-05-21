package by.tms.service.impl;

import by.tms.model.User;
import by.tms.repository.JdbcUserRepository;
import by.tms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final JdbcUserRepository jdbcUserRepository;

    @Override
    public Optional<User> getUserByLogin(String login) {
        return jdbcUserRepository.getUserByLogin(login);
    }

    @Override
    public void addUser(User user) {
        jdbcUserRepository.addUser(user);
    }

    @Override
    public Optional<User> getVerifyUser(String login, String email) {
        return jdbcUserRepository.getVerifyUser(login, email);
    }
}