package by.tms;

import by.tms.tasks.Task0;

import java.util.Arrays;

public class Lesson8AddonMain {
    public static void main(String[] args) {
        Task0 task1 = new Task0();
        System.out.println(Arrays.toString(task1.getUnderTestArray()));
        task1.getIntInstanceOfArrayInfo(task1.isIntInstanceOfArray());
    }
}
