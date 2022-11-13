package by.tms.service;

import by.tms.model.Computer;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer("Intel i7", "16 Gb", "2 Tb", 0);
        Computer.getComputerInfo(computer);
        Computer.on(computer);
        System.out.println("Operational resource " + Computer.getFullWorkCycle(computer));
        if (Computer.getFullWorkCycle(computer) >= 0) {
            Computer.off(computer);
            System.out.println("Operational resource " + Computer.getFullWorkCycle(computer));
            Computer.on(computer);
            System.out.println("Operational resource " + Computer.getFullWorkCycle(computer));
        }
    }
}
