package by.tms;

import by.tms.model.Shop;
import by.tms.service.CustomerService;
import by.tms.service.TradeService;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

import static by.tms.utils.ThreadUtils.startedThreads;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop(2);
        Semaphore semaphore = new Semaphore(shop.getRegisterCount());
        CustomerService customerService = new CustomerService();
        List<Thread> threads = Arrays.asList(new Thread(new TradeService(customerService.getCustomers().get(0), shop, semaphore)),
                new Thread(new TradeService(customerService.getCustomers().get(1), shop, semaphore)),
                new Thread(new TradeService(customerService.getCustomers().get(2), shop, semaphore)),
                new Thread(new TradeService(customerService.getCustomers().get(3), shop, semaphore)),
                new Thread(new TradeService(customerService.getCustomers().get(4), shop, semaphore)));
        startedThreads(threads);
    }
}