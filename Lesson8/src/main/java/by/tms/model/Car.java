package by.tms.model;

  /*
 Напишите структуру классов и продемонстрируйте работу
 - Машина имеет двигатель, бензобак (реализуйте класс для каждой сущности).
 - Чтобы поехать, машину необходимо завести, т.е. включить двигатель.
 - Реализуйте методы включения машины, который в свою очередь включает её двигатель.
 - Реализуйте метод езды на машине (например просто печатаем на консоль, что машина поехала)
 - Если машина не заведена, ехать она не может.
 - Машину можно заглушить.
 - После каждой поездки считаем, что машина прошла фиксированное расстояние.
 - Реализовать возможность посмотреть, какое расстояние машина прошла за все время.
 - Чтобы создать машину обязательно нужно иметь двигатель и бензобак.
 - Марка машины, год выпуска, пройденное расстояние - не обязательны при создании машины и могут быть выставлены потом.
 (не обязательно задавать в конструкторе)
 - После создания поменять двигатель машине нельзя.
 - Чтобы машина завелась, у неё должно быть топливо в бензобаке, если топлива нет, машина не может завестись.
 - Машину можно дозаправить, можно проверить сколько топлива осталось.
 - Реализуйте пару полей для двигателя и бензобака, например: тип двигателя, общий объем бензобака,
 сколько бензина сейчас и т.д.
     */

public class Car {
    private Engine engine;
    private FuelTank fuelTank;
    private boolean started;
    private String brand;
    private int productionYear;

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getKilometerCounter() {
        return kilometerCounter;
    }

    public Car(Engine engine, FuelTank fuelTank) {
        this.engine = engine;
        this.fuelTank = fuelTank;
    }

    private int kilometerCounter;

    public boolean startCar() {
        if (fuelTank.getFuelLimit() > 0) {
            started = true;
        }
        return started;
    }

    public void goingCar() {
        if (started) {
            System.out.println("the car is going");
            kilometerCounter += 20;
//            fuelTank.getFuelLimit() -= 10;
        } else {
            System.out.println("the car is not started");
        }

    }

    public boolean stopCar() {
        started = false;
        return started;
    }


}
