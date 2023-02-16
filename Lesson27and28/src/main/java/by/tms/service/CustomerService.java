package by.tms.service;

import by.tms.model.User;
import by.tms.repository.JdbcCustomerRepositoryAware;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CustomerService implements CustomerServiceAware {
    private JdbcCustomerRepositoryAware jdbsCustomerRepository;

    @Override
    public List<User> getUsers() {
        return jdbsCustomerRepository.getUsers();
    }

    @Override
    public void addUser(User user) {
        jdbsCustomerRepository.addUser(user);
    }

    @Override
    public Long getUserId(String login) {
        return jdbsCustomerRepository.getUserId(login);
    }
}