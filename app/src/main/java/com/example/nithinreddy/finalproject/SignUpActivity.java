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
    private String username = "";
    private String password = "";
    private User user;

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
                if (!isValid()) {
                    openInvalidClass();
                } else {
                    username = usernameTxt.getText().toString();
                    password = passwordTxt.getText().toString();
                    user = new User(username, password);
                    User.users.add(0, user);
                    openRegisterActivity();
                }
            }
        });
    }

    public void openInvalidClass() {
        Intent intent = new Intent(this, Invalid.class);
        startActivity(intent);
    }

    public void openRegisterActivity() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public boolean isValid() {
        String password = passwordTxt.getText().toString();
        String verifyPassword = verifyPasswordTxt.getText().toString();
        String username = usernameTxt.getText().toString();
        if (password.equals(verifyPassword)
               && passwordTxt.getText().toString().length() >= 5
                && usernameTxt.getText().toString().length() >= 5) {
            for (int i = 0; i < User.users.size(); i++) {
                if (username.equals(User.users.get(i).getUsername())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
