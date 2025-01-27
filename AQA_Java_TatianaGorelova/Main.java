package Lesson6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dogCount = 0;
        int catCount = 0;


        System.out.print("Введите количество животных: ");
        int numberOfAnimals = scanner.nextInt();
        scanner.nextLine();

/**
 * Массив для хранения животныз
 */
        Animal[] animals = new Animal[numberOfAnimals];

/**
 * Вводим данные о животных
 */
        for (int i = 0; i < numberOfAnimals; i++) {
            System.out.print("Введите тип животного (dog/cat): ");
            String animalType = scanner.nextLine();

            System.out.print("Введите имя животного: ");
            String animalName = scanner.nextLine();


            /**
             * Создаем обьект животного, добавляю в массив, добавляем параметры для него
             */
            if (animalType.equals("dog")) {
                animals[i] = new Dog(animalName);
                dogCount++;
                System.out.print("Введите длину препятствия для плаванья: ");
                int swimBarrier = scanner.nextInt();
                scanner.nextLine();
                ((Dog) animals[i]).swim(swimBarrier);
                System.out.print("Введите длину препятствия для бега: ");
                int runBarrier = scanner.nextInt();
                scanner.nextLine();
                ((Dog) animals[i]).run(runBarrier);

            } else if (animalType.equals("cat")) {
                animals[i] = new Cat(animalName);
                catCount++;
                System.out.print("Введите длину препятствия для бега: ");
                int runBarrier = scanner.nextInt();
                scanner.nextLine();
                ((Cat) animals[i]).run(runBarrier);


            } else {
                System.out.println("Неверный тип животного! Напишите имя животного, соблюдая регистр: cat или dog.");
                i--;
            }
        }


        arrayInfo(dogCount, catCount);
        printAnimalInfo(animals);
        figures();
    }

    /**
     * Метод выводит сколько всего котов, собак и животных создано
     */

    public static void arrayInfo(int dog, int cat) {
        System.out.println("");
        System.out.println("Всего животных: " + (dog + cat));
        System.out.println("Всего собак: " + dog);
        System.out.println("Всего котов: " + cat);
        System.out.println("");
    }

    /**
     * Метод выводит сколько пробежало/проплыло каждое животное
     */
    public static void printAnimalInfo(Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            System.out.println("");
            System.out.println(animals[i].getName() + " пробежал " + animals[i].runned);
            System.out.println(animals[i].getName() + " проплыл " + animals[i].swimmed);
        }
    }

    public static void figures() {
        Figure circle = new Circle(3);
        Figure rectangle = new Rectangle(1, 2);
        Figure triangle = new Triangle(1, 2, 3);

        System.out.println("Круг:");
        circle.showProperties("Синий", "Зеленый");
        System.out.println("Периметр: " + circle.calculatePerimeter());
        System.out.println("Площадь: " + circle.calculateArea());

        System.out.println("\nПрямоугольник:");
        rectangle.showProperties("Синий", "Зелёный");
        System.out.println("Периметр: " + rectangle.calculatePerimeter());
        System.out.println("Площадь: " + rectangle.calculateArea());

        System.out.println("\nТреугольник:");
        triangle.showProperties("Синий", "Зеленый");
        System.out.println("Периметр: " + triangle.calculatePerimeter());
        System.out.println("Площадь: " + triangle.calculateArea());
    }

}
