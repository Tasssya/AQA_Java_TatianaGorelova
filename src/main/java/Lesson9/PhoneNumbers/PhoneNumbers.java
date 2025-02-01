package Lesson9.PhoneNumbers;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneNumbers {
    public static void main(String[] args) {
/**
 * Создаем коллекцию телефонных номеров и фамилий, заполняем коллекцию
 */
        HashMap<Integer, String> phoneBook = new HashMap<>();
        phoneBook.put(1122334455, "Иванов");
        phoneBook.put(1122334456, "Петров");
        phoneBook.put(1122384455, "Сидоров");
        phoneBook.put(1112334455, "Котиков");
        phoneBook.put(1122394455, "Собачков");
        phoneBook.put(1112331455, "Котиков");


        add(phoneBook);
        get(phoneBook);

    }

    /**
     * Создаем метод add, который добавляет номер телефона и фамилию в телефонную книгу
     */
    public static void add(HashMap<Integer, String> phoneBook) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер телефона: ");
        int phone = scanner.nextInt();  // Считываем номер телефона
        scanner.nextLine();

        System.out.print("Введите фамилию: ");
        String surname = scanner.nextLine();

        phoneBook.put(phone, surname);

        System.out.println("Добавлен номер телефона " + phone + " с фамилией " + surname);
    }

    /**
     * Метод выводит номера телефонов для введенной фамилии
     */
    public static void get(HashMap<Integer, String> phoneBook) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию человека, номер которого вы хотите найти");
        String surname = scanner.nextLine();

        boolean surnameExists = false;

        for (HashMap.Entry<Integer, String> entry : phoneBook.entrySet()) {

            if (entry.getValue().equalsIgnoreCase(surname)) {
                System.out.println("Номер телефона: " + entry.getKey());
                surnameExists = true;
            }
        }

        if (!surnameExists) {
            System.out.println("Человек с фамилией " + surname + " не найден в телефонной книге.");
        }
    }
}


