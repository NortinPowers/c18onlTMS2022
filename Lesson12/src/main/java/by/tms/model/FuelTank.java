package by.tms.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class FuelTank {
    @Setter
    private int fuelLimit;
    private final int fuelTankLimit;

    private FuelTank(FuelTankBuilder fuelTankBuilder) {
        fuelTankLimit = fuelTankBuilder.fuelTankLimit;
        fuelLimit = fuelTankBuilder.fuelLimit;
    }

    public static class FuelTankBuilder {
        private final int fuelTankLimit;
        private int fuelLimit;

        public FuelTankBuilder(int fuelTankLimit) {
            this.fuelTankLimit = fuelTankLimit;
        }

        public FuelTankBuilder setFuelLimit(int fuelLimit) {
            this.fuelLimit = fuelLimit;
            return this;
        }

        public FuelTank build() {
            return new FuelTank(this);
        }
    }
}
