package by.tms;

import by.tms.service.FirstInterface;
import com.google.common.math.BigIntegerMath;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

import static by.tms.utils.Constants.COMMAND_ONE;
import static by.tms.utils.ScannerHelper.getConditionalInputIntValue;
import static by.tms.utils.ScannerHelper.getInputIntPositiveValue;

public class MainTask3 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int inputValue = getConditionalInputIntValue(scanner);
        FirstInterface<String> firstInterface;
        if (inputValue == COMMAND_ONE) {
            System.out.println("Enter the string:");
            String str = scanner.skip("\\R").nextLine();
            firstInterface = () -> StringUtils.reverse(str);
            System.out.println("The reversed string: " + firstInterface.get());
        } else {
            int number = getInputIntPositiveValue(scanner);
            firstInterface = () -> BigIntegerMath.factorial(number).toString();
            System.out.println("The factorial of the number " + number + " is: " + firstInterface.get());
        }
    }
}