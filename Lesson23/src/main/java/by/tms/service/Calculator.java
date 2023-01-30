package by.tms.service;

public class Calculator implements CalculatorAware {

    @Override
    public String addition(String valueOne, String valueTwo) {
        try {
            return String.valueOf(Double.parseDouble(valueOne) + Double.parseDouble(valueTwo));
        } catch (Exception e) {
            return "Exception: " + e.getMessage();
        }
    }

    @Override
    public String multiplication(String valueOne, String valueTwo) {
        try {
            return String.valueOf(Double.parseDouble(valueOne) * Double.parseDouble(valueTwo));
        } catch (Exception e) {
            return "Exception: " + e.getMessage();
        }
    }

    @Override
    public String division(String valueOne, String valueTwo) {
        try {
            double result = Double.parseDouble(valueOne) / Double.parseDouble(valueTwo);
            return String.valueOf(result);
        } catch (Exception e) {
            return "Exception: " + e.getMessage();
        }
    }

    @Override
    public String subtraction(String valueOne, String valueTwo) {
        try {
            return String.valueOf(Double.parseDouble(valueOne) - Double.parseDouble(valueTwo));
        } catch (Exception e) {
            return "Exception: " + e.getMessage();
        }
    }
}