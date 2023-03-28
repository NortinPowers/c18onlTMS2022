package by.tms.service.impl;

import by.tms.model.Inject;
import by.tms.model.User;
import by.tms.repository.JdbcUserRepository;
import by.tms.service.UserService;
import lombok.Setter;

@Setter
public class UserServiceImpl implements UserService {

    @Inject
    private JdbcUserRepository jdbcUserRepository;

    @Override
    public void addUser(User user) {
        jdbcUserRepository.addUser(user);
    }

    @Override
    public User getUserByLogin(String login) {
        return jdbcUserRepository.getUserByLogin(login);
    }

    @Override
    public Long getUserId(String login) {
        return jdbcUserRepository.getUserId(login);
    }

    @Override
    public boolean isVerifiedUser(String login, String password) {
        return getUserByLogin(login) != null;
    }
}