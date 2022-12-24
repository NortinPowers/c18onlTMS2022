package by.tms.service;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class MinMax<A extends Number> {
    private A[] array;

    private A getMinElement() {
        Arrays.sort(array);
        return array[0];
    }

    private A getMaxElement() {
        Arrays.sort(array);
        return array[array.length - 1];
    }

    public String getMaxManElementInfo() {
        return array.getClass().getSimpleName() + " array:\n\tMax element: "
                + getMaxElement() + "\n\tMin element: " + getMinElement();
    }
}

