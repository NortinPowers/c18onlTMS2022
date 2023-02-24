package by.tms.model;

public class Car {

    private final Engine engine;
    private final FuelTank fuelTank;
    private boolean started;
    private String brand;
    private int productionYear;
    private int kilometerCounter;

    public Engine getEngine() {
        return engine;
    }

    public FuelTank getFuelTank() {
        return fuelTank;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getKilometerCounter() {
        return kilometerCounter;
    }

    public Car(Engine engine, FuelTank fuelTank) {
        this.engine = engine;
        this.fuelTank = fuelTank;
    }

    public void startCar() {
        if (fuelTank.getFuelLimit() > 0) {
            engine.startEngine();
            started = true;
        } else {
            System.out.println("The car didn't start. Fill it with fuel");
        }
    }

    public void goingCar() {
        if (started) {
            System.out.println("The car is going");
            kilometerCounter += 20;
            if (fuelTank.getFuelLimit() >= 10) {
                fuelTank.setFuelLimit(fuelTank.getFuelLimit() - 10);
            } else {
                fuelTank.setFuelLimit(0);
                System.out.println("Fuel ran out before the end of the trip");
            }
        } else {
            System.out.println("The car is not started");
        }
    }

    public void stopCar() {
        engine.stopEngine();
        started = false;
    }

    @Override
    public String toString() {
        return "Car { " +
                engine +
                ", " + fuelTank +
                ", brand: '" + brand + '\'' +
                ", production year: " + productionYear +
                ", kilometer counter: " + kilometerCounter +
                " miles }";
    }
}
