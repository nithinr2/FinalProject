package com.example.nithinreddy.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QuestionTwoActivity extends AppCompatActivity {
    private Button nextBttn;
    private RadioGroup radioGrp;
    private RadioButton selectedAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two);

        radioGrp = findViewById(R.id.radioGrp);

        nextBttn = findViewById(R.id.nextBttn);
        nextBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    if (selectedAnswer.getText().toString().equals("Almost all")) {
                        User.users.get(0).setQuestionTwo(1);
                    } else if (selectedAnswer.getText().toString().equals("Majority")) {
                        User.users.get(0).setQuestionTwo(2);
                    } else if (selectedAnswer.getText().toString().equals("About half")) {
                        User.users.get(0).setQuestionTwo(3);
                    } else if (selectedAnswer.getText().toString().equals("Some")) {
                        User.users.get(0).setQuestionTwo(4);
                    } else {
                        User.users.get(0).setQuestionTwo(5);
                    }
                    openQuestionThreeActivity();
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

    public void openQuestionThreeActivity() {
        Intent intent = new Intent(this, QuestionThreeActivity.class);
        startActivity(intent);
    }
}
