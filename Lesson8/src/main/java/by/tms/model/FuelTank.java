package by.tms.model;

public class FuelTank {
    private int fuelLimit;
    private final int fuelTankLimit;

    public int getFuelLimit() {
        return fuelLimit;
    }

    public void setFuelLimit(int fuelLimit) {
        this.fuelLimit = fuelLimit;
    }

    public int refuelingFuel(int fuelVolume) {
        fuelLimit += fuelVolume;
        if (fuelVolume > fuelTankLimit - fuelLimit) {
            System.out.println("Some of the fuel did not fit into the fuel tank");
            fuelLimit = fuelTankLimit;
        }
        return fuelLimit;
    }

    public FuelTank(int fuelTankLimit) {
        this.fuelTankLimit = fuelTankLimit;
    }

    @Override
    public String toString() {
        return "Fuel Tank {" +
                "fuel limit: " + fuelLimit +
                " (fuel tank limit: " + fuelTankLimit +
                ")}";
    }
}
