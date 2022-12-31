package by.tms.service;

import by.tms.model.Product;
import lombok.NonNull;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(@NonNull Product product1, @NonNull Product product2) {
        long result = product1.getId() - (product2.getId());
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}