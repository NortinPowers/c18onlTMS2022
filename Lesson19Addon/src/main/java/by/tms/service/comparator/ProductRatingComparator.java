package by.tms.service.comparator;

import by.tms.model.Product;

import java.util.Comparator;

public class ProductRatingComparator implements Comparator<Product> {

    @Override
    public int compare(Product product1, Product product2) {
        return product1.getRating().compareTo(product2.getRating());
    }
}