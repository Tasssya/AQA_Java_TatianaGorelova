package Lesson6;

import java.util.Scanner;

/**
 * Класс Dog наследуемый от класса Animal
 */
public class Dog extends Animal {
    private int swimMax = 10;
    private int runMax = 500;

    Scanner scanner = new Scanner(System.in);

    /**
     * Конструктор класса dog
     */
    public Dog(String name) {
        super(name);
    }

    public void swim(int swimDistance) {
        super.swimmed = swimDistance;
        if (swimDistance <= swimMax)
            System.out.println("Длина дистанции для плавания: " + swimDistance);
        else {
            boolean isContinue = true;
            while (isContinue) {
                System.out.println("Собака не может столько проплыть");
                System.out.println("Введите расстояние до 10ь");
                swimDistance = scanner.nextInt();
                if (swimDistance <= swimMax) {
                    System.out.println("Длина дистанции для плаванья: " + swimDistance);
                    isContinue = false;
                }
            }
        }
    }

    public void run(int runDistance) {
        super.runned = runDistance;
        if (runDistance <= this.runMax)
            System.out.println("Длина дистанции для бега: " + runDistance);
        else {
            boolean isContinue = true;
            while (isContinue) {
                System.out.println("Собака не может столько пробежать");
                System.out.println("Введите расстояние до 500м");
                runDistance = scanner.nextInt();
                if (runDistance <= runMax) {
                    System.out.println("Длина дистанции для бега: " + runDistance);
                    isContinue = false;
                }
            }
        }
    }

    public int getRunnedDistance() {
        return runned;
    }
}
