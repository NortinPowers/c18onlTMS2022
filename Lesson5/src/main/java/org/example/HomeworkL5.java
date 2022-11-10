package org.example;

import java.util.Scanner;

public class HomeworkL5 {

    public static void main(String[] args) {
//        dayInfo();
//        amoebasQuantityInfo();
//        calculateSumOfDiagonalElements();
//        printMatrix();
//        intPositiveInfo();
//        zodiac();
//        System.out.println(ancientMultiplication(2, -3));
        triangleDrawing("a");
        triangleDrawing("b");
        triangleDrawing("c");
        triangleDrawing("d");
        triangleDrawing("e");
    }

    //        Задачи:
//        1) Задача на оператор switch!
//        Рандомно генерируется число От 1 до 7.
//        Если число равно 1, выводим на консоль “Понедельник”, 2 –”Вторник” и так далее.
//        Если 6 или 7 – “Выходной”.
    public static void dayInfo() {
        int day = (int) (Math.random() * 8);
        showDayName(day);
    }

    private static void showDayName(int day) {
        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            default -> System.out.println("Sunday");
        }
    }

    //         2) Одноклеточная амеба каждые 3 часа делится на 2 клетки. Определить,
//         сколько амеб будет через 3, 6, 9, 12,..., 24 часа
    public static void amoebasQuantityInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(giveAmoebasQuantity(getParserInt(scanner)));
    }

    /**
     * A method returns an integer from the console if equal to 0 or greater
     */
    public static int getParserInt(Scanner scanner) {
        int enteredInt = -1;
        System.out.println("Enter the number of hours of observation");
        do {
            if (scanner.hasNextInt()) {
                enteredInt = scanner.nextInt();
                enteredIntInfo(enteredInt);
            } else {
                System.out.println("You need to enter an integer number of full observation hours\nRepeat the input");
                scanner.next();
            }
        } while (enteredInt < 0);
        return enteredInt;
    }

    /**
     * The method provides information about the requirements for the entered integer
     */
    private static void enteredIntInfo(int enteredInt) {
        if (enteredInt < 0) {
            System.out.println("The number of observation hours must be positive\nRepeat the input");
        }
    }

    /**
     * the method returns the number of amoebas after a given number of observation hours
     */
    public static int giveAmoebasQuantity(int hour) {
        if (hour < 0) {
            return 1;
        } else {
            int grade = hour / 3;
            return (int) Math.pow(2, grade);
        }
    }

    //        3) В переменную записываем число.
//        Надо вывести на экран сколько в этом числе цифр и положительное оно или отрицательное.
//        Например, "Введите число:" -> 5
//        "5 - это положительное число, количество цифр = 1"
    public static void intPositiveInfo() {
        Scanner scanner = new Scanner(System.in);
        int value = getInputIntValue(scanner);
        String qualifier = getStringQualifier(value);
        int digitCount = getDigitCount(value);
        System.out.println("The entered number " + value + " is " + qualifier + ", it contains " + digitCount + " digit");
//        int digitCount1 = getDigitCountSecond(value);
//        System.out.println(".. it contains " + digitCount1 + " digit");

    }

    public static int getInputIntValue(Scanner scanner) {
        int value;
        System.out.println("Input integer");
        do {
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                break;
            } else {
                System.out.println("Need integer!\nRepeat input");
                scanner.next();
            }
        } while (true);
        return value;
    }

    public static String getStringQualifier(int value) {
        String qualifier;
        if (value == 0) {
            qualifier = "a boundary value";
        } else if (value > 0) {
            qualifier = "positive";
        } else {
            qualifier = "negative";
        }
        return qualifier;
    }

    public static int getDigitCount(int value) {
        int digitCount = 0;
        if (value == 0) {
            digitCount = 1;
        } else {
            int analyzeInt = Math.abs(value);
            while (analyzeInt > 0) {
                analyzeInt /= 10;
                digitCount++;
            }
        }
        return digitCount;
    }

    public static int getDigitCountSecond(int value) {
        return String.valueOf(value).length();
    }

//      4) Дано 2 числа, день и месяц рождения. Написать программу, которая определяет знак зодиака человека.
//      many lions have become into cancer
//      https://spaceplace.nasa.gov/constellations/en/

    public static void zodiac() {
        System.out.println("Enter the day and month of birth in the format dd.mm");
        Scanner scanner = new Scanner(System.in);
        int[] dateValue = getIntsDateArray(scanner);
        String zodiacSign = getStringZodiacSign(dateValue);
        System.out.println("A person was born under the sign " + zodiacSign);
    }

    public static String getStringZodiacSign(int[] dateValue) {
        String zodiacSign = "";
        switch (dateValue[1]) {
            case 1:
                zodiacSign = dateValue[0] < 20 ? "Sagittarius" : "Capricorn";
                break;
            case 2:
                zodiacSign = dateValue[0] < 16 ? "Capricorn" : "Aquarius";
                break;
            case 3:
                zodiacSign = dateValue[0] < 11 ? "Aquarius" : "Pisces";
                break;
            case 4:
                zodiacSign = dateValue[0] < 18 ? "Pisces" : "Aries";
                break;
            case 5:
                zodiacSign = dateValue[0] < 13 ? "Aries" : "Taurus";
                break;
            case 6:
                zodiacSign = dateValue[0] < 21 ? "Taurus" : "Gemini";
                break;
            case 7:
                zodiacSign = dateValue[0] < 20 ? "Gemini" : "Cancer";
                break;
            case 8:
                zodiacSign = dateValue[0] < 10 ? "Cancer" : "Leo";
                break;
            case 9:
                zodiacSign = dateValue[0] < 16 ? "Leo" : "Virgo";
                break;
            case 10:
                zodiacSign = dateValue[0] < 30 ? "Virgo" : "Libra";
                break;
            case 11:
                if (dateValue[0] < 23) {
                    zodiacSign = "Libra";
                } else if (dateValue[0] < 29) {
                    zodiacSign = "Scorpio";
                } else {
                    zodiacSign = "Ophiuchus";
                }
                break;
            case 12:
                zodiacSign = dateValue[0] < 17 ? "Ophiuchus" : "Sagittarius";
                break;
            default:
                break;
        }
        return zodiacSign;
    }

    public static int[] getIntsDateArray(Scanner scanner) {
        int[] dateValue = new int[2];
        String[] processedEnteredCharacters;
        do {
            processedEnteredCharacters = scanner.nextLine().replace(".", ",").split(",");
            try {
                dateValue[0] = Integer.parseInt(processedEnteredCharacters[0]);
                dateValue[1] = Integer.parseInt(processedEnteredCharacters[1]);
                dateValidationCheck(dateValue);
            } catch (Exception e) {
                errorInputMessage();
            }
        }
        while (dateValue[0] == 0 || dateValue[1] == 0);
        return dateValue;
    }

    public static void dateValidationCheck(int[] dateValue) {
        if (dateValue[0] < 1 || dateValue[0] > 31 || dateValue[1] < 1 || dateValue[1] > 12) {
            dateValue[0] = 0;
            dateValue[1] = 0;
            errorInputMessage();
        }
    }

    public static void errorInputMessage() {
        System.out.println("Repeat the input according to the format dd.mm");
    }

//        5) Напишите реализацию метода sum(int a, int b), вычисляющий a*b, не пользуясь операцией
//        умножения, где a и b целые числа, вызовите метод sum в методе main и распечатайте на консоль.

    public static int ancientMultiplication(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return getMultiplicationResult(a, b);
    }

    public static int getMultiplicationResult(int a, int b) {
        if (b < 0) {
            a = -a;
        }
        int result = 0;
        for (int i = Math.abs(b); i > 0; i--) {
            result += a;
        }
        return result;
    }

//        6) Дан двухмерный массив размерностью 4 на 4, необходимо нарисовать четыре треугольника вида

    //        a)                  b)
//              *        *
//            * *        * *
//          * * *        * * *
//        * * * *        * * * *
//
//        c)                  d)
//        * * * *        * * * *
//          * * *        * * *
//            * *        * *
//              *        *
    public static void triangleDrawing(String method) {
        if (hasRealization(method)) return;
        String[][] asterisks = new String[4][4];
        arrayFills(method, asterisks);
        arrayPrints(asterisks);
    }

    private static void arrayPrints(String[][] asterisks) {
        for (String[] array : asterisks) {
            System.out.println(toString(array));
        }
    }

    private static void arrayFills(String method, String[][] asterisks) {
        boolean condition = true;
        for (int i = 0; i < asterisks.length; i++) {
            for (int j = 0; j < asterisks.length; j++) {
                switch (method) {
                    case "a" -> condition = j < asterisks.length - 1 - i;
                    case "b" -> condition = j > i;
                    case "c" -> condition = j < i;
                    case "d" -> condition = j > asterisks.length - 1 - i;
                }
                if (condition) {
                    asterisks[i][j] = " ";
                } else {
                    asterisks[i][j] = "*";
                }
            }
        }
    }

    private static boolean hasRealization(String method) {
        if (!method.equals("a") && !method.equals("b") && !method.equals("c") && !method.equals("d")) {
            System.out.println("no such method was found\n‾\\_O_/‾");
            return true;
        }
        return false;
    }

    public static String toString(String[] a) {
        if (a == null)
            return "null";

        int iMax = a.length - 1;
        if (iMax == -1)
            return "";

        StringBuilder b = new StringBuilder();
        b.append(' ');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(' ').toString();
            b.append("  ");
        }

    }


//        7) Создайте массив из всех нечётных чисел от 1 до 100, выведите его на экран в строку,
//        а затем этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 ... 7 5 3 1).

//        8) Создайте массив из int[] mass = new int[12]; Рандомно заполните его значениями от 0 до 15.
//        Определите какой элемент является в этом массиве максимальным и сообщите индекс его последнего вхождения в массив.
//        Пример: {3,4,5,62,7,8,4,-5,7,62,5,1} Максимальный элемент 62, индекс его последнего вхождения в массив = 10

//        9) Создайте массив размера 20, заполните его случайными целыми чиселами из отрезка от 0 до 20.
//        Выведите массив на экран в строку. Замените каждый элемент с нечётным индексом на ноль.
//        Снова выведете массив на экран на отдельной строке.

//        10) Найти максимальный элемент в массиве {4,5,0,23,77,0,8,9,101,2} и поменять его местами с нулевым элементом

//        11) Проверить, различны ли все элементы массива, если не различны то вывести элемент повторяющийся
//        Пример: {0,3,46,3,2,1,2}
//        Массив имеет повторяющиеся элементы 3, 2
//        Пример: {0,34,46,31,20,1,28}
//        Массив не имеет повторяющихся элементов

//        12) Создаём квадратную матрицу, размер вводим с клавиатуры.
//        Заполняем случайными числами в диапазоне от 0 до 50. И выводим на консоль(в виде матрицы).
//        Далее необходимо транспонировать матрицу(1 столбец станет 1-й строкой, 2-й столбец - 2-й строкой и т. д.)
//        Пример:
//          1 2 3 4      1 6 3 1
//          6 7 8 9      2 7 3 5
//          3 3 4 5      3 8 4 6
//          1 5 6 7      4 9 5 7


    /**
     * заполнить рандомно 2-х мерный массив и посчитать сумму элементов на диагонали
     */
    public static void calculateSumOfDiagonalElements() {
        //пишем логику и выводим результат используя System.out.println
    }


    /**
     * Шаги по реализации:
     * - Прочитать два int из консоли
     * - Создайте двумерный массив int (используйте целые числа, которые вы читаете по высоте и ширине консоли)
     * - Заполнить массив случайными значениями (до 100)
     * - Вывести в консоль матрицу заданного размера, но:
     * - Если остаток от деления элемента массива на 3 равен нулю - выведите знак "+" вместо значения элемента массива.
     * - Если остаток от деления элемента массива на 7 равен нулю - выведите знак "-" вместо значения элемента массива.
     * - В противном случае выведите "*"
     * <p>
     * Example:
     * - Значения с консоли - 2 и 3
     * - Массив будет выглядеть так (значения будут разными, потому что он случайный)
     * 6 11 123
     * 1 14 21
     * - Для этого значения вывод в консоли должен быть:
     * <p>
     * + * *
     * * - +
     * <p>
     * Обратите внимание, что 21% 3 == 0 и 21% 7 = 0, но выводить надо не +-, а +
     */
    public static void printMatrix() {
        // тут пишем логику
    }

//    Доп задача!
//    Создать матрицу размера 10 на 10 и заполнить ее случайными целочислеными значениями (тип int) из диапазона от 0 до 10000.
//    Найти максимум среди сумм трех соседних элементов в строке. Для найденной тройки с максимальной суммой выведите значение суммы и индексы(i,j) первого элемента тройки.
//    Пример:
//            *Для простоты пример показан на одномерном массиве размера 10
//            [1, 456, 1025, 65, 954, 2789, 4, 8742, 1040, 3254] Тройка с максимальной суммой:  [2789, 4, 8742]
//    Вывод в консоль:
//            11535 (0,5)
//            *Пояснение. Первое число - сумма тройки  [2789, 4, 8742]. Числа в скобках это 0 строка и 5 столбец - индекс первого элемента тройки, то есть индекс числа 2789.

}