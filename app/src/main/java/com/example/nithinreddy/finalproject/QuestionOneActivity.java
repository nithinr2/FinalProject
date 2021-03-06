package com.example.nithinreddy.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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
                        User.users.get(0).setQuestionOne(1);
                    } else if (selectedAnswer.getText().toString().equals("Somewhat")) {
                        User.users.get(0).setQuestionOne(2);
                    } else if (selectedAnswer.getText().toString().equals("The same as everyone else")) {
                        User.users.get(0).setQuestionOne(3);
                    } else if (selectedAnswer.getText().toString().equals("Very")) {
                        User.users.get(0).setQuestionOne(4);
                    } else {
                        User.users.get(0).setQuestionOne(5);
                    }
                    openQuestionTwoActivity();
                }
            }
        });
    }

    public boolean isValid() {
        int radioBttnId = radioGrp.getCheckedRadioButtonId();
        selectedAnswer = findViewById(radioBttnId);
        if (radioGrp.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Nothing is selected", Toast.LENGTH_SHORT).show();
            Log.d("", "Not working");
        }
        if (selectedAnswer != null) {
            return true;
        }
        return false;
    }


    public void openQuestionTwoActivity() {
        Intent intent = new Intent(this, QuestionTwoActivity.class);
        startActivity(intent);
    }
}
