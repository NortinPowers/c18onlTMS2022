package by.tms.tasks;

import lombok.Getter;

import java.util.Scanner;

import static by.tms.utils.ArraysHelper.createSpecifiedLengthArray;
import static by.tms.utils.ArraysHelper.fillingArrayNumbersFromRange;
import static by.tms.utils.ScannerType.getInputIntValueAccordingConditions;

/*
1. Создайте массив целых чисел. Удалите все вхождения заданного
числа из массива.
Пусть число задается с консоли (класс Scanner). Если такого числа нет -
выведите сообщения об этом.
В результате должен быть новый массив без указанного числа.
 */
@Getter
public class Task1 {
    private final int desiredValue = getInputIntValueAccordingConditions(new Scanner(System.in), -10, 10);
    private final int[] underTestArray = fillingArrayNumbersFromRange(createSpecifiedLengthArray(20), -10, 10);

    /**
     * The method replaces the specified integer value in the array with another (conditionally taken x+1)
     */
    public int[] replaceDesiredValue(int[] underTestArray, int desiredValue) {
        for (int i = 0; i < underTestArray.length; i++) {
            if (underTestArray[i] == desiredValue) {
                underTestArray[i] = ++underTestArray[i];
            }
        }
        return underTestArray;
    }
}
