package by.tms;

import by.tms.service.Task1Service;
import by.tms.service.UniqueIntegersListMakeable;

public class MainTask1 {
    public static void main(String[] args) {
        System.out.println("Enter a set of numbers:");
        UniqueIntegersListMakeable task = new Task1Service();
        System.out.println("Non-repeating string numbers are: " + task.getNonRepeatIntegerValue());
    }
}