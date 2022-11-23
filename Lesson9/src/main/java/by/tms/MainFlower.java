package by.tms;

import by.tms.model.Bouquet;
import by.tms.model.Flower;
import by.tms.model.FlowerMarket;

import static by.tms.utils.FlowerType.*;

public class MainFlower {
    public static void main(String[] args) {
        FlowerMarket flowerMarket = new FlowerMarket();
        Bouquet bouquetOne = flowerMarket.getBouquet(ASTER, ROSE, IRIS);
        System.out.println(bouquetOne);
        System.out.println("Bouquet cost is " + bouquetOne.calculatePrice());
        Bouquet bouquetTwo = flowerMarket.getBouquet(LILY, GERBERA, DAISY);
        System.out.println(bouquetTwo);
        System.out.println("Bouquet cost is " + bouquetTwo.calculatePrice());
        Bouquet bouquetTree = flowerMarket.getBouquet(TULIP, CARNATION, PEONY);
        System.out.println(bouquetTree);
        System.out.println("Bouquet cost is " + bouquetTree.calculatePrice());
        System.out.println("Total flowers sold " + Flower.getFloverCount());
    }
}
