package by.tms;

import by.tms.tasks.Task0;
import by.tms.tasks.Task1;
import by.tms.tasks.Task2;

import java.util.Arrays;

import static by.tms.utils.ArraysHelper.getMaxMinAverageInfoOfArray;

public class Lesson8AddonMain {
    public static void main(String[] args) {
        System.out.println("Task 0");
        Task0 task0 = new Task0();
        System.out.println(Arrays.toString(task0.getUnderTestArray()));
        task0.getIntInstanceOfArrayInfo(task0.isIntInstanceOfArray());
        System.out.println("Task 1");
        Task1 task1 = new Task1();
        System.out.println(Arrays.toString(task1.getUnderTestArray()));
        System.out.println(Arrays.toString(task1.replaceDesiredValue(task1.getUnderTestArray(), task1.getDesiredValue())));
        System.out.println("Task 2");
        Task2 task2 = new Task2();
        System.out.println(Arrays.toString(task2.getUnderTestArray()));
        getMaxMinAverageInfoOfArray(task2.getUnderTestArray());
    }
}
