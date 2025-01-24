package Lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class Tasks {
    public void printThreeWords() {
        System.out.println("ЗАДАНИЕ 1: Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple.\n" +
                "\n");
        String s1 = "Orange";
        String s2 = "Banana";
        String s3 = "Apple";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

    public void checkSumSign() {
        System.out.println("ЗАДАНИЕ 2:Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями, которыми захотите. Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0, то вывести в консоль сообщение \"Сумма положительная\", в противном случае – \"Сумма отрицательная\".");
        System.out.println("Введите 2 числа");
        Scanner console = new Scanner(System.in);
        int a = console.nextInt();
        int b = console.nextInt();
        if (a + b >= 0)
            System.out.println("Сумма положительная");
        else
            System.out.println("Сумма отрицательная");
    }

    public void printColor() {
        System.out.println("ЗАДАНИЕ 3:Создайте метод printColor(), в теле которого задайте int переменную value и инициализируйте её любым значением.\n" +
                "\n" +
                "Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение \"Красный\".\n" +
                "Если value лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то \"Жёлтый\".\n" +
                "Если больше 100 (100 исключительно) – \"Зелёный\".");
        System.out.println("Введите число");
        Scanner console = new Scanner(System.in);

        int value = console.nextInt();
        if (value <= 0)
            System.out.println("Красный");
        else {
            if (value > 0 && value <= 100)
                System.out.println("Желтый");
            else
                System.out.println("Зеленый");

        }
    }

    public void compareNumbers() {
        System.out.println("ЗАДАНИЕ 4: Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями, которыми захотите.\n" +
                "\n" +
                "Если a больше или равно b, то необходимо вывести в консоль сообщение \"a >= b\".\n" +
                "В противном случае \"a < b\".");
        System.out.println("Введите 2 числа");
        Scanner console = new Scanner(System.in);

        int a = console.nextInt();
        int b = console.nextInt();

        if (a >= b)
            System.out.println("a >= b");
        else
            System.out.println("a < b");
    }

    public void checkSum() {
        System.out.println("ЗАДАНИЕ 5: Напишите метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно). Если да – вернуть true, в противном случае – false.");
        System.out.println("Введите 2 целых числа");
        Scanner console = new Scanner(System.in);

        int a = console.nextInt();
        int b = console.nextInt();

        boolean sumTrue;
        sumTrue = ((a + b) >= 10 && (a + b) <= 20);

        if (sumTrue) System.out.println("true");
        else System.out.println("false");

    }

    public void positiveNegative() {
        System.out.println("ЗАДАНИЕ 6: Напишите метод, которому в качестве параметра передаётся целое число. Метод должен напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.");

        System.out.println("Введите целое число");
        Scanner console = new Scanner(System.in);

        int a = console.nextInt();
        if (a >= 0)
            System.out.println("Вы ввели положительное число");
        else
            System.out.println("Вы ввели отрицательное число");
    }

    public void booleanTrueFalse() {
        System.out.println("ЗАДАНИЕ 7: Напишите метод, которому в качестве параметра передаётся целое число. Метод должен вернуть true, если число отрицательное, и вернуть false, если положительное. Замечание: ноль считаем положительным числом.");
        System.out.println("Введте целое число");
        Scanner console = new Scanner(System.in);

        int a = console.nextInt();
        boolean Positive = (a < 0);

        if (Positive)
            System.out.println("true");
        else System.out.println("false");
    }

    public void stringAndLength() {
        System.out.println("ЗАДАНИЕ 8:Напишите метод, которому в качестве аргументов передаётся строка и число. Метод должен отпечатать в консоль указанную строку указанное количество раз.");
        System.out.println("Введите строку текста");
        Scanner consoleString = new Scanner(System.in);
        String a = consoleString.nextLine();

        System.out.println("Введите число");
        Scanner consoleInt = new Scanner(System.in);

        int b = consoleInt.nextInt();
        String repeated = a.repeat(b);
        System.out.println(repeated);

    }

    public void year() {
        System.out.println("Задание 9: Напишите метод, который определяет, является ли год високосным, и возвращает boolean:\n" +
                "\n" +
                "Високосный – true\n" +
                "Не високосный – false.\n" +
                "Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.");
        System.out.println("Введите год");
        Scanner console = new Scanner(System.in);

        int a = console.nextInt();

        boolean LeapYear = (a % 4 == 0) & (a % 100 != 0) || (a % 400 == 0);

        if (LeapYear)
            System.out.println("Високосный");
        else
            System.out.println("Не високосный");
    }

    public void numericArray() {
        System.out.println("Задание 10: Задайте целочисленный массив, состоящий из элементов 0 и 1. Например: [1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1]. С помощью цикла и условия замените 0 на 1, а 1 на 0.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во элементов в массиве");
        int arrayLength = scanner.nextInt();

        int[] arr = new int[arrayLength];

        System.out.println("Введите элементы массива ( 0 или 1)");

        for (int i = 0; i < arrayLength; i++) {
            int enteredNumber = scanner.nextInt();
            while (enteredNumber != 0 && enteredNumber != 1) {
                System.out.println("Не верно! Используйте только цифры 1 или 0");
                enteredNumber = scanner.nextInt();
            }
            arr[i] = enteredNumber;
        }

        System.out.println("Ваш массив" + Arrays.toString(arr));

        for (int i = 0; i < arrayLength; i++) {
            if (arr[i] == 0)
                arr[i] = 1;

            else if (arr[i] == 1)
                arr[i] = 0;

        }
        System.out.println("Измененный массив" + Arrays.toString(arr));
    }

    public void fillArray() {
        System.out.println("Задание 11: Задайте пустой целочисленный массив длиной 100. С помощью цикла заполните его значениями 1, 2, 3, 4, 5...100.");
        int[] arr = new int[100];

        int value = 1;
        for (int i = 0; i < 100; i++) {

            arr[i] = value;
            value++;
            System.out.println(arr[i]);
        }
    }

    public void arrayMultiple6() {
        System.out.println("ЗАДАНИЕ 12: Задайте массив [1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1]. Пройдите по нему циклом, и числа меньше 6 умножьте на 2.");

        int[] arr = new int[12];
        arr[0] = 1;
        arr[1] = 5;
        arr[2] = 3;
        arr[3] = 2;
        arr[4] = 11;
        arr[5] = 4;
        arr[6] = 5;
        arr[7] = 2;
        arr[8] = 4;
        arr[9] = 8;
        arr[10] = 9;
        arr[11] = 1;

        System.out.println("Массив: " + Arrays.toString(arr));


        for (int i = 0; i < 12; i++) {
            if (arr[i] < 6)
                arr[i] = arr[i] * 2;

        }
        System.out.println("Массив, где числа < 6 умножены на 2 " + Arrays.toString(arr));
    }

    public void diagonals() {
        System.out.println("Задание 13: Создайте квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполните его диагональные элементы единицами.");

        int[][] square = new int[3][3];
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                square[i][j] = 5;
            }
        }

        for (int i = 0; i < 3; i++) {
            square[i][i] = 1;
        }


        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
    }


    public void fillArrayIntLen() {
        System.out.println("ЗАДАНИЕ 14: Напишите метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.\n");
        System.out.println("Введите длину массива");
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        System.out.println("Введите значение массива");
        int initialValue = scanner.nextInt();

        int[] arr = new int[len];
        arr = fillArray(len, initialValue);
        System.out.println("Массив" + Arrays.toString(arr));

    }

    public int[] fillArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++)
            array[i] = initialValue;
        return array;
    }
}



