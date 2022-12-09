package by.tms.service;

import by.tms.model.Bouquet;
import by.tms.model.Flower;
import by.tms.model.FlowerMarket;

import static by.tms.utils.FlowerType.*;

public class MainFlower {
    public static void main(String[] args) {
        FlowerMarket flowerMarket = new FlowerMarket();
        Bouquet bouquetOne = flowerMarket.getBouquet(ASTER);
        System.out.println(bouquetOne);
        System.out.println("Bouquet cost is " + bouquetOne.calculatePrice());
        Bouquet bouquetTwo = flowerMarket.getBouquet(LILY, GERBERA, DAISY);
        System.out.println(bouquetTwo);
        System.out.println("Bouquet cost is " + bouquetTwo.calculatePrice());
        Bouquet bouquetTree = flowerMarket.getBouquet(TULIP, CARNATION, PEONY, ROSE, IRIS);
        System.out.println(bouquetTree);
        System.out.println("Bouquet cost is " + bouquetTree.calculatePrice());
        Bouquet bouquetFour = flowerMarket.getBouquet(GERBERA, CARNATION, ASTER);
        System.out.println(bouquetFour);
        System.out.println("Bouquet cost is " + bouquetFour.calculatePrice());
        Bouquet bouquetFive = flowerMarket.getBouquet(ROSE, ASTER, PEONY);
        System.out.println(bouquetFive);
        System.out.println("Bouquet cost is " + bouquetFive.calculatePrice());
        System.out.println("Total flowers sold " + Flower.getFlowerCount());
    }
}

/*
 * Задача2: Цветочный магазин.
 * Создать класс "Flower", который содержит переменные имя и стоимость, гет сет и toString (lombok подключаем)
 * Необходимо:
 * 1) собрать 5 букетов (используем массив) с определением их стоимости, т.е создаем класс Bouquet,
 * который содержит массив объектов Flower, который инициализируется через конструктор, а также метод по вычислению стоимости.
 * 2) вывести на консоль информацию по каждому букету.
 * 3*звездочка) Подсчитать количество всех проданных цветов.
 * Пояснения решения:
 * Создать класс FlowerMarket, который содержит метод public Bouquet getBouquet(String... flowers),
 * Создать enum FlowerType c константами названия цветов.
 * Для создания букета в метод getBouquet нужно передавать константы через запятую(ROSE, ROSE, ROSE, ROSE, ROSE)
 * По названию константы enam создать объект класса Flower и поместить в массив,
 * для передачи его в класс букета.
 * Также в енам константах необходимо создать переменную cost(стоимость) типа int и прописать стоимость каждого цветка, гет, сет, конструктор!
 * ROSE - 15
 * LILY - 7
 * ASTER - 5
 * HERBERA - 5
 * TULIP - 8
 * CARNATION - 11
 */