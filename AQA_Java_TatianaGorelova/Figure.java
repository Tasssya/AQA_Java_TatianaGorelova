package Lesson6;

public interface Figure {
    double calculatePerimeter();
    double calculateArea();

    default void showProperties(String fillColor, String borderColor){
        System.out.println("Цвет заливки: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
    }
}