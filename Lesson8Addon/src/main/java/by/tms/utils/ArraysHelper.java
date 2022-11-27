package by.tms.utils;

import java.util.Random;

public final class ArraysHelper {

    static Random random = new Random();

    private ArraysHelper() {
    }

    public static int[] createFixedLengthArray(int length) {
        return new int[length];
    }

    public static int[] createRandomLengthArray() {
        int length = random.nextInt(Integer.MAX_VALUE);
        return new int[length];
    }

    public static int[] createRandomLimitLengthArray(int limit) {
        int length = random.nextInt(limit) + 1;
        return new int[length];
    }

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

    public static int[] fillingArrayNumbersFromRange(int[] array, int minValue, int maxValue) {
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt((maxValue - minValue) + 1) + minValue;
        }
        return array;
    }
}
