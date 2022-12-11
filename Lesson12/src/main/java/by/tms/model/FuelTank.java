package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class FuelTank {
    @Setter
    private int fuelLimit;
    private final int fuelTankLimit;

    public FuelTank(int fuelTankLimit) {
        this.fuelTankLimit = fuelTankLimit;
    }
}
