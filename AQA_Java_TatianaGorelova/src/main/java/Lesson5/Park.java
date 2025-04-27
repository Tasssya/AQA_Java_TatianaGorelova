package Lesson5;

/**
 * Класс Park представляет парк и его возможные поля: время работы парка, расположение парка
 */
public class Park {
    public String parkWorkingHours;
    public String parkLocation;

    /**
     * Внутренний класс Attractions представляет атракцион и его возможные поля: название атракциона, время работы атракциона, цена атракциона
     */
    public class Attractions {
    private String attractionName;
    private String attractionWorkingHours;
    private String attractionPrice;

    /**
     * Конструктор для создания объекта Атракцион
     * @param attractionName название атракциона
     * @param attractionWorkingHours время работы атракциона
     * @param attractionPrice цена атракциона
     */
    public Attractions(String attractionName, String attractionWorkingHours, String attractionPrice)
    {
        this.attractionName = attractionName;
        this.attractionWorkingHours = attractionWorkingHours;
        this.attractionPrice = attractionPrice;
    }

        /**
         * Метод, выводящий в консоль данные о атракционе
         */
    public void showInfo() {
        System.out.println("Attraction Name: " + this.attractionName);
        System.out.println("Working Hours: " + this.attractionWorkingHours);
        System.out.println("Price: " + this.attractionPrice);
        System.out.println("");
    }
}

    /**
     * Метод, который создает обьекты атракционов
     */
    public void createAttractions (){
    Attractions attraction1 = new Attractions("Ferris Wheel","9 am - 7 pm", "20 UDS" );
    Attractions attraction2 = new Attractions("Haunted House", "10 am - 6 pm", "10 USD");

    /**
     * Вывод информации о каждом атракционе
     */
        attraction1.showInfo();
        attraction2.showInfo();
}
}

