package by.tms.tasks;

import lombok.Getter;

import static by.tms.utils.ArraysHelper.createSpecifiedLengthArray;
import static by.tms.utils.ArraysHelper.fillingArrayNumbersFromRange;

/*
3. Создайте 2 массива из 5 чисел.
Выведите массивы на консоль в двух отдельных строках.
Посчитайте среднее арифметическое значение элементов каждого массива и
сообщите, для какого из массивов это значение оказалось больше (либо
сообщите, что их средние арифметические равны).
 */
@Getter
public class Task3 {
    private final int[] firstArray = fillingArrayNumbersFromRange(createSpecifiedLengthArray(5), -10, 10);
    private final int[] secondArray = fillingArrayNumbersFromRange(createSpecifiedLengthArray(5), -10, 10);
}
