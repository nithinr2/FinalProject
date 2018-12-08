package com.example.nithinreddy.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QuestionFiveActivity extends AppCompatActivity {
    private Button nextBttn;
    private RadioGroup radioGrp;
    private RadioButton selectedAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);

        radioGrp = findViewById(R.id.radioGrp);

        nextBttn = findViewById(R.id.nextBttn);
        nextBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    if (selectedAnswer.getText().toString().equals("Never, working out is too much")) {
                        User.users.get(User.currentUserIndex).setQuestionFive(1);
                    } else if (selectedAnswer.getText().toString().equals("I went to the gym two weeks ago")) {
                        User.users.get(User.currentUserIndex).setQuestionFive(2);
                    } else if (selectedAnswer.getText().toString().equals("A couple times a week")) {
                        User.users.get(User.currentUserIndex).setQuestionFive(3);
                    } else if (selectedAnswer.getText().toString().equals("Almost everyday")) {
                        User.users.get(User.currentUserIndex).setQuestionFive(4);
                    } else {
                        User.users.get(User.currentUserIndex).setQuestionFive(5);
                    }
                    openQuestionSixActivity();
                }
            }
        });
    }

    public boolean isValid() {
        int radioBttnId = radioGrp.getCheckedRadioButtonId();
        selectedAnswer = findViewById(radioBttnId);
        if (selectedAnswer == null) {
            return false;
        }
        return true;
    }

    public void openQuestionSixActivity() {
        Intent intent = new Intent(this, QuestionSixActivity.class);
        startActivity(intent);
    }
}
