package by.tms.service;

import by.tms.model.User;
import by.tms.repository.JdbsCustomerRepositoryAware;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CustomerService implements CustomerServiceAware {
    private JdbsCustomerRepositoryAware jdbsCustomer;

    @Override
    public List<User> getUsers() {
        return jdbsCustomer.getUsers();
    }

    @Override
    public void addUser(User user) {
        jdbsCustomer.addUser(user);
    }
}