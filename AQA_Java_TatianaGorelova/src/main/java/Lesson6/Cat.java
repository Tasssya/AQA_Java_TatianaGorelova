package Lesson6;

import java.util.Scanner;

/**
 * Класс Cat, наследуемый от Animal
 */
public class Cat extends Animal {
    private int runMax = 200;
    Scanner scanner = new Scanner(System.in);

    /**
     * конструктор класса Cat
     */
    public Cat(String name) {
        super(name);
    }

    /**
     * Создаем метод run
     */
    public void run(int runDistance) {
        super.runned = runDistance;
        if (runDistance <= this.runMax)
            System.out.println("Длина дистанции для бега: " + runDistance);
        else {
            boolean isContinue = true;
            while (isContinue) {
                System.out.println("Кот не может столько пробежать");
                System.out.println("Введите расстояние до 200м");
                runDistance = scanner.nextInt();
                if (runDistance <= runMax) {
                    System.out.println("Длина дистанции для бега: " + runDistance);
                    isContinue = false;
                }
            }
        }
    }
}
