package by.tms.service;

import by.tms.model.Car;
import by.tms.model.Engine;
import by.tms.model.FuelTank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarServiceTest {
    CarAware pontiac = CarService.builder()
            .engine(Engine.builder()
                    .engineType("V9")
                    .build())
            .fuelTank(FuelTank.builder()
                    .fuelTankLimit(60)
                    .fuelLimit(15)
                    .build())
            .brand("Pontiac")
            .productionYear(2022)
            .kilometerCounter(0)
            .build();
    CarAware lada = CarService.builder()
            .build();
    CarAware jeep = CarService.builder()
            .engine(Engine.builder()
                    .engineType("V6")
                    .build())
            .fuelTank(FuelTank.builder()
                    .fuelTankLimit(60)
                    .fuelLimit(0)
                    .build())
            .brand("JEEP")
            .productionYear(2022)
            .kilometerCounter(0)
            .build();
    CarAware bmw = CarService.builder()
            .engine(Engine.builder()
                    .engineType("V6")
                    .build())
            .brand("BMW")
            .productionYear(2022)
            .kilometerCounter(0)
            .build();

    @Test
    void startCar() throws CarNotFuelTankException, CarNotEngineException {
        Assertions.assertEquals("Pontiac started successfully.", pontiac.startCar());
        Assertions.assertTrue(((Car) pontiac).isStarted());
        Assertions.assertTrue(((Car) pontiac).getEngine().isStarted());
        pontiac.stopCar();
        Assertions.assertFalse(((Car) pontiac).isStarted());
        Assertions.assertFalse(((Car) pontiac).getEngine().isStarted());
        Assertions.assertThrows(CarNotEngineException.class, () -> lada.startCar());
        Assertions.assertThrows(CarNotFuelTankException.class, () -> bmw.startCar());
        Assertions.assertEquals("JEEP didn't start. Fill it with fuel.", jeep.startCar());
    }

    @Test
    void goingCar() throws CarNotFuelTankException, CarNotEngineException {
        Assertions.assertEquals("Pontiac is not started.", pontiac.goingCar());
        Assertions.assertFalse(((Car) pontiac).isStarted());
        Assertions.assertFalse(((Car) pontiac).getEngine().isStarted());
        pontiac.startCar();
        Assertions.assertTrue(((Car) pontiac).isStarted());
        Assertions.assertTrue(((Car) pontiac).getEngine().isStarted());
        Assertions.assertEquals("Pontiac is going. ", pontiac.goingCar());
        Assertions.assertEquals("Pontiac is going. Fuel ran out before the end of the trip.", pontiac.goingCar());
    }

    @Test
    void stopCar() throws CarNotEngineException, CarNotFuelTankException {
        Assertions.assertThrows(CarNotEngineException.class, () -> lada.stopCar());
        Assertions.assertFalse(((Car) pontiac).isStarted());
        pontiac.startCar();
        Assertions.assertTrue(((Car) pontiac).isStarted());
        Assertions.assertTrue(((Car) pontiac).getEngine().isStarted());
        pontiac.stopCar();
        Assertions.assertFalse(((Car) pontiac).isStarted());
        Assertions.assertFalse(((Car) pontiac).getEngine().isStarted());
        Assertions.assertEquals("Pontiac is stopped.", pontiac.stopCar());
    }

    @Test
    void getFuelLevel() throws CarNotFuelTankException {
        Assertions.assertThrows(CarNotFuelTankException.class, () -> bmw.getFuelLevel());
        Assertions.assertEquals("Fuel level of Pontiac is 15 liters.", pontiac.getFuelLevel());
    }

    @Test
    void refuelingFuel() throws CarNotFuelTankException {
        Assertions.assertEquals("Now there are 45 liters of fuel in the gas tank of Pontiac.",
                pontiac.refuelingFuel(30));
        Assertions.assertEquals("Some of the fuel did not fit into the fuel tank. " +
                "Now there are 60 liters of fuel in the gas tank of Pontiac.", pontiac.refuelingFuel(30));
        Assertions.assertThrows(CarNotFuelTankException.class, () -> bmw.refuelingFuel(20));
    }
}