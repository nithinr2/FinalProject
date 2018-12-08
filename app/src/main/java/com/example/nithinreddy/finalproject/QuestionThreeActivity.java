package com.example.nithinreddy.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QuestionThreeActivity extends AppCompatActivity {
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
                    if (selectedAnswer.getText().toString().equals("Staying in and playing video games")) {
                        User.users.get(User.currentUserIndex).setQuestionThree(1);
                    } else if (selectedAnswer.getText().toString().equals("Hanging out with your roomates")) {
                        User.users.get(User.currentUserIndex).setQuestionThree(2);
                    } else if (selectedAnswer.getText().toString().equals("Going out to eat with your friends")) {
                        User.users.get(User.currentUserIndex).setQuestionThree(3);
                    } else if (selectedAnswer.getText().toString().equals("Going out with your wing man/woman")) {
                        User.users.get(User.currentUserIndex).setQuestionThree(4);
                    } else {
                        User.users.get(User.currentUserIndex).setQuestionThree(5);
                    }
                    openQuestionFourActivity();
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

    public void openQuestionFourActivity() {
        Intent intent = new Intent(this, QuestionFourActivity.class);
        startActivity(intent);
    }
}
