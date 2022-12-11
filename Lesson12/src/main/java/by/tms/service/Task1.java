package by.tms.service;

import by.tms.model.Car;
import by.tms.model.Engine;
import by.tms.model.FuelTank;

import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        CarAware pontiac = CarService.builder()
                .car(Car.builder(Engine.builder("V9")
                                        .build(),
                                FuelTank.builder(60)
                                        .fuelLimit(15)
                                        .build())
                        .brand("Pontiac")
                        .productionYear(2022)
                        .kilometerCounter(0)
                        .build())
                .build();
        CarAware jeep = CarService.builder()
                .car(Car.builder(Engine.builder("V6")
                                        .build(),
                                FuelTank.builder(90)
                                        .fuelLimit(0)
                                        .build())
                        .brand("JEEP")
                        .productionYear(2022)
                        .kilometerCounter(0)
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
            } catch (CarNotEngineException | CarNotFuelTankException e) {
                System.out.println("exception: " + e.getMessage());
                System.out.println();
            }
        }
    }
}