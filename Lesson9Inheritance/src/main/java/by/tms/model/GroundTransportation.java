package by.tms.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class GroundTransportation extends Transport {
    private int wheelsCount;
    private double fuelConsumption;

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Number of wheels: " + getWheelsCount() + "\n" +
                "Fuel consumption(l/100km): " + getFuelConsumption());
    }
}
