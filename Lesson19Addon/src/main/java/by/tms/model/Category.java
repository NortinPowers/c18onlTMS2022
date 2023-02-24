package by.tms.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Category {

    private final String name;
    private final List<Product> products;

    public Category(String name, List<Product> products) {
        if (products == null) {
            products = new ArrayList<>();
        }
        this.name = name;
        this.products = products;
    }
}