package com.castillo.breathewithme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;

import com.castillo.breathewithme.Registro.LoginActivity;
import com.castillo.breathewithme.ToolsApp.Tools;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long l) { }

            @Override
            public void onFinish() {
                Tools.nextActivityFinish(SplashActivity.this, LoginActivity.class);

            }
        }.start();

    }
}