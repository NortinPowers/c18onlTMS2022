package by.tms.service;

import by.tms.model.Computer;

public class MainComputer {
    public static void main(String[] args) {
        Computer computer = new Computer("Intel i7", "16 Gb", "2 Tb", 2);
        System.out.println(computer.getComputerInfo());
        System.out.println(computer.on());
        System.out.println("Operational resource " + computer.getFullWorkCycle());
        if (computer.isComputerStillWorking()) {
            System.out.println(computer.off());
            System.out.println("Operational resource " + computer.getFullWorkCycle());
            System.out.println(computer.on());
            System.out.println("Operational resource " + computer.getFullWorkCycle());
        }
    }
}
