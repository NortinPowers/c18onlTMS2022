package by.tms.service.comparator;

import by.tms.model.Product;

import java.util.Comparator;

public class ProductNameComparator implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return product1.getName().compareToIgnoreCase(product2.getName());
    }
}