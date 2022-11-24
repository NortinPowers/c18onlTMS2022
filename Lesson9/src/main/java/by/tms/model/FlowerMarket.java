package by.tms.model;

import by.tms.utils.FlowerType;

public class FlowerMarket {
    public Bouquet getBouquet(FlowerType... flowers) {
        Flower[] bouquetFlowers = new Flower[flowers.length];
        for (int i = 0; i < bouquetFlowers.length; i++) {
            bouquetFlowers[i] = new Flower(flowers[i].getName(), flowers[i].getCost());
        }
        return new Bouquet(bouquetFlowers);
    }
}
