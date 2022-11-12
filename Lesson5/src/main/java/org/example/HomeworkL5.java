package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeworkL5 {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        giveDayInfo();
        giveAmoebasQuantityInfo();
        calculateSumOfDiagonalElements();
        printMatrix();
        giveIntPositiveInfo();
        giveZodiacSign();
        System.out.println(performAncientMultiplication(2, -3));
        realizeTriangleDrawing("a");
        realizeTriangleDrawing("b");
        realizeTriangleDrawing("c");
        realizeTriangleDrawing("d");
        realizeTriangleDrawing("e");
        printOddArray();
        giveMaxArrayLastElementIndex();
        changeArrayElement();
        changeArrayMaxElementIndex();
        comparisonArray(new int[]{0, 3, 46, 3, 2, 1, 2});
        comparisonArray(new int[]{0, 34, 46, 31, 20, 1, 28});
        doTransposeMatrix();
        calculateSumOfDiagonalElements();
        printMatrix();
        giveMaxSumThreeElementsMatrixString();
    }

    //        Задачи:
//        1) Задача на оператор switch!
//        Рандомно генерируется число От 1 до 7.
//        Если число равно 1, выводим на консоль “Понедельник”, 2 –”Вторник” и так далее.
//        Если 6 или 7 – “Выходной”.
    public static void giveDayInfo() {
        int day = random.nextInt(6) + 1;
        showDayName(day);
    }

    /**
     * The method returns the day of the week depending on the number entered
     */
    private static void showDayName(int day) {
        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            default -> System.out.println("Weekend");
        }
    }

    //         2) Одноклеточная амеба каждые 3 часа делится на 2 клетки. Определить,
//         сколько амеб будет через 3, 6, 9, 12,..., 24 часа
    public static void giveAmoebasQuantityInfo() {
        System.out.println(giveAmoebasQuantity(getParserInt(scanner)));
    }

    /**
     * The method returns an integer from the console if equal to 0 or greater
     */
    public static int getParserInt(Scanner scanner) {
        int enteredInt = -1;
        System.out.println("Enter the number of hours of observation");
        do {
            if (scanner.hasNextInt()) {
                enteredInt = scanner.nextInt();
                providesEnteredIntInfo(enteredInt);
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
    private static void providesEnteredIntInfo(int enteredInt) {
        if (enteredInt < 0) {
            System.out.println("The number of observation hours must be positive\nRepeat the input");
        }
    }

    /**
     * The method returns the number of amoebas after a given number of observation hours
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
    public static void giveIntPositiveInfo() {
        int value = getInputIntValue(scanner);
        String qualifier = getStringQualifier(value);
        int digitCount = getDigitCount(value);
        System.out.println("The entered number " + value + " is " + qualifier + ", it contains " + digitCount + " digit");
    }

    /**
     * The method returns an integer from the console
     */
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

    /**
     * The method returns the characteristic of a number
     */
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

    /**
     * The method returns the bit depth of a number
     */
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

    /**
     * The method returns the bit depth of a number (but easier realization)
     */
    public static int getDigitCountSecond(int value) {
        return String.valueOf(Math.abs(value)).length();
    }

//      4) Дано 2 числа, день и месяц рождения. Написать программу, которая определяет знак зодиака человека.
//      Many lions have become cancer -> https://spaceplace.nasa.gov/constellations/en/

    public static void giveZodiacSign() {
        System.out.println("Enter the day and month of birth in the format dd.mm");
        int[] dateValue = getIntsDateArray(scanner);
        String zodiacSign = getStringZodiacSign(dateValue);
        System.out.println("A person was born under the sign " + zodiacSign);
    }

    /**
     * The method returns the zodiac sign by date
     */
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

    /**
     * The method returns the date value from the console
     */
    public static int[] getIntsDateArray(Scanner scanner) {
        int[] dateValue = new int[2];
        do {
            String[] processedEnteredCharacters = scanner.nextLine().split("\\.");
            try {
                dateValue[0] = Integer.parseInt(processedEnteredCharacters[0]);
                dateValue[1] = Integer.parseInt(processedEnteredCharacters[1]);
                checkDateValidation(dateValue);
            } catch (Exception e) {
                giveErrorInputMessage(e.getMessage());
            }
        } while (dateValue[0] == 0 || dateValue[1] == 0);
        return dateValue;
    }

    /**
     * The method verifies the date
     */
    public static void checkDateValidation(int[] dateValue) {
        if (dateValue[0] < 1 || dateValue[0] > 31 || dateValue[1] < 1 || dateValue[1] > 12) {
            dateValue[0] = 0;
            dateValue[1] = 0;
            giveErrorInputMessage("Impossible date");
        }
    }

    /**
     * The method shows a message if an error was made when entering the date
     */
    public static void giveErrorInputMessage(String exceptionMessage) {
        System.out.println("Repeat the input according to the format dd.mm" + " (" + exceptionMessage + ")");
    }

//        5) Напишите реализацию метода sum(int a, int b), вычисляющий a*b, не пользуясь операцией
//        умножения, где a и b целые числа, вызовите метод sum в методе main и распечатайте на консоль.

    public static int performAncientMultiplication(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return getMultiplicationResult(a, b);
    }

    /**
     * The method performs multiplication of numbers without using multiplication of numbers
     */
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
    public static void realizeTriangleDrawing(String method) {
        if (hasNoRealization(method)) return;
        String[][] asterisks = new String[4][4];
        fillsArray(method, asterisks);
        printsArray(asterisks);
    }

    /**
     * The method applies toString to a two-dimensional String array
     */
    private static void printsArray(String[][] asterisks) {
        for (String[] array : asterisks) {
            System.out.println(convertsToString(array));
        }
    }

    /**
     * The method fills the array according to the condition of the task
     */
    private static void fillsArray(String method, String[][] asterisks) {
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

    /**
     * The method for checking acceptable task conditions
     */
    public static boolean hasNoRealization(String method) {
        if (!method.equals("a") && !method.equals("b") && !method.equals("c") && !method.equals("d")) {
            System.out.println("no such method was found\n       ‾\\_O_/‾");
            return true;
        }
        return false;
    }

    /**
     * The convenient method toString
     */
    public static String convertsToString(String[] a) {
        if (a == null) {
            return "null";
        }

        int iMax = a.length - 1;
        if (iMax == -1) {
            return "";
        }

        StringBuilder b = new StringBuilder();
        b.append(' ');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax) {
                return b.append(' ').toString();
            }
            b.append("  ");
        }

    }


//        7) Создайте массив из всех нечётных чисел от 1 до 100, выведите его на экран в строку,
//        а затем этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 ... 7 5 3 1).

    public static void printOddArray() {
        int[] array = new int[100];
        int index = getIndex(array);
        int[] oddArray = new int[index];
        System.arraycopy(array, 0, oddArray, 0, oddArray.length);
        System.out.println(Arrays.toString(oddArray));
        overridePosition(oddArray);
        System.out.println(Arrays.toString(oddArray));
    }

    /**
     * The method sorts the array elements from the last to the first
     */
    private static void overridePosition(int[] oddArray) {
        int intermediate;
        for (int i = 0, j = oddArray.length - 1; i <= j; i++, j--) {
            intermediate = oddArray[i];
            oddArray[i] = oddArray[j];
            oddArray[j] = intermediate;
        }
    }

    public static int getIndex(int[] array) {
        int index = 0;
        int element = 0;
        do {
            if (element % 2 != 0) {
                array[index] = element;
                index++;
            }
            element++;
        } while (element < 100);
        return index;
    }


//        8) Создайте массив из int[] mass = new int[12]; Рандомно заполните его значениями от 0 до 15.
//        Определите какой элемент является в этом массиве максимальным и сообщите индекс его последнего вхождения в массив.
//        Пример: {3,4,5,62,7,8,4,-5,7,62,5,1} Максимальный элемент 62, индекс его последнего вхождения в массив = 9

    public static void giveMaxArrayLastElementIndex() {
        int[] mass = new int[12];
        fillsArray(mass, 16);
        System.out.println("Created array: " + Arrays.toString(mass));
        int[] requiredInts = getRequiredInts(mass);
        System.out.println("The maximum element is " + requiredInts[0] + ", the index of its last " +
                "appearance in the array = " + requiredInts[1]);
    }

    /**
     * The method return array with the value and the last index of the maximum element of the array
     */
    public static int[] getRequiredInts(int[] mass) {
        int[] result = new int[2];
        int tempMax = mass[mass.length - 1];
        int tempMaxIndex = 0;
        for (int i = mass.length - 2; i > -1; i--) {
            if (mass[i] > tempMax) {
                tempMax = mass[i];
                tempMaxIndex = i;
            }
        }
        result[0] = tempMax;
        result[1] = tempMaxIndex;
        return result;
    }

    /**
     * The method fills the array with random values in a given range
     */
    public static void fillsArray(int[] mass, int count) {
        for (int i = 0; i < mass.length; i++) {
            mass[i] = random.nextInt(count);
        }
    }

//        9) Создайте массив размера 20, заполните его случайными целыми числами из отрезка от 0 до 20.
//        Выведите массив на экран в строку. Замените каждый элемент с нечётным индексом на ноль.
//        Снова выведете массив на экран на отдельной строке.

    public static void changeArrayElement() {
        int[] array = new int[20];
        fillsArray(array, 21);
        chandeOddIndexElementChange(array);

    }

    private static void chandeOddIndexElementChange(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            array[i] = 0;
        }
        System.out.println(Arrays.toString(array));
    }

    //        10) Найти максимальный элемент в массиве {4,5,0,23,77,0,8,9,101,2} и поменять его местами с нулевым элементом
    public static void changeArrayMaxElementIndex() {
        int[] array = {4, 5, 0, 23, 77, 0, 8, 9, 101, 2};
        System.out.println(Arrays.toString(array));
        swapMaxElementIndex(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * The method swaps the maximum and zero elements of the array in places
     */
    private static void swapMaxElementIndex(int[] array) {
        int temp = array[0];
        int[] requiredInts = getRequiredInts(array);
        array[0] = requiredInts[0];
        array[requiredInts[1]] = temp;
    }

//        11) Проверить, различны ли все элементы массива, если не различны то вывести элемент повторяющийся
//        Пример: {0,3,46,3,2,1,2}
//        Массив имеет повторяющиеся элементы 3, 2
//        Пример: {0,34,46,31,20,1,28}
//        Массив не имеет повторяющихся элементов

    public static void comparisonArray(int[] array) {
        int[] similarity = new int[array.length];
        int similarityIndex = getSimilarityIndex(array, similarity);
        displaysIdenticalElements(similarity, similarityIndex);

    }

    public static int getSimilarityIndex(int[] array, int[] similarity) {
        int similarityIndex = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    similarity[similarityIndex] = array[i];
                    similarityIndex++;
                }
            }
        }
        return similarityIndex;
    }

    public static void displaysIdenticalElements(int[] similarity, int similarityIndex) {
        if (similarityIndex > 0) {
            int[] similar = new int[similarityIndex];
            System.arraycopy(similarity, 0, similar, 0, similar.length);
            System.out.println(Arrays.toString(similar));
        } else {
            System.out.println("There are no identical elements in the array");
        }
    }

//        12) Создаём квадратную матрицу, размер вводим с клавиатуры.
//        Заполняем случайными числами в диапазоне от 0 до 50. И выводим на консоль(в виде матрицы).
//        Далее необходимо транспонировать матрицу(1 столбец станет 1-й строкой, 2-й столбец - 2-й строкой и т. д.)
//        Пример:
//          1 2 3 4      1 6 3 1
//          6 7 8 9      2 7 3 5
//          3 3 4 5      3 8 4 6
//          1 5 6 7      4 9 5 7

    public static void doTransposeMatrix() {
//        Scanner scanner = new Scanner(System.in);
        int enteredInt = getParserInteger(scanner);
        int[][] matrix = getFilledMatrix(enteredInt, 51);
        printsArray(matrix);
        System.out.println("--some magic--");
        doTranspose(matrix);
        printsArray(matrix);
    }

    /**
     * The method return the matrix with random values in a given range
     */
    public static int[][] getFilledMatrix(int size, int valueRange) {
        int[][] matrix = new int[size][size];
        doFilling(matrix, valueRange);
        return matrix;

    }

    /**
     * The method fills the matrix with random values in a given range
     */
    private static void doFilling(int[][] matrix, int valueRange) {
        for (int[] array : matrix) {
            fillsArray(array, valueRange);
        }
    }

    /**
     * The method transpose the matrix
     */
    private static void doTranspose(int[][] matrix) {
        int temp;
        int i = 0;
        while (i < matrix.length - 1) {
            for (int j = i; j < matrix.length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            i++;
        }
    }

    /**
     * The method applies toString to a two-dimensional Integer array
     */
    private static void printsArray(int[][] matrix) {
        for (int[] array : matrix) {
            System.out.println(convertsToString(array));
        }
    }

    /**
     * The convenient method toString
     */
    public static String convertsToString(int[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "";
        }
        StringBuilder b = new StringBuilder();
        b.append(' ');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax) {
                return b.append(' ').toString();
            }
            b.append("  ");
        }

    }

    /**
     * A method returns an integer from the console if it is positive
     */
    public static int getParserInteger(Scanner scanner) {
        int enteredInt = -1;
        do {
            giveEntIntInfo(enteredInt);
            if (scanner.hasNextInt()) {
                enteredInt = scanner.nextInt();
            } else {
                System.out.println("To build a matrix, you need to enter a positive integer\nRepeat the input");
                scanner.next();
            }
        } while (enteredInt <= 0);
        return enteredInt;
    }

    /**
     * The method provides information about the requirements for the entered number
     */
    private static void giveEntIntInfo(int enteredInt) {
        if (enteredInt < 0) {
            System.out.println("Enter the size of the matrix (the required number is greater than 0)");
        } else {
            System.out.println("For a matrix of size 0, this method is useless 0\nRepeat the input");
        }
    }

//    task13

    /**
     * заполнить рандомно 2-х мерный массив и посчитать сумму элементов на диагонали
     */
    public static void calculateSumOfDiagonalElements() {
        int[][] matrix = getFilledMatrix(random.nextInt(10) + 1, random.nextInt(51));
        int sum = getDiagonalMatrixSum(matrix);
        printsArray(matrix);
        System.out.println(sum);
    }

    /**
     * The returns the sum of the matrix elements diagonally
     */
    public static int getDiagonalMatrixSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    //task14

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
        System.out.println("Enter the size of the two-dimensional array in the format \"INTEGER INTEGER\" ");
        int[] formatValue = getTwoEnteredIntsArray(scanner);
        int[][] matrix = new int[formatValue[0]][formatValue[1]];
        doFilling(matrix, random.nextInt(101));
        System.out.println();
        printsArray(matrix);
        System.out.println();
        printArrayTaskCondition(matrix);
    }

    private static void printArrayTaskCondition(int[][] matrix) {
        String displayedElement;
        int arrayElement;
        for (int[] array : matrix) {
            for (int j = 0; j < array.length; j++) {
                if (j > 0 || j < array.length - 1) {
                    System.out.print(" ");
                }
                arrayElement = array[j];
                if (arrayElement % 3 == 0) {
                    displayedElement = "+";
                } else if (arrayElement % 7 == 0) {
                    displayedElement = "-";
                } else {
                    displayedElement = "*";
                }
                System.out.print(displayedElement);
            }
            System.out.println();
        }
    }

    public static int[] getTwoEnteredIntsArray(Scanner scanner) {
        int[] intValue = new int[2];
        String[] processedEnteredCharacters;
        do {
            processedEnteredCharacters = scanner.nextLine().split(" ");
            try {
                intValue[0] = Integer.parseInt(processedEnteredCharacters[0]);
                intValue[1] = Integer.parseInt(processedEnteredCharacters[1]);
                validationCheck(intValue);
            } catch (Exception e) {
                giveErrorMessage(e.getMessage());
            }
        }
        while (intValue[0] <= 0 || intValue[1] <= 0);
        return intValue;
    }

    public static void giveErrorMessage(String errorMessage) {
        System.out.println("Repeat the input according to the format \"INTEGER INTEGER\"" + "(" + errorMessage + ")");
    }

    public static void validationCheck(int[] intValue) {
        if (intValue[0] < 1 || intValue[1] < 1) {
            intValue[0] = 0;
            intValue[1] = 0;
            giveErrorMessage("Invalid array size");
        }
    }

    //    task15
    //    Доп задача!
//    Создать матрицу размера 10 на 10 и заполнить ее случайными целочисленными значениями (тип int)
//    из диапазона от 0 до 10000.
//    Найти максимум среди сумм трех соседних элементов в строке.
//    Для найденной тройки с максимальной суммой выведите значение суммы и индексы(i,j) первого элемента тройки.
//    Пример:
//            *Для простоты пример показан на одномерном массиве размера 10
//            [1, 456, 1025, 65, 954, 2789, 4, 8742, 1040, 3254] Тройка с максимальной суммой:  [2789, 4, 8742]
//    Вывод в консоль:
//            11535 (0,5)
//            *Пояснение. Первое число - сумма тройки  [2789, 4, 8742].
//            Числа в скобках это 0 строка и 5 столбец - индекс первого элемента тройки, то есть индекс числа 2789.
    public static void giveMaxSumThreeElementsMatrixString() {
        int[][] matrix = getFilledMatrix(10, random.nextInt(10001));
        printsArray(matrix);
        int maxSum = matrix[0][0] + matrix[0][1] + matrix[0][2];
        int tempSum;
        int[] maxSumIndex = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length - 3; j++) {
                tempSum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2];
                if (maxSum < tempSum) {
                    maxSum = tempSum;
                    maxSumIndex[0] = i;
                    maxSumIndex[1] = j;
                }
            }
        }
        System.out.println("Max sum = " + maxSum + " " + "( i: " + maxSumIndex[0] + " j: " + maxSumIndex[1] + " )");
    }
}