package by.tms;

import static by.tms.utils.WeightFilters.EQUAL;
import static by.tms.utils.WeightFilters.GREATER;
import static by.tms.utils.WeightFilters.LESS;

import by.tms.service.BoxSorterAware;
import by.tms.service.Storage;

public class MainTask2 {

    public static void main(String[] args) {
        BoxSorterAware storage = new Storage();
        System.out.println(storage.getHeavyBoxesFromWeight(500, GREATER));
        System.out.println(storage.getHeavyBoxesFromWeight(500, EQUAL));
        System.out.println(storage.getHeavyBoxesFromWeight(500, LESS));
    }
}