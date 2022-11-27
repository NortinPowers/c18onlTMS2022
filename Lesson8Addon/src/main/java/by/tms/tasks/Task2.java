package by.tms.tasks;

import lombok.Getter;

import java.util.Arrays;
import java.util.Scanner;

import static by.tms.utils.ArraysHelper.createSpecifiedLengthArray;
import static by.tms.utils.ArraysHelper.fillingArrayNumbersFromRange;
import static by.tms.utils.ScannerType.getInputIntValueAccordingConditions;

/*
2. Создайте и заполните массив случайным числами и выведете
максимальное, минимальное и среднее значение.
Для генерации случайного числа используйте метод Math.random(). - Ignore this condition (fori -> array[i] = (int) (Math.random() * X))
Пусть будет возможность создавать массив произвольного размера.
Пусть размер массива вводится с консоли.
 */
public class Task2 {
    private final int arrayLength = getInputIntValueAccordingConditions(new Scanner(System.in), 1, 100);
    @Getter
    private final int[] underTestArray = fillingArrayNumbersFromRange(createSpecifiedLengthArray(arrayLength), -20, 20);

    /**
     * The method sorts an integer array
     */
    public void sortsArray(int[] array) {
        if (array.length > 0) {
            Arrays.sort(array);
        }
    }

    /**
     * The method returns the maximum value of the array
     */
    public int getMaxArrayValue(int[] array) {
        if (array.length > 0) {
            sortsArray(array);
            return array[arrayLength - 1];
        }
        return 0;
    }

    /**
     * The method returns the minimum value of the array
     */
    public int getMinArrayValue(int[] array) {
        if (array.length > 0) {
            sortsArray(array);
            return array[0];
        }
        return 0;
    }

    /**
     * The method returns the average value of the array
     */
    public double getAverageArrayValue(int[] array) {
        if (array.length > 0) {
            double sumElements = 0;
            for (int value : array) {
                sumElements += value;
            }
            return sumElements / array.length;
        }
        return 0;
    }

    /**
     * The method returns information about the maximum, minimum and average values of the array
     */
    public void getMaxMinAverageInfoOfArray(int[] array) {
        System.out.println("the maximum value of the array is " + getMaxArrayValue(array) +
                "\nthe minimum value of the array is " + getMinArrayValue(array) +
                "\nthe average value of the array is " + getAverageArrayValue(array));
    }
}
