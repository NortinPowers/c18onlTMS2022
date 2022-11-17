package by.tms.model;

import java.util.Random;
import java.util.Scanner;

public class Computer {
    private String processor;
    private String ram;
    private String hardDrive;
    private int fullWorkCycle;

    public Computer(String processor, String ram, String hardDrive, int fullWorkCycle) {
        this.processor = processor;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.fullWorkCycle = fullWorkCycle;
    }

    public boolean isComputerStillWorking() {
        return this.fullWorkCycle > 0;
    }

    public int getFullWorkCycle() {
        return this.fullWorkCycle;
    }

    public String getComputerInfo() {
        return "Details of this computer:\n Processor: " + this.processor + "\n RAM: " + this.ram
                + "\n Hard drive: " + this.hardDrive + "\n Resource of full working cycles: " + this.fullWorkCycle;
    }

    public String on() {
        if (this.fullWorkCycle > 0) {
            System.out.println(givesIncorrectInputInfo());
            int value = getEnteredValue();
            if (checkFailure(value)) {
                return "Computer turn off";
            } else {
                this.fullWorkCycle = 0;
                return "Computer burns down";
            }
        } else {
            return "Computer burned down";
        }
    }

    public boolean checkFailure(int value) {
        Random random = new Random();
        return value == random.nextInt(2);
    }

    public int getEnteredValue() {
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

    public boolean getValidationEnteredValue(int entValue) {
        return entValue == 0 || entValue == 1;
    }

    public String givesIncorrectInputInfo() {
        return "Attention! Enter 0 or 1";
    }

    public String off() {
        if (this.fullWorkCycle > 0) {
            this.fullWorkCycle--;
            return "Computer shuts down";
        } else {
            return "Computer burned down";
        }
    }
}
