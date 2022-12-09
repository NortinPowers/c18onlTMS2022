package by.tms.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public class FuelTank {
    @Setter
    private int fuelLimit;
    private final int fuelTankLimit;
}
