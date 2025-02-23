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

public class FormTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/tanya/Desktop/chromedriver-mac-x64 2/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.get("https://www.mts.by/");
        driver.manage().window().maximize();
    }

    @Test
    public void testBlockTitle() {
        handleCookieBanner();

        // Проверка наличия заголовка (исправлен на h2)
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'Онлайн пополнение')]")
        ));
        Assert.assertTrue(blockTitle.isDisplayed(), "❌ Блок с заголовком не найден");
        System.out.println("✅ Заголовок найден: " + blockTitle.getText());
    }

    @Test
    public void testPaymentLogos() {
        handleCookieBanner();

        // Проверка наличия логотипов платежных систем
        String[] logos = {"VISA", "Verified by VISA", "MasterCard SecureCode", "БЕЛКАРТ"};

        for (String logo : logos) {
            WebElement logoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//img[contains(@alt,'" + logo + "')]")
            ));
            Assert.assertTrue(logoElement.isDisplayed(), "❌ Логотип " + logo + " не найден");
            System.out.println("✅ Логотип найден: " + logo);
        }
    }

    @Test
    public void testMoreAboutServiceLink() {
        handleCookieBanner();

        // Проверка ссылки "Подробнее о сервисе"
        WebElement moreAboutServiceLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'Подробнее о сервисе')]")
        ));
        Assert.assertTrue(moreAboutServiceLink.isDisplayed(), "❌ Ссылка 'Подробнее о сервисе' не найдена");

        moreAboutServiceLink.click();
        wait.until(ExpectedConditions.urlContains("about-service")); // Проверка, что открылась нужная страница
        System.out.println("✅ Ссылка 'Подробнее о сервисе' работает корректно");
    }

    @Test
    public void testFormSubmission() {

        // Проверка заголовка "Онлайн пополнение без комиссии"
        WebElement blockTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение')]"));
        Assert.assertTrue(blockTitle.isDisplayed(), "Block title is not displayed");

        // Клик по дропдауну "Услуги связи"
        WebElement dropdown = driver.findElement(By.cssSelector("button.select__header"));
        dropdown.click();

        // Ввод номера телефона
        WebElement phoneInput = driver.findElement(By.cssSelector("input[type='tel']"));
        phoneInput.sendKeys("297777777");

        // Ввод суммы
        WebElement amountInput = driver.findElement(By.cssSelector("input[placeholder='Сумма']"));
        amountInput.sendKeys("10");

        // Клик по кнопке "Продолжить"
        WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        continueButton.click();

        // Проверка появления модального окна
        WebElement paymentModal = driver.findElement(By.xpath("//div[contains(@class, 'modal')]"));
        Assert.assertTrue(paymentModal.isDisplayed(), "Payment modal did not appear");

        // Закрытие модального окна
        WebElement closeModal = driver.findElement(By.xpath("//button[contains(@class, 'close')]"));
        closeModal.click();
    }


    /**
     * Обработчик баннера с куки
     */
    private void handleCookieBanner() {
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cookie-agree")));
            if (cookieButton.isDisplayed()) {
                cookieButton.click();
                wait.until(ExpectedConditions.invisibilityOf(cookieButton));
                System.out.println("✅ Баннер с куки закрыт");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Баннер с куки не появился");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
