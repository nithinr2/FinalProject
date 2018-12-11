package com.example.nithinreddy.finalproject;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String name;
    private String phone;
    private String gender;
    private double score;
    private int[] answers = new int[9];
    public static ArrayList<User> users = new ArrayList<>();
    //fix below
    public static int currentUserIndex;

    public User(String setUsername, String setPassword) {
        username = setUsername;
        password = setPassword;
    }

    public User() {

    }

    public void addUsers() {
        User user1 = new User("dogluver", "12354");
        user1.setName("Philip Zappa");
        user1.setPhone("(312) 793 - 8211");
        user1.setGender("Male");
        user1.answers = new int[]{1, 1, 1, 1, 1, 2, 2, 2, 2};
        users.add(0, user1);

        User user2 = new User("iLuvDog", "12354");
        user2.setName("Krystina Power");
        user2.setPhone("(904) 337 - 1586");
        user2.setGender("Female");
        user2.answers = new int[]{5, 5, 5, 5, 5, 4, 4, 4, 4};
        users.add(0, user2);

        User user3 = new User("dogsRGud", "12354");
        user3.setName("Odran Barone");
        user3.setPhone("(515) 462 - 9391");
        user3.setGender("Gender Fluid");
        user3.answers = new int[]{3, 3, 3, 3, 3, 2, 4, 2, 4};
        users.add(0, user3);

        User user4 = new User("corgiLuver23", "12354");
        user4.setName("Freek Pauwels");
        user4.setPhone("(208) 794 - 8813");
        user4.setGender("Male");
        user4.answers = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 4};
        users.add(0, user4);

        User user5 = new User("retrieverRetriever", "12354");
        user5.setName("Amarjeet Chaudhari");
        user5.setPhone("(408) 805 - 2492");
        user5.setGender("Female");
        user5.answers = new int[]{4, 4, 4, 4, 4, 4, 4, 2, 4};
        users.add(0, user5);
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
    public double calculateScore() {
        double score = 0;
        for (int i = 0; i < answers.length; i++) {
            score += answers[i];
        }
        score /= 9;
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
}
