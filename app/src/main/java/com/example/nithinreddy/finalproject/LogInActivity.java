package com.example.nithinreddy.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity {
    private Button logInBttn;
    private EditText passwordTxt;
    private EditText usernameTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        passwordTxt = findViewById(R.id.passwordTxt);
        usernameTxt = findViewById(R.id.usernameTxt);

        logInBttn = findViewById(R.id.logInBttn);
        logInBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isValid()) { // Finish implementation!
                    openInvalidClass();
                }
                openBaseActivity();
            }
        });
    }

    public void openInvalidClass() {
        Intent intent = new Intent(this, Invalid.class);
        startActivity(intent);
    }

    public void openBaseActivity() {
        Intent intent = new Intent(this, BaseActivity.class); // Fix!
        startActivity(intent);
    }

    public boolean isValid() {
        String password = passwordTxt.getText().toString();
        String username = usernameTxt.getText().toString();
        //if (password.equals())
        return true;
    }
}
