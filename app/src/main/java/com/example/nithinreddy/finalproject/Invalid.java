package com.example.nithinreddy.finalproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class Invalid extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.invalidwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*0.5), (int) (height*0.5));
    }
}
