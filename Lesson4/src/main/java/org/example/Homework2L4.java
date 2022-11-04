package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Homework2L4 {

    public static void main(String[] args) {
        //Некоторые тесты для проверки задач. Можно также написать свои тесты.
        printArray();
        System.out.println(operation(1));
        System.out.println(operation(0));
        System.out.println(calculateCountOfOddElementsInMatrix(new int[]{1, 2, 3, 4, 5, 6}));
        countDevs(103);
        countDevs(11);
        foobar(6);
        foobar(10);
        foobar(15);
        printPrimeNumbers();
    }

    /**
     * Необходимо прочитать с консоли значение числа типа int,
     * сделать проверку, что если пользователь ввел не положительное число,
     * то вывести ошибку и отправить пользователя вводить заново новое число!
     * далее создать одномерный массив типа int размера прочитанного с консоли
     * далее заполнить массив случайными значениями
     * далее вывести массив на консоль
     */
    private static void printArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter positive integer");
        int enteredInt = 0;
        try {
            enteredInt = getParserInt(scanner);
        } catch (Exception e) {
            System.out.println("Error input (" + e.getMessage() + ")");
        }
        extracted(enteredInt);
    }

    /**
     * The method extract value and repeat printArray() if necessary
     */
    private static void extracted(int enteredInt) {
        if (isPositive(enteredInt)) {
            int[] intsArray = getIntsArray(enteredInt);
            System.out.println(Arrays.toString(intsArray));
        } else {
            System.out.println("You need to enter a positive integer\nRepeat the input");
            printArray();
        }
    }

    /**
     * The method checks whether the number is positive
     */
    public static boolean isPositive(int value) {
        return value > 0;
    }

    /**
     * A method returns the entered integer value
     */
    public static int getParserInt(Scanner scanner) {
        return scanner.nextInt();
    }

    /**
     * The method creates an array of the required length
     */
    public static int[] getIntsArray(int enteredInt) {
        int[] intsArray = new int[enteredInt];
        for (int i = 0; i < intsArray.length; i++) {
            intsArray[i] = (int) (Math.random() * 11);
        }
        return intsArray;
    }

    /**
     * Метод должен выполнять некоторую операцию с int "number" в зависимости от некоторых условий:
     * - if number положительное число, то необходимо number увеличить на 1
     * - if number отрицательное - уменьшить на 2
     * - if number равно 0, то замените значение number на 10
     * вернуть number после выполнения операций
     */
    public static int operation(int number) {
        if (number > 0) {
            return ++number;
        } else {
            if (number < 0) {
                return number - 2;
            } else {
                return 10;
            }
        }
    }

    /**
     * На вход приходит массив целых чисел типа int
     * Необходимо найти количество нечетных элементов в массиве и вернуть значение в метод main,
     * в котором это значение распечатается на консоль.
     */
    public static int calculateCountOfOddElementsInMatrix(int[] ints) {
        int countOdd = 0;
        for (int anInt : ints) {
            if (anInt % 2 != 0) {
                countOdd++;
            }
        }
        return countOdd;
    }

    /**
     * На вход приходит число.
     * Вывести в консоль фразу из разряда "_COUNT_ программистов",
     * заменить _COUNT_ на число которое пришло на вход в метод и заменить окончание в слове "программистов" на
     * уместное с точки зрения русского языка.
     * Пример: 1 программист, 42 программиста, 50 программистов
     *
     * @param count - количество программистов
     */
    public static void countDevs(int count) {
        int modifyCount = processingModifyCount(count);
        String postfix;
        postfix = getPostfix(modifyCount);
        System.out.println(count + " программист" + postfix);
    }

    /**
     * The method generates the necessary postfix
     */
    public static String getPostfix(int count) {
        String postfix = "";
        switch (count) {
            case 1:
                break;
            case 2, 3, 4:
                postfix = "а";
                break;
            default:
                postfix = "ов";
                break;
        }
        return postfix;
    }

    /**
     * The method processes a given count of programmers to provide the method getPostfix
     */
    public static int processingModifyCount(int count) {
        count = Math.abs(count);
        while (count > 100) {
            count -= 100;
        }
        if (count > 20) {
            return (count % 10);
        } else {
            return count;
        }
    }

    /**
     * Метод должен выводить разные строки в консоли в зависимости от некоторых условий:
     * - если остаток от деления на 3 равен нулю - выведите "foo" (example of number - 6)
     * - если остаток от деления на 5 равен нулю - вывести "bar" (example of number - 10)
     * - если остаток от деления на 3 и 5 равен нулю 0 ,то вывести "foobar" (example of number - 15)
     */
    public static void foobar(int number) {
        int result3Dividing = number % 3;
        int result5Dividing = number % 5;
        if (result3Dividing == 0 && result5Dividing == 0) {
            System.out.println("foobar");
        } else {
            if (result3Dividing == 0) {
                System.out.println("foo");
            }
            if (result5Dividing == 0) {
                System.out.println("bar");
            }
        }
    }

    /**
     * Задача со звездочкой!
     * Метод должен печатать все простые числа <1000
     * подробнее о просты числах (<a href="https://www.webmath.ru/poleznoe/formules_18_5.php">...</a>)
     */
    public static void printPrimeNumbers() {
        List<Integer> primeNumberList = new ArrayList<>();
        for (int i = 2; i < 1000; i++) {
            if (isPrimeNumber(i)) {
                primeNumberList.add(i);
            }
        }
        System.out.println(primeNumberList);
    }

    /**
     * The method checks whether an integer is a prime number
     */
    public static boolean isPrimeNumber(int i) {
        switch (i) {
            case 2, 3, 5, 7:
                return true;
            default:
                break;
        }
        return i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0;
    }
}
