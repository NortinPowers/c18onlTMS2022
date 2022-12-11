package by.tms.service;

import by.tms.exception.CarNotStartedException;

public interface CarAware {
    String startCar() throws CarNotStartedException;

    String goingCar();

    String stopCar();

    String getFuelLevel();

    String refuelingFuel(int fuelVolume);
}
