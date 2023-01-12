package by.tms.model;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
public class Customer {
    private final Long ID;
    private final List<Product> products;

    public Customer(Long ID, List<Product> products) {
        if (products == null) {
            products = new ArrayList<>();
        }
        this.ID = ID;
        this.products = products;
    }
}