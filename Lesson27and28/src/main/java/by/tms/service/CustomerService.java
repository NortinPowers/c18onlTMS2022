package by.tms.service;

import by.tms.model.User;
import by.tms.repository.JdbsCustomerRepositoryAware;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CustomerService implements CustomerServiceAware {
    private JdbsCustomerRepositoryAware jdbsCustomerRepository;

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