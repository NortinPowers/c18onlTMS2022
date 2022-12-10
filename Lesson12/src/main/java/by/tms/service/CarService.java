package by.tms.service;

import by.tms.model.Car;
import by.tms.utils.Messenger;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CarService implements CarAware {
    private Car car;

    @Override
    public String startCar() throws CarNotEngineException, CarNotFuelTankException {
        if (car.getEngine() != null && car.getFuelTank() != null) {
            if (car.getFuelTank().getFuelLimit() > 0) {
                car.getEngine().startEngine();
                car.setStarted(true);
                return car.getBrand() + " started successfully.";
            } else {
                return car.getBrand() + " didn't start. Fill it with fuel.";
            }
        } else if (car.getEngine() == null) {
            throw new CarNotEngineException(Messenger.NOT_ENGINE_EXCEPTION);
        } else {
            throw new CarNotFuelTankException(Messenger.NOT_FUEL_TANK_EXCEPTION);
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
    public String stopCar() throws CarNotEngineException {
        if (car.getEngine() != null) {
            car.getEngine().stopEngine();
            car.setStarted(false);
            return car.getBrand() + " is stopped.";
        } else {
            throw new CarNotEngineException(Messenger.NOT_ENGINE_EXCEPTION);
        }
    }

    @Override
    public String getFuelLevel() throws CarNotFuelTankException {
        if (car.getFuelTank() != null) {
            return "Fuel level of " + car.getBrand() + " is " + car.getFuelTank().getFuelLimit() + " liters.";
        } else {
            throw new CarNotFuelTankException(Messenger.NOT_FUEL_TANK_EXCEPTION);
        }
    }

    @Override
    public String refuelingFuel(int fuelVolume) throws CarNotFuelTankException {
        if (car.getFuelTank() != null) {
            if (fuelVolume > car.getFuelTank().getFuelTankLimit() - car.getFuelTank().getFuelLimit()) {
                car.getFuelTank().setFuelLimit(car.getFuelTank().getFuelTankLimit());
                return "Some of the fuel did not fit into the fuel tank. Now there are "
                        + car.getFuelTank().getFuelLimit() + " liters of fuel in the gas tank of " + car.getBrand() + ".";
            } else {
                car.getFuelTank().setFuelLimit(car.getFuelTank().getFuelLimit() + fuelVolume);
                return "Now there are " + car.getFuelTank().getFuelLimit() + " liters of fuel in the gas tank of "
                        + car.getBrand() + ".";
            }
        } else {
            throw new CarNotFuelTankException(Messenger.NOT_FUEL_TANK_EXCEPTION);
        }
    }
}
