package by.tms.service;

import lombok.NonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static by.tms.utils.Constants.NUMBER_SCALE;

public class Calculator {
    public static <N extends Number> BigDecimal sum(@NonNull N num1, @NonNull N num2) {
        return BigDecimal.valueOf(num1.doubleValue()).add(BigDecimal.valueOf(num2.doubleValue()))
                .setScale(NUMBER_SCALE, RoundingMode.CEILING);
    }

    public static <N extends Number> BigDecimal multiply(@NonNull N num1, @NonNull N num2) {
        return BigDecimal.valueOf(num1.doubleValue()).multiply(BigDecimal.valueOf(num2.doubleValue()))
                .setScale(NUMBER_SCALE, RoundingMode.CEILING);
    }

    public static <N extends Number> BigDecimal divide(@NonNull N num1, @NonNull N num2) {
        return (BigDecimal.valueOf(num1.doubleValue()).divide(BigDecimal.valueOf(num2.doubleValue()),
                NUMBER_SCALE, RoundingMode.CEILING));
    }

    public static <N extends Number> BigDecimal subtraction(@NonNull N num1, @NonNull N num2) {
        return BigDecimal.valueOf(num1.doubleValue()).subtract(BigDecimal.valueOf(num2.doubleValue()))
                .setScale(NUMBER_SCALE, RoundingMode.CEILING);
    }
}
