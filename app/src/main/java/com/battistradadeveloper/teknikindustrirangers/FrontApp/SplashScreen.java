package com.battistradadeveloper.teknikindustrirangers.FrontApp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.battistradadeveloper.teknikindustrirangers.R;

public class SplashScreen extends AppCompatActivity {
    private int waktu_loading = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent login = new Intent(SplashScreen.this, Login.class);
                startActivity(login);
                finish();
            }
        },waktu_loading);
    }
}
