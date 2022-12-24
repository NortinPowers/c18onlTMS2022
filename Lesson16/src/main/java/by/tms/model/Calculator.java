package by.tms.model;

import lombok.NonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
    public static <N extends Number> BigDecimal sum(@NonNull N num1, @NonNull N num2) {
        return BigDecimal.valueOf(num1.doubleValue()).add(BigDecimal.valueOf(num2.doubleValue()))
                .setScale(3, RoundingMode.CEILING);
    }

    public static <N extends Number> BigDecimal multiply(@NonNull N num1, @NonNull N num2) {
        return BigDecimal.valueOf(num1.doubleValue()).multiply(BigDecimal.valueOf(num2.doubleValue()))
                .setScale(3, RoundingMode.CEILING);
    }

    public static <N extends Number> BigDecimal divide(@NonNull N num1, @NonNull N num2) {
        return (BigDecimal.valueOf(num1.doubleValue()).divide(BigDecimal.valueOf(num2.doubleValue()),
                3, RoundingMode.CEILING));
    }

    public static <N extends Number> BigDecimal subtraction(@NonNull N num1, @NonNull N num2) {
        return BigDecimal.valueOf(num1.doubleValue()).subtract(BigDecimal.valueOf(num2.doubleValue()))
                .setScale(3, RoundingMode.CEILING);
    }
}
