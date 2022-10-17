package ru.netology.sql2.data;

import lombok.SneakyThrows;

import lombok.experimental.UtilityClass;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;

@UtilityClass

public class DataToBase {
    @SneakyThrows
    public static String setUp() {
        var runner = new QueryRunner();
        String select = "select code FROM users JOIN auth_codes on users.id = user_id WHERE login = '" + DataHelper.getLog().getUser() + "';";

        try (
                var conn = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/app-db", "app-line", "12345");

        ) {

            String count = runner.query(conn, select, new ScalarHandler<>());


            return count;

        }
    }

    @SneakyThrows
    public void delAuthCodes() {
        var runner = new QueryRunner();
        String delete = "DELETE from auth_codes;";
        try (
                var conn = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/app-db", "app-line", "12345");

        ) {
            runner.update(conn, delete);


        }
    }

    @SneakyThrows
    public void delInfoFromTables() {
        var runner = new QueryRunner();
        String deleteCodes = "DELETE from auth_codes;";
        String deleteCards = "DELETE from cards;";
        String deleteUsers = "DELETE from users;";
        try (
                var conn = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/app-db", "app-line", "12345");

        ) {
            runner.update(conn, deleteCards);
            runner.update(conn, deleteCodes);
            runner.update(conn, deleteUsers);


        }
    }
}
