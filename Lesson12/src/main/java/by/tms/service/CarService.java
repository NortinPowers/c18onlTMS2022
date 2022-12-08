package by.tms.service;

import by.tms.model.Car;
import by.tms.utils.Messenger;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class CarService extends Car implements CarAware {
    @Override
    public String startCar() throws CarNotEngineException, CarNotFuelTankException {
        if (getEngine() != null && getFuelTank() != null) {
            if (getFuelTank().getFuelLimit() > 0) {
                getEngine().startEngine();
                setStarted(true);
                return getBrand() + " started successfully.";
            } else {
                return getBrand() + " didn't start. Fill it with fuel.";
            }
        } else if (getEngine() == null) {
            throw new CarNotEngineException(Messenger.NOT_ENGINE_EXCEPTION);
        } else {
            throw new CarNotFuelTankException(Messenger.NOT_FUEL_TANK_EXCEPTION);
        }
    }

    @Override
    public String goingCar() {
        String optionalInfo = "";
        if (isStarted()) {
            setKilometerCounter(getKilometerCounter() + 20);
            if (getFuelTank().getFuelLimit() >= 10) {
                getFuelTank().setFuelLimit(getFuelTank().getFuelLimit() - 10);
            } else {
                getFuelTank().setFuelLimit(0);
                optionalInfo = "Fuel ran out before the end of the trip.";
            }
        } else {
            return getBrand() + " is not started.";
        }
        return getBrand() + " is going. " + optionalInfo;
    }

    @Override
    public String stopCar() throws CarNotEngineException {
        if (getEngine() != null) {
            getEngine().stopEngine();
            setStarted(false);
            return getBrand() + " is stopped.";
        } else {
            throw new CarNotEngineException(Messenger.NOT_ENGINE_EXCEPTION);
        }
    }

    @Override
    public String getFuelLevel() throws CarNotFuelTankException {
        if (getFuelTank() != null) {
            return "Fuel level of " + getBrand() + " is " + getFuelTank().getFuelLimit() + " liters.";
        } else {
            throw new CarNotFuelTankException(Messenger.NOT_FUEL_TANK_EXCEPTION);
        }
    }

    @Override
    public String refuelingFuel(int fuelVolume) throws CarNotFuelTankException {
        if (getFuelTank() != null) {
            if (fuelVolume > getFuelTank().getFuelTankLimit() - getFuelTank().getFuelLimit()) {
                getFuelTank().setFuelLimit(getFuelTank().getFuelTankLimit());
                return "Some of the fuel did not fit into the fuel tank. Now there are "
                        + getFuelTank().getFuelLimit() + " liters of fuel in the gas tank of " + getBrand() + ".";
            } else {
                getFuelTank().setFuelLimit(getFuelTank().getFuelLimit() + fuelVolume);
                return "Now there are " + getFuelTank().getFuelLimit() + " liters of fuel in the gas tank of "
                        + getBrand() + ".";
            }
        } else {
            throw new CarNotFuelTankException(Messenger.NOT_FUEL_TANK_EXCEPTION);
        }
    }
}
