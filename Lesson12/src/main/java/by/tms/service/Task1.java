package by.tms.service;

import by.tms.model.Car;
import by.tms.model.Engine;
import by.tms.model.FuelTank;

import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        CarAware pontiac = CarService.builder()
                .car(Car.builder()
                        .engine(Engine.builder()
                                .engineType("V6")
                                .build())
                        .fuelTank(FuelTank.builder()
                                .fuelTankLimit(60)
                                .fuelLimit(15)
                                .build())
                        .brand("Pontiac")
                        .productionYear(2022)
                        .kilometerCounter(0)
                        .build())
                .build();
        CarAware lada = CarService.builder()
                .car(Car.builder()
                        .build())
                .build();
        CarAware bmw = CarService.builder()
                .car(Car.builder()
                        .engine(Engine.builder()
                                .engineType("V6")
                                .build())
                        .brand("BMW")
                        .build())
                .build();
        ArrayList<CarAware> cars = new ArrayList<>();
        cars.add(pontiac);
        cars.add(lada);
        cars.add(bmw);
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