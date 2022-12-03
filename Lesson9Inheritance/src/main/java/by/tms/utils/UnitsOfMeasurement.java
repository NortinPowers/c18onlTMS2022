package by.tms.utils;

public final class UnitsOfMeasurement {

    private UnitsOfMeasurement() {
    }

    /**
     * The method returns the power value in kilowatts based on the horsepower value
     */
    public static double getPowerInKilowatts(int powerInHorsepower) {
        return powerInHorsepower * 0.74;
    }

}
