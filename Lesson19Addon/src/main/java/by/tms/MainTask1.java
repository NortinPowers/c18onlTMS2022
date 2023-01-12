package by.tms;

import by.tms.service.ServiceTask1;
import by.tms.service.UniqueIntegerListMakeable;

public class MainTask1 {
    public static void main(String[] args) {
        System.out.println("Enter a set of numbers:");
        UniqueIntegerListMakeable task = new ServiceTask1();
        System.out.println("Non-repeating string numbers are: " + task.getNonRepeatIntegerValue());
    }
}