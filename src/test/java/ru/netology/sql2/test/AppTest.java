package ru.netology.sql2.test;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.Should;
import com.codeborne.selenide.commands.ShouldBe;
import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import ru.netology.sql2.data.DataHelper;
import ru.netology.sql2.data.DataToBase;
import ru.netology.sql2.page.LoginPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class AppTest {

    @BeforeEach
    public void shouldLogin() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");


    }

    @AfterEach
    public void shouldDelCode() {
        DataToBase data = new DataToBase();
        data.del();

    }


    @Test
    public void shouldTestCorrectVerification() {
        DataToBase data = new DataToBase();
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = data.setCode(data.setUp());
        verificationPage.validVerify(verificationCode);

    }

    @Test
    public void shouldTestIncorrectPassword() {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        loginPage.invalidPass(authInfo);


    }
   // @Test
    //public void shouldTestIncorrectPassword3() {
        //var loginPage = new LoginPage();
       // var authInfo = DataHelper.getAuthInfo();
       // loginPage.invalidPass2(authInfo);





}
