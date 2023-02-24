package by.tms.service;

import static by.tms.utils.Constants.NUMBER_SCALE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.NonNull;

public class Calculator {

    /**
     * The method returns the result of sum two numbers
     *
     * @param num1 extends Number
     * @param num2 extends Number
     * @return BigDecimal
     */
    public static <N extends Number> BigDecimal sum(@NonNull N num1, @NonNull N num2) {
        return BigDecimal.valueOf(num1.doubleValue()).add(BigDecimal.valueOf(num2.doubleValue()))
                         .setScale(NUMBER_SCALE, RoundingMode.CEILING);
    }

    /**
     * The method returns the result of multiplying two numbers
     *
     * @param num1 extends Number
     * @param num2 extends Number
     * @return BigDecimal
     */
    public static <N extends Number> BigDecimal multiply(@NonNull N num1, @NonNull N num2) {
        return BigDecimal.valueOf(num1.doubleValue()).multiply(BigDecimal.valueOf(num2.doubleValue()))
                         .setScale(NUMBER_SCALE, RoundingMode.CEILING);
    }

    /**
     * The method returns the result of divide two numbers
     *
     * @param num1 extends Number
     * @param num2 extends Number
     * @return BigDecimal
     */
    public static <N extends Number> BigDecimal divide(@NonNull N num1, @NonNull N num2) {
        return (BigDecimal.valueOf(num1.doubleValue()).divide(BigDecimal.valueOf(num2.doubleValue()),
                                                              NUMBER_SCALE, RoundingMode.CEILING));
    }

    /**
     * The method returns the result of subtracting two numbers
     *
     * @param num1 extends Number
     * @param num2 extends Number
     * @return BigDecimal
     */
    public static <N extends Number> BigDecimal subtraction(@NonNull N num1, @NonNull N num2) {
        return BigDecimal.valueOf(num1.doubleValue()).subtract(BigDecimal.valueOf(num2.doubleValue()))
                         .setScale(NUMBER_SCALE, RoundingMode.CEILING);
    }
}
