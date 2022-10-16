package ru.netology.sql2.data;

import lombok.SneakyThrows;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import ru.netology.sql2.data.User;

import java.sql.DriverManager;

public class DataToBase {
    private String code;

    public String getCode() {
        return code;
    }

    public String setCode(String code) {
        this.code = code;
        return code;
    }

    @SneakyThrows
    public String setUp() {
        var runner = new QueryRunner();
                String select = "select code FROM users JOIN auth_codes on users.id = user_id WHERE login = '" + User.getLog().getUser() + "';";

        try (
                var conn = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/app-db", "app-line", "12345");

        ) {

            String count = runner.query(conn, select, new ScalarHandler<>());



            return count;

        }
    }

    @SneakyThrows
    public void del() {
        var runner = new QueryRunner();
        String delete = "DELETE from auth_codes;";
        try (
                var conn = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/app-db", "app-line", "12345");

        ) {
            runner.update(conn, delete);


        }
    }
}
