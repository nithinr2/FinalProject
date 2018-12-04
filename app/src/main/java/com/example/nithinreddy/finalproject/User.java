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
    private String getUsername() {
        return username;
    }
    private String getPassword() {
        return password;
    }
    private void setPassword(String setPassword) {
        password = setPassword;
    }
    private void setUsername(String setUsername) {
        username = setUsername;
    }
}
