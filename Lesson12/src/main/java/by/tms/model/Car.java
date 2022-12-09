package by.tms.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
public class Car {
    private final Engine engine;
    private final FuelTank fuelTank;
    private boolean started;
    private String brand;
    private int productionYear;
    private int kilometerCounter;
}
