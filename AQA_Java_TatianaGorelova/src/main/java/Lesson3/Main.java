package Lesson3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tasks tasks = new Tasks();


        int task;
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Выберите 1 из 14 заданий");

            task = scanner.nextInt();

            switch (task) {
                case 1:
                    tasks.printThreeWords();
                    break;
                case 2:
                    tasks.checkSumSign();
                    break;
                case 3:
                    tasks.printColor();
                    break;
                case 4:
                    tasks.compareNumbers();
                    break;
                case 5:
                    tasks.checkSum();
                    break;
                case 6:
                    tasks.positiveNegative();
                    break;
                case 7:
                    tasks.booleanTrueFalse();
                    break;
                case 8:
                    tasks.stringAndLength();
                    break;
                case 9:
                    tasks.year();
                    break;
                case 10:
                    tasks.numericArray();
                    break;
                case 11:
                    tasks.fillArray();
                    break;
                case 12:
                    tasks.arrayMultiple6();
                    break;
                case 13:
                    tasks.diagonals();
                    break;
                case 14:
                    tasks.fillArrayIntLen();
                    break;
                case 0:
                    System.out.println("Спасибо!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Нет такого задания! Введите номер задания от 1 до 14");
            }
        }
    }
}




