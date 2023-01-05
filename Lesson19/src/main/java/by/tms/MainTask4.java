package by.tms;

import by.tms.model.Car;

import java.util.Arrays;
import java.util.List;

public class MainTask4 {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("AA1111BX", 2007),
                new Car("AK5555IT", 2010),
                new Car(null, 2012),
                new Car("", 2015),
                new Car("AI3838PP", 2017));
        List<Car> specificCar = cars.stream()
                .filter(car -> car.getYearOfRelease() > 2010)
                .filter(car -> car.getNumber() != null && !car.getNumber().isEmpty())
                .toList();
        System.out.println(specificCar);
    }
}