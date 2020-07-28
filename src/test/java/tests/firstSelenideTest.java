package tests;

import org.testng.annotations.Test;
import pages.baseTestClass;

import static helpers.testData.*;
import static pages.pageForFirstSelenideTest.*;

public class firstSelenideTest extends baseTestClass {
    @Test(description = "Тест на корректную авторизацию", priority = 0)
    public void testValidLoginAndPassword() {
        openLoginPage();
        inputData(userNameField, username);
        inputData(passwordField, password);
        clickButton(loginButton);
        messageForUser(subHeader, loginText); // Успешная авторизация
    }
    @Test(description = "Тест некорректного логина", priority = 1)
    public void testInvalidLogin() {
        openLoginPage();
        inputData(userNameField, invalid);
        inputData(passwordField, password);
        clickButton(loginButton);
        messageForUser(flash, alertUserNameText); // Проверка ошибки ввода логина
    }
    @Test(description = "Тест некорректного пароля", priority = 1)
    public void testInvalidPassword() {
        openLoginPage();
        inputData(userNameField, username);
        inputData(passwordField, invalid);
        clickButton(loginButton);
        messageForUser(flash, alertPasswordText); // Проверка ошибки ввода пароля
    }
}
