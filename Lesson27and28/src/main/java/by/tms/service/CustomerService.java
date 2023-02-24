package by.tms.service;

import by.tms.model.User;
import by.tms.repository.JdbcCustomerRepositoryAware;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerService implements CustomerServiceAware {

    private JdbcCustomerRepositoryAware jdbcCustomerRepository;

    @Override
    public List<User> getUsers() {
        return jdbcCustomerRepository.getUsers();
    }

    @Override
    public void addUser(User user) {
        jdbcCustomerRepository.addUser(user);
    }

    @Override
    public Long getUserId(String login) {
        return jdbcCustomerRepository.getUserId(login);
    }
}