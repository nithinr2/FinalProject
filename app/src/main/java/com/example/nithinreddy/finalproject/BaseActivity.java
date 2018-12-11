package com.example.nithinreddy.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BaseActivity extends AppCompatActivity {
    private TextView nameOneTxt; private TextView nameTwoTxt; private TextView nameThreeTxt;
    private TextView usernameOneTxt; private TextView usernameTwoTxt; private TextView usernameThreeTxt;
    private TextView genderOneTxt; private TextView genderTwoTxt;
    private TextView genderThreeTxt; private TextView phoneOneTxt;
    private TextView phoneTwoTxt; private TextView phoneThreeTxt;
    private User userOne; private User userTwo; private User userThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        findMatches();

        CharSequence firstMatch = (CharSequence) userOne.getName();
        nameOneTxt = findViewById(R.id.nameOneTxt);
        nameOneTxt.setText(firstMatch);

        CharSequence firstUsername = (CharSequence) userOne.getUsername();
        usernameOneTxt = findViewById(R.id.usernameOneTxt);
        usernameOneTxt.setText(firstUsername);

        CharSequence firstGender = (CharSequence) userOne.getGender();
        genderOneTxt = findViewById(R.id.genderOneTxt);
        genderOneTxt.setText(firstGender);

        CharSequence firstPhone = (CharSequence) userOne.getPhone();
        phoneOneTxt = findViewById(R.id.phoneOneTxt);
        phoneOneTxt.setText(firstPhone);


        /*CharSequence secondMatch = (CharSequence) userTwo.getName();
        nameTwoTxt = findViewById(R.id.nameTwoTxt);
        nameTwoTxt.setText(secondMatch);

        CharSequence secondUsername = (CharSequence) userTwo.getUsername();
        usernameTwoTxt = findViewById(R.id.usernameTwoTxt);
        usernameTwoTxt.setText(secondUsername);

        CharSequence secondGender = (CharSequence) userTwo.getGender();
        genderTwoTxt = findViewById(R.id.genderTwoTxt);
        genderTwoTxt.setText(secondGender);

        CharSequence secondPhone = (CharSequence) userTwo.getPhone();
        phoneTwoTxt = findViewById(R.id.phoneTwoTxt);
        phoneThreeTxt.setText(secondPhone);


        CharSequence thirdMatch = (CharSequence) userThree.getName();
        nameThreeTxt = findViewById(R.id.nameThreeTxt);
        nameThreeTxt.setText(thirdMatch);

        CharSequence thirdUsername = (CharSequence) userThree.getUsername();
        usernameThreeTxt = findViewById(R.id.usernameThreeTxt);
        usernameThreeTxt.setText(thirdUsername);

        CharSequence thirdGender = (CharSequence) userThree.getGender();
        genderThreeTxt = findViewById(R.id.genderThreeTxt);
        genderThreeTxt.setText(thirdGender);

        CharSequence thirdPhone = (CharSequence) userThree.getPhone();
        phoneThreeTxt = findViewById(R.id.phoneThreeTxt);
        phoneThreeTxt.setText(thirdPhone);*/

    }


    private void findMatches() {
        double currentUserScore = User.currentUserIndex;
        User bestMatch = User.users.get(0);
        System.out.println("user name: " + User.users.get(User.currentUserIndex).getName());
        System.out.println("user index: " + User.currentUserIndex);
        System.out.println("current user score: " + currentUserScore);
        if (User.currentUserIndex == 0) {
            bestMatch = User.users.get(1);
        }
        double difference = 6;
        for (int i = 0; i < User.users.size(); i++) {
            double currentScore = User.users.get(i).calculateScore();
            if (i == User.currentUserIndex) {
                continue;
            }
            if (Math.abs(currentScore - currentUserScore) < difference) {
                bestMatch = User.users.get(i);
                difference = Math.abs(currentUserScore - bestMatch.calculateScore());
            }
        }
        userOne = bestMatch;
    }
}