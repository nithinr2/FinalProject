package com.example.nithinreddy.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QuestionOneActivity extends AppCompatActivity {
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
                    if (selectedAnswer.getText().toString().equals("Not very")) {
                        User.users.get(User.currentUserIndex).setQuestionOne(1);
                    } else if (selectedAnswer.getText().toString().equals("Somewhat")) {
                        User.users.get(User.currentUserIndex).setQuestionOne(2);
                    } else if (selectedAnswer.getText().toString().equals("The same as everyone else")) {
                        User.users.get(User.currentUserIndex).setQuestionOne(3);
                    } else if (selectedAnswer.getText().toString().equals("Very")) {
                        User.users.get(User.currentUserIndex).setQuestionOne(4);
                    } else {
                        User.users.get(User.currentUserIndex).setQuestionOne(5);
                    }
                    openQuestionTwoActivity();
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

    public void openQuestionTwoActivity() {
        Intent intent = new Intent(this, QuestionTwoActivity.class);
        startActivity(intent);
    }
}
