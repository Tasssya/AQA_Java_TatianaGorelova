package Lesson6;

import java.util.Scanner;

/**
 * Класс Animal
 */
public class Animal {
    private String name;
    private int runMax;
    public int runned = 0;
    public int swimmed = 0;


    /**
     * Конструктор класса Animal
     */
    public Animal(String name) {
        this.name = name;
    }

    /**
     * Метод,который делает строку name видимой
     */
    public String getName() {
        return name;
    }
}

