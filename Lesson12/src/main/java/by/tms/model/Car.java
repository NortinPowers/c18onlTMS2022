package by.tms.model;

import lombok.*;

@Getter
@Setter
@ToString
@Builder(builderMethodName = "internalBuilder")
public class Car {
    @NonNull
    private final Engine engine;
    @NonNull
    private final FuelTank fuelTank;
    private boolean started;
    private String brand;
    private int productionYear;
    private int kilometerCounter;

    public static CarBuilder builder(Engine engine, FuelTank fuelTank) {
        return internalBuilder()
                .engine(engine)
                .fuelTank(fuelTank);
    }
}
