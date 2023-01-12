package by.tms;

import by.tms.service.Storage;

import static by.tms.utils.WeightFilter.*;

public class MainTask2 {
    public static void main(String[] args) {
        Storage storage = new Storage();
        System.out.println(storage.getHeavyBoxesFromWeight(500, GREATER));
        System.out.println(storage.getHeavyBoxesFromWeight(500, EQUAL));
        System.out.println(storage.getHeavyBoxesFromWeight(500, LESS));
    }
}