package by.tms.model;

public class FuelTank {
    private int fuelLimit;
    private int fuelTankLimit;

    public int getFuelLimit() {
        return fuelLimit;
    }

    public void setFuelLimit(int fuelLimit) {
        this.fuelLimit = fuelLimit;
    }

    public int refuelingFuel(int fuelVolume) {
        int fuelLevel = this.fuelLimit += fuelVolume;
        if (fuelLevel > fuelTankLimit) {
            System.out.println("some of the fuel did not fit into the fuel tank");
            return fuelTankLimit;
        } else {
            return this.fuelLimit += fuelVolume;
        }
    }
}
