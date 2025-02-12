package Lesson12;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Юнит-тесты для проверки метода factorial с использованием TestNG.
 */
public class FactorialTestNG {

    @Test
    public void testFactorialOfZero() {
        assertEquals(Factorial.factorial(0), 1, "Факториал числа 0 должен быть равен 1");
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(Factorial.factorial(1), 1, "Факториал числа 1 должен быть равен 1");
    }

    @Test
    public void testFactorialOfPositiveNumbers() {
        assertEquals(Factorial.factorial(5), 120, "Факториал числа 5 должен быть равен 120");
        assertEquals(Factorial.factorial(7), 5040, "Факториал числа 7 должен быть равен 5040");
    }

    @Test
    public void testFactorialOfLargeNumber() {
        assertEquals(Factorial.factorial(10), 3628800, "Факториал числа 10 должен быть равен 3628800");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        Factorial.factorial(-5);
    }
}
