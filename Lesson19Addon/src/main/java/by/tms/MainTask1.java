package by.tms;

import by.tms.service.ServiceTask1;

public class MainTask1 {
    public static void main(String[] args) {
        System.out.println("Enter a set of numbers:");
        ServiceTask1 task = new ServiceTask1();
        System.out.println("Non-repeating string numbers are: " + task.getNonRepeatIntegerValue());
    }
}