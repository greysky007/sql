package ru.netology.sql2.test;
import com.codeborne.selenide.Configuration;
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
        DataToBase.delAuthCodes();
    }
    @AfterAll
   public static void shouldDelInfo(){
        DataToBase.delInfoFromTables();

   }

    @Test
    public void shouldTestCorrectVerification() {

        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataToBase.setUp();
        verificationPage.validVerify(verificationCode);

    }

    @Test
    public void shouldTestIncorrectPassword() {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        loginPage.invalidPass(authInfo);
    }


    }







