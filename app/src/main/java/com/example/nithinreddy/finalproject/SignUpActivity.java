package com.example.nithinreddy.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {
    private Button signUpBttn;
    private EditText usernameTxt;
    private EditText passwordTxt;
    private EditText verifyPasswordTxt;
    public String username = "";
    public String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        usernameTxt = findViewById(R.id.usernameTxt);
        passwordTxt = findViewById(R.id.passwordTxt);
        verifyPasswordTxt = findViewById(R.id.verifyPasswordTxt);

        signUpBttn = findViewById(R.id.signUpBttn);
        signUpBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    username = usernameTxt.getText().toString();
                    password = passwordTxt.getText().toString();
                    Intent intent = new Intent(SignUpActivity.this, Invalid.class);
                    startActivity(intent);
                } else {
                    openBaseActivity();
                }
            }
        });
    }

    public void openBaseActivity() {
        Intent intent = new Intent(this, BaseActivity.class);
        startActivity(intent);
    }

    public boolean isValid() {
        if (passwordTxt.getText().equals(verifyPasswordTxt.getText())
                && passwordTxt.getText().toString().length() >= 5
                && usernameTxt.getText().toString().length() >= 5) {
            return true;
        }
        return false;
    }
}
