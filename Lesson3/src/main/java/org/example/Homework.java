package org.example;

import java.util.Arrays;

public class Homework {
    public static void main(String[] args) {
        //Некоторые тесты для проверки задач.
        System.out.println(sum(100, 200));
        System.out.println(sum(Integer.MAX_VALUE, Integer.MAX_VALUE));
        System.out.println(max(56, 349));
        System.out.println(average(new int[]{0, -2, 3, -1, 5}));
        System.out.println(max(new int[]{1, 2, 3, 4, 5, 100, 99}));
        System.out.println(calculateHypotenuse(3, 4));
    }

    /**
     * 1. Метод должен вернуть сумму двух чисел a и b
     * 2. Дополнительно: сделать проверку если сумма a и b больше чем максимальное значение int то вернуть -1
     **/
    public static int sum(int a, int b) {
//        var1
        /*BigInteger aValue = new BigInteger(String.valueOf(a));
        BigInteger result = aValue.add(BigInteger.valueOf(b));
        if (result.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0) {
            return -1;
        }
        return result.intValue();*/
//        var2
        /*if ((long) a + (long) b > Integer.MAX_VALUE) {
            return -1;
        }*/
//        var 3
        if (Integer.MAX_VALUE - a < b) {
            return -1;
        }
        return a + b;
    }

    /**
     * Метод должен вернуть максимальное значение из двух чисел
     *
     * <p>
     * Example1:
     * a = 4,
     * b = 5
     * <p>
     * Метод должен вернуть 5
     * Example2:
     * a = 10,
     * b = 10
     * <p>
     * Метод должен вернуть 10
     */
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    /**
     * Метод должен вернуть среднее значение из массива чисел
     * (необходимо сумму всех элеменов массива разделить на длину массива)
     * <p>
     * Example:
     * array = {1,2,3,4,5}
     * Метод должен return 3.0
     */
    public static double average(int[] array) {
        if (array.length == 0) {
            return 0.0;
        }
        double sumArrayElements = 0;
        for (int element : array) {
            sumArrayElements += element;
        }
        return sumArrayElements / array.length;
    }

    /**
     * Метод должен вернуть максимальый элемент массива. Пример: array = {1,2,10,3} метод возвращает 10
     **/
    public static int max(int[] array) {
        if (array.length > 0) {
            Arrays.sort(array);
            return array[array.length - 1];
        } else {
            throw new ArrayIndexOutOfBoundsException("Array is empty");
        }
    }

    /**
     * Используя теорему Пифагора, вычислите значение гипотенузы. Квадрат гипотенузы = сумме квадратов катетов
     * <p>
     * Example1:
     * 3
     * 4
     * return 5
     * <p>
     * Example2:
     * 12
     * 16
     * return 20
     */
    public static double calculateHypotenuse(int a, int b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
}