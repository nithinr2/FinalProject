package com.example.nithinreddy.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText nameTxt;
    private EditText phoneTxt;
    private RadioGroup genderGrp;
    private Button startSurveyBttn;
    private RadioButton radioBttn;
    String name = "";
    String phone = "";
    String gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        genderGrp = findViewById(R.id.genderGrp);
        int radioId = genderGrp.getCheckedRadioButtonId();
        radioBttn = findViewById(radioId);
        gender = radioBttn.getText().toString();

        nameTxt = findViewById(R.id.nameTxt);
        name = nameTxt.getText().toString();

        phoneTxt = findViewById(R.id.phoneTxt);
        phone = phoneTxt.getText().toString();

        startSurveyBttn = findViewById(R.id.startSurveyBttn);
        startSurveyBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    //openInvalidClass();
                    User.users.get(0).setName(name);
                    User.users.get(0).setPhone(phone);
                    User.users.get(0).setGender(gender);
                }
            }
        });
    }
    private boolean isValid() {
        if (radioBttn == null || name.equals("") || phone.equals("")) {
            return false;
        }
        return true;
    }
}
