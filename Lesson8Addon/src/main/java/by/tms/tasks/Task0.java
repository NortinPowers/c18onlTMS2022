package by.tms.tasks;

import lombok.Getter;

import java.util.Scanner;

import static by.tms.utils.ArraysHelper.createFixedLengthArray;
import static by.tms.utils.ArraysHelper.fillingArrayNumbersFromRange;
import static by.tms.utils.ScannerType.getInputIntValueAccordingConditions;

/*
0. Создайте массив целых чисел. Напишете программу, которая выводит
сообщение о том, входит ли заданное число в массив или нет.
Пусть число для поиска задается с консоли (класс Scanner).
*/
@Getter
public class Task0 {

    private final int desiredValue = getInputIntValueAccordingConditions(new Scanner(System.in), -10, 10);
    private final int[] underTestArray = fillingArrayNumbersFromRange(createFixedLengthArray(10), -10, 10);

    public boolean isIntInstanceOfArray() {
        boolean isInstance = false;
        for (int value : underTestArray) {
            if (desiredValue == value) {
                isInstance = true;
                break;
            }
        }
        return isInstance;
    }

    public void getIntInstanceOfArrayInfo(boolean isInstance) {
        String instance;
        if (isInstance) {
            instance = "is";
        } else {
            instance = "isn`t";
        }
        System.out.println(desiredValue + " " + instance + " instance of array");
    }

}
