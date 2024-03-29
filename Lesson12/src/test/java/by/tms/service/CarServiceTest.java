package by.tms.service;

import by.tms.exception.CarNotStartedException;
import by.tms.model.Car;
import by.tms.model.Engine;
import by.tms.model.FuelTank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarServiceTest {

    CarService pontiac = new CarService(new Car(
            new Engine("V6"),
            new FuelTank(15, 60),
            "Pontiac",
            2022,
            0));
    CarService jeep = new CarService(new Car(
            new Engine("V9"),
            new FuelTank(0, 90),
            "JEEP",
            2022,
            0));

    @Test
    void startCar() {
        try {
            Assertions.assertEquals("Pontiac started successfully.", pontiac.startCar());
            Assertions.assertTrue(pontiac.getCar().isStarted());
            Assertions.assertTrue(pontiac.getCar().getEngine().isStarted());
            pontiac.stopCar();
            Assertions.assertFalse(pontiac.getCar().isStarted());
            Assertions.assertFalse(pontiac.getCar().getEngine().isStarted());
            Assertions.assertEquals("JEEP didn't start. Fill it with fuel.", jeep.startCar());
        } catch (CarNotStartedException e) {
            System.out.println("exception: " + e.getMessage());
        }
    }

    @Test
    void goingCar() {
        try {
            Assertions.assertEquals("Pontiac is not started.", pontiac.goingCar());
            Assertions.assertFalse(pontiac.getCar().isStarted());
            Assertions.assertFalse(pontiac.getCar().getEngine().isStarted());
            pontiac.startCar();
            Assertions.assertTrue(pontiac.getCar().isStarted());
            Assertions.assertTrue(pontiac.getCar().getEngine().isStarted());
            Assertions.assertEquals("Pontiac is going. ", pontiac.goingCar());
            Assertions.assertEquals("Pontiac is going. Fuel ran out before the end of the trip.", pontiac.goingCar());
        } catch (CarNotStartedException e) {
            System.out.println("exception: " + e.getMessage());
        }
    }

    @Test
    void stopCar() {
        try {
            Assertions.assertFalse(pontiac.getCar().isStarted());
            pontiac.startCar();
            Assertions.assertTrue(pontiac.getCar().isStarted());
            Assertions.assertTrue(pontiac.getCar().getEngine().isStarted());
            Assertions.assertEquals("Pontiac is stopped.", pontiac.stopCar());
            Assertions.assertFalse(pontiac.getCar().isStarted());
            Assertions.assertFalse(pontiac.getCar().getEngine().isStarted());
            Assertions.assertEquals("Pontiac is already stopped.", pontiac.stopCar());
        } catch (CarNotStartedException e) {
            System.out.println("exception: " + e.getMessage());
        }
    }

    @Test
    void getFuelLevel() {
        Assertions.assertEquals("Fuel level of Pontiac is 15 liters.", pontiac.getFuelLevel());
    }

    @Test
    void refuelingFuel() {
        Assertions.assertEquals("Now there are 45 liters of fuel in the gas tank of Pontiac.",
                                pontiac.refuelingFuel(30));
        Assertions.assertEquals("Some of the fuel did not fit into the fuel tank. " +
                                        "Now there are 60 liters of fuel in the gas tank of Pontiac.", pontiac.refuelingFuel(30));
    }
}