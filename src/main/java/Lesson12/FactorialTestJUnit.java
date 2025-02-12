package Lesson12;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FactorialTestJUnit {
    @Test
    void testFactorialOfZero() {
        assertEquals(1, Factorial.factorial(0), "Факториал числа 0 должен быть равен 1");
    }

    @Test
    void testFactorialOfOne() {
        assertEquals(1, Factorial.factorial(1), "Факториал числа 1 должен быть равен 1");
    }

    @Test
    void testFactorialOfPositiveNumber() {
        assertEquals(120, Factorial.factorial(5), "Факториал числа 5 должен быть равен 120");
        assertEquals(3628800, Factorial.factorial(10), "Факториал числа 10 должен быть равен 3628800");
    }

    @Test
    void testFactorialOfLargeNumber() {
        assertEquals(2432902008176640000L, Factorial.factorial(20), "Факториал числа 20 должен быть равен 2432902008176640000");
    }

    @Test
    void testFactorialOfNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Factorial.factorial(-5);
        });
        assertEquals("Факториал не может быть отрицательным", exception.getMessage());
    }
}

