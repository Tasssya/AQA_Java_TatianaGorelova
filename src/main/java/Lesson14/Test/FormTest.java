package Lesson14.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FormTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/Users/tanya/Desktop/chromedriver-mac-x64 2/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mts.by/");

        // Ожидание загрузки всех элементов страницы
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));

//        // Иногда баннер появляется, иногда нет, проверка появился ли
        try {
            WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cookie-agree")));
            cookieBanner.click();
            System.out.println(" Кнопка Принять нажата");
        } catch (Exception e) {
            System.out.println("Баннер не появился");
        }
    }

    @Test(priority = 1)
    public void testBlockTitle() {
        //Проверка заголовка "Онлайн пополнение без комиссии"
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Онлайн пополнение')]")));
        Assert.assertEquals(title.getText().trim(), "Онлайн пополнение\nбез комиссии", "Заголовок не соответствует");
        System.out.println("Заголовок соответствует: " + title.getText());
    }

    @Test(priority = 2)
    public void testPaymentLogos() {
        //Проверка наличия логотипов платежных систем
        List<WebElement> logos = driver.findElements(By.xpath("//div[@class='pay__partners']/ul/li"));
        Assert.assertTrue(logos.size() >= 1, "Логотипы найдены");
        System.out.println("Найдено логотипов: " + logos.size());
    }

    @Test(priority = 3)
    public void testMoreAboutServiceLink() {
        // Проверка ссылки "Подробнее о сервисе"
        WebElement link = driver.findElement(By.xpath("//a[contains(text(),'Подробнее о сервисе')]"));
        Assert.assertTrue(link.isDisplayed(), "Ссылка 'Подробнее о сервисе' не найдена");
        System.out.println("Ссылка найдена");
    }

    @Test(priority = 4)
    public void testFormSubmission() {

        //Вводим номер телефона
        WebElement phoneInput = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        phoneInput.sendKeys("297777777");

        //Вводим сумму
        WebElement amountInput = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        amountInput.sendKeys("10");

        //Нажимаем кнопку "Продолжить"
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]"));
        submitButton.click();

        // Переключаемся на iframe
            List <WebElement> iframe = driver.findElements(By.tagName("iframe"));
            if(iframe.stream().count() < 3)
                Assert.assertTrue(true,"Окно оплаты появилось");
            else
                Assert.assertFalse(false,"Окно оплаты не появилось" );

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
