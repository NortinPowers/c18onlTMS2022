package by.tms.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Car {
    private final Engine engine;
    private final FuelTank fuelTank;
    private boolean started;
    private String brand;
    private int productionYear;
    private int kilometerCounter;

    public Car(Engine engine, FuelTank fuelTank) {
        this.engine = engine;
        this.fuelTank = fuelTank;
    }

    public Car(Engine engine, FuelTank fuelTank, String brand, int productionYear, int kilometerCounter) {
        this.engine = engine;
        this.fuelTank = fuelTank;
        this.brand = brand;
        this.productionYear = productionYear;
        this.kilometerCounter = kilometerCounter;
    }
}