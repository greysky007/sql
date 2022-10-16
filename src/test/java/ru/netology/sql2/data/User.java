package ru.netology.sql2.data;

import lombok.Value;

@Value
public class User {
    private String user;

    public  static User getLog(){

        return new User("vasya");
        
    }
}
