package by.tms;

import by.tms.exception.CarNotStartedException;
import by.tms.model.Car;
import by.tms.model.Engine;
import by.tms.model.FuelTank;
import by.tms.service.CarAware;
import by.tms.service.CarService;

import java.util.ArrayList;

public class MainTask1 {
    public static void main(String[] args) {
        CarService pontiac = new CarService.CarServiceBuilder(
                new Car.CarBuilder(
                        new Engine.EngineBuilder("V9")
                                .build(),
                        new FuelTank.FuelTankBuilder(60)
                                .setFuelLimit(15)
                                .build())
                        .setBrand("Pontiac")
                        .setProductionYear(2022)
                        .setKilometerCounter(0)
                        .build())
                .build();
        CarService jeep = new CarService.CarServiceBuilder(
                new Car.CarBuilder(
                        new Engine.EngineBuilder("V9")
                                .build(),
                        new FuelTank.FuelTankBuilder(90)
                                .setFuelLimit(0)
                                .build())
                        .setBrand("JEEP")
                        .setProductionYear(2022)
                        .setKilometerCounter(0)
                        .build())
                .build();
        ArrayList<CarAware> cars = new ArrayList<>();
        cars.add(pontiac);
        cars.add(jeep);
        for (CarAware car : cars) {
            try {
                System.out.println(car.startCar());
                System.out.println(car.goingCar());
                System.out.println(car.stopCar());
                System.out.println(car.getFuelLevel());
                System.out.println(car.refuelingFuel(30));
                System.out.println(car.refuelingFuel(30));
                System.out.println();
            } catch (CarNotStartedException e) {
                System.out.println("exception: " + e.getMessage());
                System.out.println();
            }
        }
    }
}