package by.tms.service;

import by.tms.exception.CarNotStartedException;
import by.tms.model.Car;
import java.util.Random;
import lombok.Getter;

@Getter
public class CarService implements CarAware {

    private final Car car;

    public CarService(Car car) {
        this.car = car;
    }

    @Override
    public String startCar() throws CarNotStartedException {
        Random random = new Random();
        if (random.nextInt(21) % 2 != 0) {
            if (car.getFuelTank().getFuelLimit() > 0) {
                car.getEngine().startEngine();
                car.setStarted(true);
                return car.getBrand() + " started successfully.";
            } else {
                return car.getBrand() + " didn't start. Fill it with fuel.";
            }
        } else {
            throw new CarNotStartedException("Failed to start the car " + car.getBrand() + ".");
        }
    }

    @Override
    public String goingCar() {
        String optionalInfo = "";
        if (car.isStarted()) {
            car.setKilometerCounter(car.getKilometerCounter() + 20);
            if (car.getFuelTank().getFuelLimit() >= 10) {
                car.getFuelTank().setFuelLimit(car.getFuelTank().getFuelLimit() - 10);
            } else {
                car.getFuelTank().setFuelLimit(0);
                optionalInfo = "Fuel ran out before the end of the trip.";
            }
        } else {
            return car.getBrand() + " is not started.";
        }
        return car.getBrand() + " is going. " + optionalInfo;
    }

    @Override
    public String stopCar() {
        if (car.isStarted()) {
            car.getEngine().stopEngine();
            car.setStarted(false);
            return car.getBrand() + " is stopped.";
        } else {
            return car.getBrand() + " is already stopped.";
        }
    }

    @Override
    public String getFuelLevel() {
        return "Fuel level of " + car.getBrand() + " is " + car.getFuelTank().getFuelLimit() + " liters.";
    }

    @Override
    public String refuelingFuel(int fuelVolume) {
        if (fuelVolume > car.getFuelTank().getFuelTankLimit() - car.getFuelTank().getFuelLimit()) {
            car.getFuelTank().setFuelLimit(car.getFuelTank().getFuelTankLimit());
            return "Some of the fuel did not fit into the fuel tank. Now there are "
                    + car.getFuelTank().getFuelLimit() + " liters of fuel in the gas tank of " + car.getBrand() + ".";
        } else {
            car.getFuelTank().setFuelLimit(car.getFuelTank().getFuelLimit() + fuelVolume);
            return "Now there are " + car.getFuelTank().getFuelLimit() + " liters of fuel in the gas tank of "
                    + car.getBrand() + ".";
        }
    }
}
