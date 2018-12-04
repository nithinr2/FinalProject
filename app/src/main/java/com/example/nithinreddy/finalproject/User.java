package com.example.nithinreddy.finalproject;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    public static ArrayList<User> users = new ArrayList<>();

    public User(String setUsername, String setPassword) {
        username = setUsername;
        password = setPassword;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String setPassword) {
        password = setPassword;
    }
    public void setUsername(String setUsername) {
        username = setUsername;
    }
}
