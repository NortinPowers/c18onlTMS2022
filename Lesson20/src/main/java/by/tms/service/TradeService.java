package by.tms.service;

import by.tms.model.Customer;
import by.tms.model.Shop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.Semaphore;

import static by.tms.utils.Constants.PAYMENT_TIME_FOR_PURCHASES;
import static by.tms.utils.Constants.PROCESSING_TIME_OF_ONE_PRODUCT;

@AllArgsConstructor
@Getter
@ToString
public class TradeService implements Runnable {
    private Customer customer;
    private Shop shop;
    private Semaphore semaphore;

    @Override
    public void run() {
        Long customerId = customer.getId();
        try {
            System.out.println("Customer " + customerId + " coming to the registers");
            semaphore.acquire();
            System.out.println("Customer " + customerId + " lays out the goods");
            Thread.sleep(customer.getProducts().size() * PROCESSING_TIME_OF_ONE_PRODUCT + PAYMENT_TIME_FOR_PURCHASES);
            System.out.println("Customer " + customerId + " purchased the following products: " + customer.getProducts());
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        semaphore.release();
        System.out.println("Customer " + customerId + " leaves the store");
    }
}