package by.tms.utils;

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
}
