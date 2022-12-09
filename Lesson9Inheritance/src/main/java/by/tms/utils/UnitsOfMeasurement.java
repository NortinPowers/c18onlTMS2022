package by.tms.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UnitsOfMeasurement {

    /**
     * The method returns the power value in kilowatts based on the horsepower value
     */
    public double getPowerInKilowatts(int powerInHorsepower) {
        return powerInHorsepower * 0.74;
    }

}
