package Lesson15.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    // ✅ Используем @FindBy для инициализации элементов

    @FindBy(tagName = "iframe")
    public List<WebElement> iframe;

    @FindBy(id = "cookie-agree")
    public WebElement cookieBanner;

    @FindBy(xpath = "//h2[contains(text(), 'Онлайн пополнение')]")
    public WebElement title;

    @FindBy(xpath = "//div[@class='pay__partners']/ul/li")
    public List<WebElement> logos;

    @FindBy(xpath = "//a[contains(text(),'Подробнее о сервисе')]")
    public WebElement link;

    @FindBy(xpath = "//input[@placeholder='Сумма']")
    public WebElement amountInput;

    @FindBy(xpath = "//button[contains(text(),'Продолжить')]")
    public WebElement submitButton;

    @FindBy(xpath = "//input[@placeholder='Номер телефона']")
    public WebElement phoneInput;

    // ✅ Конструктор HomePage
    public HomePage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver не может быть null");
        }
        this.driver = driver;
        PageFactory.initElements(driver, this); // Инициализация элементов через PageFactory
    }

    // ✅ Методы для действий на странице
    public void acceptCookies() {
        try {
            cookieBanner.click();
            System.out.println("Кнопка 'Принять' нажата");
        } catch (Exception e) {
            System.out.println("Баннер не появился");
        }
    }

    public void fillPhoneNumber(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void fillAmount(String amount) {
        amountInput.sendKeys(amount);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public long getIframeCount() {
        return iframe.size();
    }

    public boolean isServiceLinkDisplayed() {
        return link.isDisplayed();
    }

    public int getLogosCount() {
        return logos.size();
    }

    public String getTitleText() {
        return title.getText().trim();
    }
}
