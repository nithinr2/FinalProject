package com.example.nithinreddy.finalproject;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String name;
    private String phone;
    private String gender;
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
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public String getGender() {
        return gender;
    }
    public void setPassword(String setPassword) {
        password = setPassword;
    }
    public void setUsername(String setUsername) {
        username = setUsername;
    }
    public void setName(String setName) {
        name = setName;
    }
    public void setPhone(String setPhone) {
        phone = setPhone;
    }
    public void setGender(String setGender) {
        gender = setGender;
    }
}
