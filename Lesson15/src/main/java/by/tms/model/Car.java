package by.tms.model;

import java.io.Serializable;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
public class Car implements Serializable {

    private String brand;
    private Engine engine;
    private FuelTank fuelTank;
    private int speed;
    private double price;
}
