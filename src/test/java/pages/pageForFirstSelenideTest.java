package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.testData.url;

public class pageForFirstSelenideTest {
    public static SelenideElement userNameField = $(By.id("username"));
    public static SelenideElement passwordField = $(By.id("password"));
    public static SelenideElement loginButton = $(By.className("radius"));
    public static SelenideElement subHeader = $(By.className("subheader"));
    public static SelenideElement flash = $(By.className("flash"));

    @Step("Открытие главной страницы")
    public static void openLoginPage() {
        open(url);
    }

    @Step("Проверка сообшения об успешной авторизации")
    public static void messageForUser(SelenideElement element, String text) {
        element.shouldHave(Condition.text(text));
    }
}
