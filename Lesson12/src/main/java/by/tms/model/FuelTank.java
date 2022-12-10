package by.tms.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Builder(builderMethodName = "internalBuilder")
public class FuelTank {
    @Setter
    private int fuelLimit;
    private final int fuelTankLimit;

    public static FuelTankBuilder builder(int fuelTankLimit) {
        return internalBuilder().fuelTankLimit(fuelTankLimit);
    }
}
