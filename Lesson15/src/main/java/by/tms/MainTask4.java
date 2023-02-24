package by.tms;

import static by.tms.utils.FilePaths.CAR_DAT;

import by.tms.model.Car;
import by.tms.model.Engine;
import by.tms.model.FuelTank;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainTask4 {

    public static void main(String[] args) {
        Car pontiac = Car.builder()
                         .brand("Pontiac")
                         .engine(new Engine("V9", 8))
                         .fuelTank(new FuelTank("petrol", 60))
                         .speed(160)
                         .price(2000.30)
                         .build();
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(CAR_DAT))) {
            outputStream.writeObject(pontiac);
        } catch (IOException e) {
            System.out.println("Unexpected save error " + e);
        }
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(CAR_DAT))) {
            Car car = (Car) inputStream.readObject();
            System.out.println(car);
        } catch (Exception e) {
            System.out.println("Unexpected read error " + e);
        }
    }
}
