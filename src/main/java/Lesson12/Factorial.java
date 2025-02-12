package Lesson12;

import java.util.Scanner;

/**
 * Класс Factorial предоставляет методы для вычисления факториала числа
 * Делает проверку на отрицательные числа и использует рекурсивный подход
 */
public class Factorial {

    /**
     * Точка входа в программу. Запрашивает у пользователя число для вычисления факториала
     * и выводит результат в консоль.
     *
     * @param args аргументы командной строки (не используются в данной программе)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число для факториала: ");
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("Факториал не может быть отрицательным.");
        } else {
            long result = factorial(number);
            System.out.println("Факториал " + number + " = " + result);
        }
    }

    /**
     * Считает факториал заданного числа с использованием рекурсии.
     *
     * @param n неотрицательное целое число, для которого нужно посчитать факториал
     * @return факториал числа n
     * @throws IllegalArgumentException если передано отрицательное число
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал не может быть отрицательным");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}