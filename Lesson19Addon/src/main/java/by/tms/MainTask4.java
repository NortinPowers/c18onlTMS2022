package by.tms;

import static by.tms.utils.ProductsCategories.PHONES;
import static by.tms.utils.ProductsCategories.WATCHES;
import static by.tms.utils.ProductsParameters.NAME;
import static by.tms.utils.ProductsParameters.PRICE;
import static by.tms.utils.ProductsParameters.RATING;

import by.tms.service.IShop;
import by.tms.service.Shop;

public class MainTask4 {

    public static void main(String[] args) {
        IShop shop = new Shop();
        System.out.println(shop.getSortedByParameter(WATCHES, NAME));
        System.out.println(shop.getSortedByParameter(PHONES, PRICE));
        System.out.println(shop.getSortedByParameter(WATCHES, RATING));
        System.out.println(shop.getSortedByParameter(PHONES, RATING));
    }
}