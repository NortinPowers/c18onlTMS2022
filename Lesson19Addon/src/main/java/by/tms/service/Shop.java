package by.tms.service;

import by.tms.model.Category;
import by.tms.model.Product;
import by.tms.service.comparator.ProductNameComparator;
import by.tms.service.comparator.ProductPriceComparator;
import by.tms.service.comparator.ProductRatingComparator;
import by.tms.utils.ProductsCategories;
import by.tms.utils.ProductsParameters;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static by.tms.utils.ProductsCategories.PHONES;
import static by.tms.utils.ProductsCategories.WATCHES;
import static by.tms.utils.ProductsParameters.NAME;
import static by.tms.utils.ProductsParameters.PRICE;

public class Shop implements IShop {

    private List<Category> categories;

    public Shop() {
        init();
    }

    private void init() {
        List<Product> phones = Arrays.asList(new Product("Samsung", new BigDecimal("300.50"), 7),
                                             new Product("Apple", new BigDecimal("600.30"), 8),
                                             new Product("OnePlus", new BigDecimal("400.25"), 6));
        Category phone = new Category(PHONES.name(), new ArrayList<>(phones));
        List<Product> watches = Arrays.asList(new Product("Samsung", new BigDecimal("100.30"), 6),
                                              new Product("Apple", new BigDecimal("150.80"), 9),
                                              new Product("Xiaomi", new BigDecimal("60.20"), 8));
        Category watch = new Category(WATCHES.name(), new ArrayList<>(watches));
        categories = new ArrayList<>();
        categories.add(phone);
        categories.add(watch);
    }

    @Override
    public List<Product> getSortedByParameter(Enum<ProductsCategories> type, Enum<ProductsParameters> parameter) {
        Comparator<Product> comparator;
        if (parameter == NAME) {
            comparator = new ProductNameComparator();
        } else if (parameter == PRICE) {
            comparator = new ProductPriceComparator();
        } else {
            comparator = new ProductRatingComparator();
        }
        return categories.stream()
                         .filter(category -> category.getName().equals(type.name()))
                         .flatMap(category -> category.getProducts().stream()
                                                      .sorted(comparator))
                         .toList();
    }
}