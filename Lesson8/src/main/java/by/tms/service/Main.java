package by.tms.service;

import by.tms.model.Car;
import by.tms.model.Engine;
import by.tms.model.FuelTank;

public class Main {

    public static void main(String[] args) {
        Car pontiac = new Car(new Engine("V9"), new FuelTank(60));
        pontiac.setBrand("Pontiac");
        pontiac.setProductionYear(2022);
        viewCarInfo(pontiac);
        pontiac.getFuelTank().refuelingFuel(30);
        pontiac.getFuelTank().refuelingFuel(35);
        viewCarInfo(pontiac);
        pontiac.startCar();
        pontiac.goingCar();
        pontiac.stopCar();
        System.out.println(pontiac);
    }

    private static void viewCarInfo(Car car) {
        System.out.println("Fuel level of " + car.getBrand() + " " + car.getFuelTank().getFuelLimit() + " liters");
    }
}