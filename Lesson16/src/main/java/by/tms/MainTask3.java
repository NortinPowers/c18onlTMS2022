package by.tms;

import by.tms.service.MinMax;

public class MainTask3 {
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5, 6};
        Double[] doubles = new Double[]{-1.0, 5.6, 10.5, 16.6};
        MinMax<Integer> integerMinMax = new MinMax<>(integers);
        System.out.println(integerMinMax.getMaxManElementInfo());
        MinMax<Double> doubleMinMax = new MinMax<>(doubles);
        System.out.println(doubleMinMax.getMaxManElementInfo());
    }
}
