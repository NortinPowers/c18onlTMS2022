package by.tms.utils;

import java.util.Arrays;
import java.util.Random;

public final class ArraysHelper {

    static Random random = new Random();

    private ArraysHelper() {
    }

    /**
     * The method creates an array of numbers of a given length
     */
    public static int[] createSpecifiedLengthArray(int length) {
        return new int[length];
    }

    /**
     * The method creates an array of numbers of a random length
     */
    public static int[] createRandomLengthArray() {
        int length = random.nextInt(Integer.MAX_VALUE);
        return new int[length];
    }

    /**
     * The method creates an array of numbers in a given length range
     */
    public static int[] createRandomLimitLengthArray(int limit) {
        int length = random.nextInt(limit) + 1;
        return new int[length];
    }

    /**
     * The method fills an integer array with random values
     */
    public static int[] fillingArrayWithRandomNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (random.nextInt(2) == 1) {
                array[i] = random.nextInt(Integer.MAX_VALUE);
            } else {
                array[i] = -random.nextInt(Integer.MAX_VALUE);
            }
        }
        return array;
    }

    /**
     * The method fills an integer array with random values in a certain range
     */
    public static int[] fillingArrayNumbersFromRange(int[] array, int minValue, int maxValue) {
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt((maxValue - minValue) + 1) + minValue;
        }
        return array;
    }

    /**
     * The method sorts an integer array
     */
    public static void sortsArray(int[] array) {
        if (array.length > 0) {
            Arrays.sort(array);
        }
    }

    /**
     * The method returns the maximum value of the array
     */
    public static int getMaxArrayValue(int[] array) {
        if (array.length > 0) {
            sortsArray(array);
            return array[array.length - 1];
        }
        return 0;
    }

    /**
     * The method returns the minimum value of the array
     */
    public static int getMinArrayValue(int[] array) {
        if (array.length > 0) {
            sortsArray(array);
            return array[0];
        }
        return 0;
    }

    /**
     * The method returns the average value of the array
     */
    public static double getAverageArrayValue(int[] array) {
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
    public static void getMaxMinAverageInfoOfArray(int[] array) {
        System.out.println("the maximum value of the array is " + getMaxArrayValue(array) +
                "\nthe minimum value of the array is " + getMinArrayValue(array) +
                "\nthe average value of the array is " + getAverageArrayValue(array));
    }
}
