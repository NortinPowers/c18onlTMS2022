package by.tms.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator implements CalculatorAware {
    private final Integer precision = 3;
    private final MathContext mathContext = new MathContext(precision, RoundingMode.CEILING);

    @Override
    public String addition(String valueOne, String valueTwo) {
        try {
            return String.valueOf(new BigDecimal(valueOne).add(new BigDecimal(valueTwo), mathContext));
        } catch (Exception e) {
            return "Exception: " + e.getMessage();
        }
    }

    @Override
    public String multiplication(String valueOne, String valueTwo) {
        try {
            return String.valueOf(new BigDecimal(valueOne).multiply(new BigDecimal(valueTwo), mathContext));
        } catch (Exception e) {
            return "Exception: " + e.getMessage();
        }
    }

    @Override
    public String division(String valueOne, String valueTwo) {
        try {

            return String.valueOf(new BigDecimal(valueOne).divide(new BigDecimal(valueTwo), precision, RoundingMode.CEILING));
        } catch (Exception e) {
            return "Exception: " + e.getMessage();
        }
    }

    @Override
    public String subtraction(String valueOne, String valueTwo) {
        try {
            return String.valueOf(new BigDecimal(valueOne).subtract(new BigDecimal(valueTwo), mathContext));
        } catch (Exception e) {
            return "Exception: " + e.getMessage();
        }
    }
}