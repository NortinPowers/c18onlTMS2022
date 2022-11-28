package by.tms.tasks;

import lombok.Getter;

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
}
