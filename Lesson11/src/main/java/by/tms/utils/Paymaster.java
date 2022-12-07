package by.tms.utils;

import by.tms.model.fruit.Fruit;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

@UtilityClass
public class Paymaster {

    @NotNull
    public static BigDecimal getFruitsCost(Fruit fruit, BigDecimal fruitsCost) {
        fruitsCost = fruitsCost.add(fruit.getValueOfFruitPrice(fruit.getWeight()));
        return fruitsCost;
    }
}
