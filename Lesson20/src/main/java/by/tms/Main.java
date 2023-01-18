package by.tms;

import by.tms.model.Customer;
import by.tms.model.Shop;
import by.tms.service.CustomerService;
import by.tms.service.TradeService;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop(2);
        Semaphore semaphore = new Semaphore(shop.getRegisterCount());
        CustomerService customerService = new CustomerService();
        for (Customer customer : customerService.getCustomers()) {
            new Thread(new TradeService(customer, shop, semaphore)).start();
        }
    }
}