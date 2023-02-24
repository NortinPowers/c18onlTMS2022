package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
public class Shop {

    private List<Product<Double>> products;

    public List<Product<Double>> getProducts() {
        if (products == null) {
            products = new ArrayList<>();
        }
        return products;
    }
}