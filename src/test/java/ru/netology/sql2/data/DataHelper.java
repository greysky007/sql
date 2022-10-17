package ru.netology.sql2.data;

import com.github.javafaker.Faker;
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

        return new AuthInfo(getLog().getUser(), "qwerty123");
    }

    public static User getLog() {

        return new User("vasya");


    }

    public static String invalidPass() {
        Faker faker = new Faker();
        String pass = faker.internet().password();
        return pass;
    }


}
