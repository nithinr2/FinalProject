package com.example.nithinreddy.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;

public class RegisterActivity extends AppCompatActivity {
    private EditText nameTxt;
    private EditText phoneTxt;
    private EditText genderTxt;
    private Button startSurveyBttn;
    String name = "";
    String phone = "";
    String gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameTxt = findViewById(R.id.nameTxt);
        name = nameTxt.getText().toString();

        phoneTxt = findViewById(R.id.phoneTxt);
        phone = phoneTxt.getText().toString();

        genderTxt = findViewById(R.id.genderTxt);
        gender = genderTxt.getText().toString();

        startSurveyBttn = findViewById(R.id.startSurveyBttn);
        startSurveyBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    User.users.get(0).setName(name);
                    User.users.get(0).setPhone(phone);
                    User.users.get(0).setGender(gender);
                    openQuestionOneActivity();
                }
            }
        });
    }
    public boolean isValid() {
        if (name == null || phone == null || gender == null) {
            return false;
        }
        return true;
    }
    public void openQuestionOneActivity() {
        Intent intent = new Intent(this, QuestionOneActivity.class);
        startActivity(intent);
    }
}
