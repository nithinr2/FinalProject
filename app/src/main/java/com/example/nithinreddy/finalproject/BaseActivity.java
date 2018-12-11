package com.example.nithinreddy.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BaseActivity extends AppCompatActivity {
    private TextView nameOneTxt; private TextView nameTwoTxt; private TextView nameThreeTxt;
    private TextView usernameOneTxt;
    private TextView genderOneTxt;
    private TextView phoneOneTxt;
    private User userOne;
    private Button openMainBttn;

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

        openMainBttn = findViewById(R.id.openMainBttn);
        openMainBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
    }

    private void findMatches() {
        int currentUserIndex = User.getCurrentUserIndex(User.currentUser);
        double currentUserScore = User.users.get(currentUserIndex).calculateScore();
        User bestMatch = User.users.get(0);
        System.out.println("user name: " + User.users.get(currentUserIndex).getName());
        System.out.println("user index: " + currentUserIndex);
        System.out.println("current user score: " + currentUserScore);
        if (currentUserIndex == 0) {
            bestMatch = User.users.get(1);
        }
        double difference = 6;
        for (int i = 0; i < User.users.size(); i++) {
            double currentScore = User.users.get(i).calculateScore();
            if (i == currentUserIndex) {
                continue;
            }
            if (Math.abs(currentScore - currentUserScore) < difference) {
                bestMatch = User.users.get(i);
                difference = Math.abs(currentUserScore - bestMatch.calculateScore());
            }
        }
        userOne = bestMatch;
    }

    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}