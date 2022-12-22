package by.tms.model;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@SuperBuilder
@ToString
public class Car implements Serializable {
    private String brand;
    private Engine engine;
    private FuelTank fuelTank;
    private int speed;
    private double price;
}
