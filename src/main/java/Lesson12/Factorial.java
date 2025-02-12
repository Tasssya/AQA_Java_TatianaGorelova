package Lesson12;

import java.util.Scanner;

public class Factorial {
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

    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

}