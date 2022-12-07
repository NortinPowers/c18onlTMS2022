package by.tms.model.fruit;

import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

import static by.tms.utils.Constants.KILOGRAM;
import static java.math.RoundingMode.HALF_UP;

@SuperBuilder
public class Pear extends Fruit {

    @Override
    public BigDecimal getValueOfFruitPrice(double weight) {
        return this.getPrice().multiply(new BigDecimal(weight)).divide(new BigDecimal(KILOGRAM), 4, HALF_UP);
    }
}
