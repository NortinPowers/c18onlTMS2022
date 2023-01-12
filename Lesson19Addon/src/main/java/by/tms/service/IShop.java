package by.tms.service;

import by.tms.model.Product;
import by.tms.utils.ProductsCategories;
import by.tms.utils.ProductsParameters;

import java.util.List;

public interface IShop {
    List<Product> getSortedByParameter(Enum<ProductsCategories> type, Enum<ProductsParameters> parameter);
}