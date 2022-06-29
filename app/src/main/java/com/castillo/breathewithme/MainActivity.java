package com.castillo.breathewithme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text_plantilla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_plantilla = findViewById(R.id.text_plantilla);

        text_plantilla.setText(R.string.texto);
    }
}