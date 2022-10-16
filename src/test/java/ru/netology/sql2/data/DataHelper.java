package ru.netology.sql2.data;
import lombok.SneakyThrows;
import lombok.Value;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {

        return new AuthInfo(User.getLog().getUser(), "qwerty123");
    }

    @Value

    public static class LoginInfo {
        private String login;
    }

    public static LoginInfo getLoginInfo() {

        return new LoginInfo(User.getLog().getUser());
    }


    @Value
    public static class VerificationCode {
        private String code;

    }




}
