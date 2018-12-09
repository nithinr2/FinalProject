package com.example.nithinreddy.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QuestionFourActivity extends AppCompatActivity {
    private Button nextBttn;
    private RadioGroup radioGrp;
    private RadioButton selectedAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_four);

        radioGrp = findViewById(R.id.radioGrp);

        nextBttn = findViewById(R.id.nextBttn);
        nextBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    if (selectedAnswer.getText().toString().equals("Only when I have to")) {
                        User.users.get(User.currentUserIndex).setQuestionFour(1);
                    } else if (selectedAnswer.getText().toString().equals("When there's something to do")) {
                        User.users.get(User.currentUserIndex).setQuestionFour(2);
                    } else if (selectedAnswer.getText().toString().equals("When the weather is nice")) {
                        User.users.get(User.currentUserIndex).setQuestionFour(3);
                    } else if (selectedAnswer.getText().toString().equals("Whenever I'm free")) {
                        User.users.get(User.currentUserIndex).setQuestionFour(4);
                    } else {
                        User.users.get(User.currentUserIndex).setQuestionFour(5);
                    }
                    openQuestionFiveActivity();
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

    public void openQuestionFiveActivity() {
        Intent intent = new Intent(this, QuestionFiveActivity.class);
        startActivity(intent);
    }
}
