package by.tms.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class GroundTransportation extends Transport {

    private int wheelsCount;
    private double fuelConsumption;

    @Override
    public String givesInfo() {

        return super.givesInfo() + "\nNumber of wheels: " + getWheelsCount() + "\n" +
                "Fuel consumption(l/100km): " + getFuelConsumption();
    }
}
