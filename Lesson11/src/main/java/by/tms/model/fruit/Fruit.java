package by.tms.model.fruit;

import static by.tms.utils.Constants.KILOGRAM;
import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

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
