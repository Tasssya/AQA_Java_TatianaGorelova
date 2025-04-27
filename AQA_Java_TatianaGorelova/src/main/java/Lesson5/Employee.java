package Lesson5;

/**
 * Класс Employee представляет сотрудника и указывает возможные поля: имя фамилия, должность, email, номер телефона, зарплату, возраст
 */
public class Employee {
    private String nameSurname;
    private String jobTitle;
    private String email;
    private int phone;
    private int salary;
    private int age;

    /**
     * Пустой конструктор, чтобы вызвать код из класса main
     */
    public Employee() {
    }


    /**
     * Конструктор для создания объекта Сотрудник
     *
     * @param nameSurname имя фамилия
     * @param jobTitle    должность
     * @param email       email
     * @param phone       номер телефона
     * @param salary      зарплата
     * @param age         возраст
     */
    public Employee(String nameSurname, String jobTitle, String email, int phone, int salary, int age) {
        this.nameSurname = nameSurname;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    /**
     * Метод, который выводит данные о сотруднике в консоль
     */
    public void printInfo() {
        System.out.println("Name: " + this.nameSurname);
        System.out.println("Job Title: " + this.jobTitle);
        System.out.println("Email: " + this.email);
        System.out.println("Phone: " + this.phone);
        System.out.println("Salary: " + this.salary);
        System.out.println("Age: " + this.age);
        System.out.println("");

    }

    /**
     * Метод, который создает массив из 5 сотрудников с указанными данными о каждом
     */
    public void info() {
        Employee[] fiveEmployees = new Employee[5];
        fiveEmployees[0] = new Employee("Ivanov Ivan Ivanovich", "Java Developer", "email@email.com", 2509876, 2500, 32);
        fiveEmployees[1] = new Employee("Sidorov Alexey Viktorovich", "Backend Developer", "alexey.sidorov@email.com", 9876543, 3500, 30);
        fiveEmployees[2] = new Employee("Kuznetsova Anna Sergeevna", "QA Engineer", "anna.kuznetsova@email.com", 5647382, 2800, 25);
        fiveEmployees[3] = new Employee("Smirnov Dmitry Ivanovich", "DevOps Engineer", "dmitry.smirnov@email.com", 6758493, 4000, 34);
        fiveEmployees[4] = new Employee("Volkova Ekaterina Pavlovna", "Product Manager", "ekaterina.volkova@email.com", 8745632, 5000, 29);

        /**
         * Вывод информации о каждом сотруднике из массива в консоль
         */
        for (int i = 0; i < 5; i++) {
            fiveEmployees[i].printInfo();
        }
    }
}



