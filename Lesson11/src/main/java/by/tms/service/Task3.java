package by.tms.service;

import by.tms.model.fruit.Apple;
import by.tms.model.fruit.Apricot;
import by.tms.model.fruit.Fruit;
import by.tms.model.fruit.Pear;
import by.tms.utils.Paymaster;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static by.tms.utils.Paymaster.getFruitsCost;

public class Task3 {
    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(Apple.builder().price(new BigDecimal("26.54")).weight(150).build());
        fruits.add(Pear.builder().price(new BigDecimal("59.23")).weight(146).build());
        fruits.add(Pear.builder().price(new BigDecimal("62.30")).weight(162).build());
        fruits.add(Apricot.builder().price(new BigDecimal("45.56")).weight(90).build());
        fruits.add(Apple.builder().price(new BigDecimal("23.99")).weight(152).build());
        BigDecimal fullFruitsCost = new BigDecimal("0");
        BigDecimal allApplesCost = new BigDecimal("0");
        BigDecimal allApricotsCost = new BigDecimal("0");
        BigDecimal allPearsCost = new BigDecimal("0");
        for (Fruit fruit : fruits) {
            fullFruitsCost = Paymaster.getFruitsCost(fruit, fullFruitsCost);
            if (fruit instanceof Apple) {
                allApplesCost = getFruitsCost(fruit, allApplesCost);
            }
            if (fruit instanceof Apricot) {
                allApricotsCost = getFruitsCost(fruit, allApricotsCost);
            }
            if (fruit instanceof Pear) {
                allPearsCost = getFruitsCost(fruit, allPearsCost);
            }
        }
        System.out.println("The cost of all fruits is " + fullFruitsCost);
        System.out.println("The cost of all apples is " + allApplesCost);
        System.out.println("The cost of all apricot is " + allApricotsCost);
        System.out.println("The cost of all pears is " + allPearsCost);
        fruits.get(2).printManufacturerInfo();
    }
}
