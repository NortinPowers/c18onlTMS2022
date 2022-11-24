package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Bouquet {
    private Flower[] flowers;

    public int calculatePrice() {
        int bouquetCost = 0;
        for (Flower flower : flowers) {
            bouquetCost += flower.getPrice();
        }
        return bouquetCost;
    }
}
