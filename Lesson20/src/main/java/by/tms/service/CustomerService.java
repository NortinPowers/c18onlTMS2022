package by.tms.service;

import by.tms.model.Customer;
import by.tms.model.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;

@Getter
public class CustomerService {

    private List<Customer> customers;

    public CustomerService() {
        init();
    }

    private void init() {
        customers = new ArrayList<>();
        customers.add(new Customer(1L, Arrays.asList(new Product("TV", new BigDecimal("300")), new Product("Phone", new BigDecimal("100")))));
        customers.add(new Customer(2L, Arrays.asList(new Product("Radio", new BigDecimal("150")), new Product("Phone", new BigDecimal("200")))));
        customers.add(new Customer(3L, Arrays.asList(new Product("Apple", new BigDecimal("20")), new Product("Bag", new BigDecimal("30")),
                                                     new Product("Mouse", new BigDecimal("160")), new Product("TV", new BigDecimal("300")), new Product("Phone", new BigDecimal("100")),
                                                     new Product("Lamp", new BigDecimal("80")), new Product("Cup", new BigDecimal("20")))));
        customers.add(new Customer(4L, List.of(new Product("Pen", new BigDecimal("5")))));
        customers.add(new Customer(5L, Arrays.asList(new Product("Table", new BigDecimal("60")), new Product("Lamp", new BigDecimal("80")),
                                                     new Product("Cup", new BigDecimal("20")), new Product("Copybook", new BigDecimal("55")))));
    }
}