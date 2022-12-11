package by.tms.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Car {
    private final Engine engine;
    private final FuelTank fuelTank;
    private boolean started;
    private String brand;
    private int productionYear;
    private int kilometerCounter;

    private Car(CarBuilder carBuilder) {
        engine = carBuilder.engine;
        fuelTank = carBuilder.fuelTank;
        brand = carBuilder.brand;
        productionYear = carBuilder.productionYear;
        kilometerCounter = carBuilder.kilometerCounter;
    }

    public static class CarBuilder {
        private final Engine engine;
        private final FuelTank fuelTank;
        private String brand;
        private int productionYear;
        private int kilometerCounter;

        public CarBuilder(Engine engine, FuelTank fuelTank) {
            this.engine = engine;
            this.fuelTank = fuelTank;
        }

        public CarBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public CarBuilder setProductionYear(int productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        public CarBuilder setKilometerCounter(int kilometerCounter) {
            this.kilometerCounter = kilometerCounter;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
