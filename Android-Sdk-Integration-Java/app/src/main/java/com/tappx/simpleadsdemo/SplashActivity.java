package com.tappx.simpleadsdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread changeActivity = new Thread() {
            public void run() {
                try {
                    sleep(5 * 1000);
                    Intent screenToPrincipal = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(screenToPrincipal);
                    finish();
                } catch (Exception e) {
                }
            }
        };
        changeActivity.start();
    }
}