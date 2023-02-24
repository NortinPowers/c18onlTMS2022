package by.tms.service;

import java.util.Arrays;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MinMax<A extends Number> {

    private A[] array;

    /**
     * The method returns the minimum element of the array
     *
     * @return A extends Number
     */
    private A getMinElement() {
        Arrays.sort(array);
        return array[0];
    }

    /**
     * The method returns the maximum element of the array
     *
     * @return A extends Number
     */
    private A getMaxElement() {
        Arrays.sort(array);
        return array[array.length - 1];
    }

    /**
     * The method returns information about the minimum and maximum element of the array
     *
     * @return String
     */
    public String getMaxManElementInfo() {
        return array.getClass().getSimpleName() + " array:\n\tMax element: "
                + getMaxElement() + "\n\tMin element: " + getMinElement();
    }
}

