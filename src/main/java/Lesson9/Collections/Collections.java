package Lesson9.Collections;

import java.util.ArrayList;

public class Collections {
    public static void main(String[] args) {
        /**
         * Создаем массив из животных, заполняем значениями
         */
        ArrayList<String> animals = new ArrayList<>();
        animals.add("dog");
        animals.add("cat");
        animals.add("hamster");
        animals.add("hippo");
        animals.add("giraffe");
        animals.add("hamster");
        animals.add("lion");
        animals.add("dog");
        animals.add("hamster");
        animals.add("tiger");
        animals.add("wolf");
        animals.add("hippo");
        animals.add("fox");
        animals.add("rabbit");
        animals.add("rabbit");
        animals.add("hamster");
        /**
         * Выводим массив из животных и его размер
         */
        System.out.println("Массив из животных: " + animals);
        System.out.println("Всего добавлено животных: " + animals.size());
        System.out.println("");
        /**
         * Создаем новую коллекцию, которая не будет содержать дублей
         */
        ArrayList<String> unique = new ArrayList<>();

        /**
         * Добавляем в коллекцию значения без дублей
         */

        for (String animal : animals) {
            if (!unique.contains(animal)) {
                unique.add(animal);
            }
        }
        System.out.println("Животные без повторений: " + unique);
        System.out.println("Всего животных без повторений: " + unique.size());
        System.out.println("");

        /**
         * Считаем сколько раз животное повторяется
         */

        for (String uni : unique) {
            int counter = 0;
            for (String animal : animals) {
                if (animal.equals(uni)) {
                    counter++;
                }
            }

            if (counter == 1) {
                System.out.println(uni + " повторяется " + counter + " раз");

            } else
                System.out.println(uni + " повторяется " + counter + " раза");

        }
    }
}
