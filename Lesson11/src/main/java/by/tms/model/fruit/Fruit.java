package by.tms.model.fruit;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@SuperBuilder
@ToString
public abstract class Fruit {
    private double weight;
    private BigDecimal price;

    public final void printManufacturerInfo() {
        System.out.print("Made in Belarus");
    }

    public abstract BigDecimal getValueOfFruitPrice(double weight);

}
