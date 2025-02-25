package Lesson15.Test;

import Lesson15.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        // ✅ Указываем путь к ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/Users/tanya/Desktop/chromedriver-mac-x64 2/chromedriver");

        // ✅ Инициализация ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mts.by/");

        // ✅ Создаем объект HomePage
        homePage = new HomePage(driver);

        // ✅ Принимаем cookies
        homePage.acceptCookies();
    }

    @Test(priority = 1)
    public void testBlockTitle() {
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        Assert.assertEquals(homePage.getTitleText(), expectedTitle, "Заголовок не соответствует");
        System.out.println("Заголовок соответствует: " + homePage.getTitleText());
    }

    @Test(priority = 2)
    public void testPaymentLogos() {
        int logoCount = homePage.getLogosCount();
        Assert.assertTrue(logoCount >= 1, "Логотипы не найдены");
        System.out.println("Найдено логотипов: " + logoCount);
    }

    @Test(priority = 3)
    public void testMoreAboutServiceLink() {
        Assert.assertTrue(homePage.isServiceLinkDisplayed(), "Ссылка 'Подробнее о сервисе' не найдена");
        System.out.println("Ссылка найдена");
    }

    @Test(priority = 4)
    public void testFormSubmission() throws InterruptedException {
        homePage.fillPhoneNumber("297777777");
        homePage.fillAmount("10");
        homePage.clickSubmit();

        if (homePage.getIframeCount() > 3) {
            Assert.assertTrue(true, "Окно оплаты появилось");
            System.out.println("Окно оплаты появилось");
        } else {
            Assert.fail("Окно оплаты не появилось");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
