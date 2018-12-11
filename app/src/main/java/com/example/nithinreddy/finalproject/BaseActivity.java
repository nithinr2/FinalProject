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
    private String hello;

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


        CharSequence secondMatch = (CharSequence) userTwo.getName();
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
        phoneThreeTxt.setText(thirdPhone);

    }

    private void findMatches() {
        double currentUserScore = User.users.get(User.currentUserIndex).calculateScore();
        int counter = 0;
        for (int i = 0; i < User.users.size(); i++) {
            if (Math.abs(User.users.get(i).calculateScore() - currentUserScore) <= 0.5) {
                if (counter == 1) {
                    userOne = User.users.get(i);
                } else if (counter == 2) {
                    userTwo = User.users.get(i);
                } else {
                    userThree = User.users.get(i);
                    break;
                }
                counter++;
            }
        }
    }
}
