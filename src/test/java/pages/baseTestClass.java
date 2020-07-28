package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helpers.allureHelper.takeScreenshot;

public class baseTestClass {
    @BeforeMethod
    public static void beforeMethod() {
        Configuration.browser = chromeSettings.class.getName();
        Configuration.startMaximized = true;
        Configuration.reportsFolder = "target/reports";
        Configuration.screenshots = true;

        System.out.println("LocalWebDriver");
    }
    @AfterMethod
    public void afterMethod() {
        takeScreenshot();
        closeWebDriver();
    }
    @Step("Ввод данных")
    public static void inputData(SelenideElement element, String data) {
        element.setValue(data);
    }
    @Step("Нажатие кнопки")
    public static void clickButton(SelenideElement element) {
        element.click();
    }
}