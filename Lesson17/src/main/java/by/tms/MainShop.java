package by.tms;

import by.tms.model.Product;
import by.tms.model.Shop;
import by.tms.service.ProductComparator;
import by.tms.service.ShopService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainShop {
    public static void main(String[] args) {
        ArrayList<Product<Double>> products = new ArrayList<>();
        {
            Product product = new Product(1L, "phone", 1200);
            products.add(product);
        }
        {
            Product product = new Product(2L, "radio", 600.30);
            products.add(product);
        }
        {
            Product product = new Product(3L, "TV", 1850);
            products.add(product);
        }
        {
            Product product = new Product(4L, "watch", 522.5);
            products.add(product);
        }
        ShopService shopService = new ShopService(new Shop(products));
        System.out.println(shopService.getAllProduct());
        Collections.sort(products);
        System.out.println(shopService.getAllProduct());
        shopService.addProduct(new Product(3L, "TV", 1850));
        System.out.println(shopService.getAllProduct());
        shopService.deleteProduct(2L);
        System.out.println(shopService.getAllProduct());
        Comparator ascendingProductId = new ProductComparator();
        Collections.sort(products, ascendingProductId);
        System.out.println(shopService.getAllProduct());
        shopService.changeProduct(1L, new Product(1L, "toy", 200.5));
        System.out.println(shopService.getAllProduct());
    }
}