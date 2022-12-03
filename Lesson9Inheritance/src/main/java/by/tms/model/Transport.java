package by.tms.model;

import by.tms.interfaces.Describable;
import by.tms.interfaces.Transportable;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import static by.tms.utils.UnitsOfMeasurement.getPowerInKilowatts;

@Getter
@SuperBuilder
public class Transport implements Describable, Transportable {
    private int powerInHorsepower;
    private int maxSpeedKmPerHour;
    private double weightKg;
    private String brand;

    @Override
    public void getInfo() {
        System.out.println("The characteristics of this vehicle are as follows:\n" +
                "Power (in horsepower): " + getPowerInHorsepower() +
                " (in kilowatts: " + getPowerInKilowatts(getPowerInHorsepower()) + ")\n" +
                "Maximum speed(km/h): " + getMaxSpeedKmPerHour() + "\n" +
                "Weight (kg): " + getWeightKg() + "\n" +
                "Brand \"" + getBrand() + "\"");
    }
}
