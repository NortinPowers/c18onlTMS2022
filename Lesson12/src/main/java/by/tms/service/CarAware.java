package by.tms.service;

public interface CarAware {
    String startCar() throws CarNotEngineException, CarNotFuelTankException;

    String goingCar();

    String stopCar() throws CarNotEngineException;

    String getFuelLevel() throws CarNotFuelTankException;

    String refuelingFuel(int fuelVolume) throws CarNotFuelTankException;
}
