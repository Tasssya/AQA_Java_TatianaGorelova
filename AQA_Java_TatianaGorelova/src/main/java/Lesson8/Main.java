package Lesson8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyArraySizeExeption, MyArrayDataExeption {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число строк массива (4)");
        int a;
/**
 * Цикл,запрашивает кол-во строк;
 * Если строк != 4, выбрасываем исключение
 */
        while (true) {
            a = scanner.nextInt();
            try {
                if (a != 4) {
                    throw new MyArraySizeExeption();
                }
                break;
            } catch (MyArraySizeExeption e) {
                System.out.println("Число строк должно быть 4. Введите 4");
            }
        }


/**
 * Цикл,запрашивает кол-во столбцов;
 * Если столбцов != 4, выбрасываем исключение
 */

        System.out.println("Введите число столбцов массива (4)");
        int b;
        while (true) {
            b = scanner.nextInt();
            try {
                if (b != 4) {
                    throw new MyArraySizeExeption();
                }
                break;
            } catch (MyArraySizeExeption e) {
                System.out.println("Число столбцов должно быть 4. Введите 4");
            }
        }

        scanner.nextLine();


/**
 * Создаем массив, заполняем
 */

        System.out.println("Заполните массив");

        String[][] arrayOfStrings = new String[a][b];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arrayOfStrings[i][j] = scanner.nextLine();
            }
        }

        System.out.println("");
/**
 * Выводим массив
 */
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(arrayOfStrings[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("");


        int count = 0;
        String errorInCells = "";

        for (int i = 0; i < arrayOfStrings.length; i++) {
            for (int j = 0; j < arrayOfStrings[i].length; j++) {
                try {
                    /**
                     * Преобразуем элементы массива в int, суммируем значения
                     */
                    count += Integer.parseInt(arrayOfStrings[i][j]);
                } catch (NumberFormatException e) {
                    errorInCells += "Ошибка в ячейке [" + i + "][" + j + "]\n";
                }
            }
        }

        /**
         * Выводим сумму чисел в массиве
         */
        System.out.println("Сумма чисел в массиве: " + count);

        /**
         * Выводим некорректные данные в ячейках
         */
        if (!errorInCells.isEmpty()) {
            throw new MyArrayDataExeption("Некорректные данные в ячейках:" + errorInCells);
        }
    }
}


