package by.tms.utils;

import by.tms.model.fruit.Fruit;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
public class Paymaster {

    public BigDecimal getFruitsCost(@NonNull Fruit fruit, BigDecimal fruitsCost) {
        fruitsCost = fruitsCost.add(fruit.getValueOfFruitPrice(fruit.getWeight()));
        return fruitsCost;
    }
}
