package com.example.nithinreddy.finalproject;

public class User {
    private String username;
    private String password;

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
