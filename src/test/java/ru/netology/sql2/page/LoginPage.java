package ru.netology.sql2.page;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import ru.netology.sql2.data.DataHelper;

import java.util.Locale;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private SelenideElement loginField = $x("//span[@data-test-id='login']//input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $x("//button[@data-test-id='action-login']");
    private SelenideElement error = $x("//div[@data-test-id = 'error-notification']");


    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }

    public void invalidPass(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(DataHelper.invalidPass());
        loginButton.click();
        error.shouldBe(visible);

    }

}

