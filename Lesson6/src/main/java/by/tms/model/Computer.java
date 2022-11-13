package by.tms.model;

import java.util.Random;
import java.util.Scanner;

public class Computer {
    String processor;
    String ram;
    String hardDrive;
    int fullWorkCycle;

    public Computer(String processor, String ram, String hardDrive, int fullWorkCycle) {
        this.processor = processor;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.fullWorkCycle = fullWorkCycle;
    }

    public static int getFullWorkCycle(Computer computer) {
        return computer.fullWorkCycle;
    }

    public static void getComputerInfo(Computer computer) {
        System.out.println("Details of this computer:\n Processor: " + computer.processor + "\n RAM: " + computer.ram
                + "\n Hard drive: " + computer.hardDrive + "\n Resource of full working cycles: " + computer.fullWorkCycle);
    }

    public static void on(Computer computer) {
        if (computer.fullWorkCycle > 0) {
            givesIncorrectInputInfo();
            int value = getEnteredValue();
            if (checkFailure(value)) {
                System.out.println("Computer turn off");
            } else {
                System.out.println("Computer burns down");
                computer.fullWorkCycle = 0;
            }
        } else {
            System.out.println("Computer burned down");
        }
    }

    public static boolean checkFailure(int value) {
        Random random = new Random();
        return value == random.nextInt(2);
    }

    public static int getEnteredValue() {
        Scanner scanner = new Scanner(System.in);
        int value = -1;
        do {
            if (scanner.hasNextInt()) {
                int entValue = scanner.nextInt();
                if (getValidationEnteredValue(entValue)) {
                    value = entValue;
                } else {
                    givesIncorrectInputInfo();
                }
            } else {
                givesIncorrectInputInfo();
                scanner.next();
            }
        } while (value < 0);
        return value;
    }

    public static boolean getValidationEnteredValue(int entValue) {
        return entValue == 0 || entValue == 1;
    }

    public static void givesIncorrectInputInfo() {
        System.out.println("Attention! Enter 0 or 1");
    }

    public static void off(Computer computer) {
        if (computer.fullWorkCycle > 0) {
            System.out.println("Computer shuts down");
            computer.fullWorkCycle--;
        } else {
            System.out.println("Computer burned down");
        }
    }
}
