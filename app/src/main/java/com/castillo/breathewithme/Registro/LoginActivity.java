package com.castillo.breathewithme.Registro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.castillo.breathewithme.Menu.MenuActivity;
import com.castillo.breathewithme.R;
import com.castillo.breathewithme.ToolsApp.Tools;
import com.realpacific.clickshrinkeffect.ClickShrinkEffect;
import com.sn.lib.NestedProgress;

public class LoginActivity extends AppCompatActivity {
    TextView button_register;
    TextView button_start;

    LinearLayout layout_Buttons;
    LinearLayout layout_Login;

    EditText edit_email;
    EditText edit_password;
    TextView button_start_login;

    NestedProgress nestedProgress;

    View view_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button_register = findViewById(R.id.button_register);
        button_start = findViewById(R.id.button_start);
        layout_Buttons = findViewById(R.id.layout_Buttons);
        layout_Login = findViewById(R.id.layout_Login);
        edit_email = findViewById(R.id.edit_email);
        edit_password = findViewById(R.id.edit_password);
        button_start_login = findViewById(R.id.button_start_login);
        nestedProgress = findViewById(R.id.nestedProgress);
        view_progress = findViewById(R.id.view_progress);

        listeners();
    }

    @Override
    public void onBackPressed() {
        layout_Buttons.setVisibility(View.VISIBLE);
        layout_Login.setVisibility(View.GONE);

    }
    @Override
    public void onResume(){
        super.onResume();
        Tools.offProgress(LoginActivity.this);
    }

    void listeners(){
        new ClickShrinkEffect(button_start);
        new ClickShrinkEffect(button_register);
        new ClickShrinkEffect(button_start_login);

        button_start.setOnClickListener(view -> {
            Tools.openProgress(getSupportFragmentManager().beginTransaction(),LoginActivity.this);
            new CountDownTimer(3000, 1000) {
                @Override
                public void onTick(long l) { }

                @Override
                public void onFinish() {
                    Tools.nextActivity(RegisterActivity.class, LoginActivity.this);
                }
            }.start();
        });

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout_Buttons.setVisibility(View.GONE);
                layout_Login.setVisibility(View.VISIBLE);
            }
        });

        button_start_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (validateFields()){
                    Tools.nextActivity(MenuActivity.class, LoginActivity.this);
//                }
            }
        });

    }

    boolean validateFields(){
        String email = edit_email.getText().toString();
        String password = edit_password.getText().toString();

        if (email.equals("")){
            Toast.makeText(LoginActivity.this, "El email está vacio!", Toast.LENGTH_LONG).show();
            return false;
        }

        if (password.equals("") || password.length() < 6){
            Toast.makeText(LoginActivity.this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

}