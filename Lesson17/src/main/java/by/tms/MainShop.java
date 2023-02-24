package by.tms;

import by.tms.comparator.ProductIdComparator;
import by.tms.model.Product;
import by.tms.model.Shop;
import by.tms.service.ShopService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainShop {

    public static void main(String[] args) {
        ArrayList<Product<Double>> products = new ArrayList<>();
        {
            Product<Double> product = new Product<>(1L, "phone", 1200.0);
            products.add(product);
        }
        {
            Product<Double> product = new Product<>(2L, "radio", 600.30);
            products.add(product);
        }
        {
            Product<Double> product = new Product<>(3L, "TV", 1850.0);
            products.add(product);
        }
        {
            Product<Double> product = new Product<>(4L, "watch", 522.5);
            products.add(product);
        }
        ShopService shopService = new ShopService(new Shop(products));
        System.out.println(shopService.getAllProduct());
        Collections.sort(products);
        System.out.println(shopService.getAllProduct());
        if (!shopService.addProduct(new Product<>(3L, "TV", 1850.0))) {
            System.out.println("such a product already exists");
        }
        if (!shopService.addProduct(new Product<>(5L, "battery", 50.0))) {
            System.out.println("Product with this ID already exists");
        }
        System.out.println(shopService.getAllProduct());
        shopService.deleteProduct(2L);
        System.out.println(shopService.getAllProduct());
        Comparator<Product<Double>> ascendingProductId = new ProductIdComparator();
        products.sort(ascendingProductId);
        System.out.println(shopService.getAllProduct());
        shopService.changeProduct(1L, "toy", 200.5);
        System.out.println(shopService.getAllProduct());
    }
}