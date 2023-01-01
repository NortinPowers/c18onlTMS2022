package by.tms;

import by.tms.model.Product;
import by.tms.model.Shop;
import by.tms.service.ShopService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static by.tms.utils.CommandPattern.*;

public class MainConsoleShop {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Product<Double>> products = new ArrayList<>();
        ShopService shopService = new ShopService(new Shop(products));
        shopService.addProduct(new Product(1L, "phone", 1200));
        shopService.addProduct(new Product(2L, "radio", 600.30));
        shopService.addProduct(new Product(3L, "TV", 1850));
        System.out.println(products);
        boolean shopIsOpen = true;
        String commandLevel1;
        String commandLevel2;
        String commandLevel3;
        String enterMessage = "enter the command:\n" + PRODUCTS + " <to display a sorted list of products>\n" +
                ADDING + "   <to add a new product to the list>\n" +
                EXIT + "     <to exit>";
        String errorMessage = "you entered the wrong command in the console";
        String sortType = "enter the sort type";
        String sortDirection = "enter the sorting direction (" + UP + " or " + DOWN + ")";
        while (shopIsOpen) {
            System.out.println(enterMessage);
            commandLevel1 = scanner.next().toLowerCase();
            switch (commandLevel1) {
                case PRODUCTS:
                    System.out.println(sortType + " (" + ID + " or " + PRICE + ")");
                    commandLevel2 = scanner.next().toLowerCase();
                    if (commandLevel2.equals(PRICE) || commandLevel2.equals(ID)) {
                        System.out.println(sortDirection);
                        commandLevel3 = scanner.next().toLowerCase();
                        if (commandLevel3.equals(UP) || commandLevel3.equals(DOWN)) {
                            switch (commandLevel2) {
                                case PRICE -> {
                                    switch (commandLevel3) {
                                        case UP -> {
                                            Collections.sort(products);
                                            System.out.println(products);
                                        }
                                        case DOWN -> {
                                            products.sort(Comparator.comparing(Product<Double>::getPrice).reversed());
                                            System.out.println(products);
                                        }
                                    }
                                }
                                case ID -> {
                                    switch (commandLevel3) {
                                        case UP -> {
                                            products.sort(Comparator.comparing(Product<Double>::getId));
                                            System.out.println(products);
                                        }
                                        case DOWN -> {
                                            products.sort(Comparator.comparing(Product<Double>::getId).reversed());
                                            System.out.println(products);
                                        }
                                    }
                                }
                            }
                        } else {
                            System.out.println(errorMessage);
                            continue;
                        }
                    }
                    break;
                case ADDING:
//                some logic...
                    break;
                case EXIT:
                    shopIsOpen = false;
                    break;
                default:
                    System.out.println(errorMessage);
                    continue;
            }
            System.out.println();
        }
    }
}