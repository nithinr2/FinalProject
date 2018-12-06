package com.example.nithinreddy.finalproject;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String name;
    private String phone;
    private String gender;
    private int[] answers = new int[10];
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

    public static User getUser(String findUserName) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(findUserName)) {
                return users.get(i);
            }
        }
        return null;
    }
    public int calculateScore() {
        int score = 0;
        for (int i = 0; i < answers.length; i++) {
            score += answers[i];
        }
        score /= 10;
        return score;
    }

    public void setQuestionOne(int setOne) { answers[0] = setOne; }
    public void setQuestionTwo(int setTwo) { answers[1] = setTwo; }
    public void setQuestionThree(int setThree) { answers[2] = setThree; }
    public void setQuestionFour(int setFour) { answers[3] = setFour; }
    public void setQuestionFive(int setFive) { answers[4] = setFive; }
    public void setQuestionSix(int setSix) { answers[5] = setSix; }
    public void setQuestionSeven(int setSeven) { answers[6] = setSeven; }
    public void setQuestionEight(int setEight) { answers[7] = setEight; }
    public void setQuestionNine(int setNine) { answers[8] = setNine; }
    public void setQuestionTen(int setTen) { answers[9] = setTen; }
}
