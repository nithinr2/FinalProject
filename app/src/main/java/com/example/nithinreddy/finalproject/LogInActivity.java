package com.example.nithinreddy.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogInActivity extends AppCompatActivity {
    private Button logInBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        logInBttn = findViewById(R.id.logInButton);
        logInBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBaseActivity();
            }
        });
    }

    public void openBaseActivity() {
        Intent intent = new Intent(this, BaseActivity.class); // Fix!
        startActivity(intent);
    }
}
