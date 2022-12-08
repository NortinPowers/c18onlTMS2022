package by.tms.model.fruit;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

import static by.tms.utils.Constants.KILOGRAM;
import static java.math.RoundingMode.HALF_UP;

@Getter
@SuperBuilder
@ToString
public abstract class Fruit {
    private double weight;
    private BigDecimal price;

    public final void printManufacturerInfo() {
        System.out.print("Made in Belarus");
    }

    public BigDecimal getValueOfFruitPrice(double weight) {
        return this.getPrice().multiply(new BigDecimal(weight)).divide(new BigDecimal(KILOGRAM), 4, HALF_UP);
    }

}
