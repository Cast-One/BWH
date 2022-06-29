package com.castillo.breathewithme.Registro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.castillo.breathewithme.Menu.MenuActivity;
import com.castillo.breathewithme.R;
import com.castillo.breathewithme.ToolsApp.Tools;

public class RegisterActivity extends AppCompatActivity {

    EditText edit_email, edit_password, edit_alias, edit_age;
    TextView button_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        button_start = findViewById(R.id.button_start);
        edit_email = findViewById(R.id.edit_email);
        edit_password = findViewById(R.id.edit_password);
        edit_alias = findViewById(R.id.edit_alias);
        edit_age = findViewById(R.id.edit_age);

        button_start.setOnClickListener(view ->{
            if (validateFields()){
                Tools.nextActivity(MenuActivity.class, RegisterActivity.this);
            }
        });
    }

    boolean validateFields(){
        String email = edit_email.getText().toString();
        String password = edit_password.getText().toString();
        String alias = edit_alias.getText().toString();
        String age = edit_age.getText().toString();

        if (!email.equals("")){
            String regExpn = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

            if (!email.matches(regExpn)){
                Toast.makeText(RegisterActivity.this, "Tu email no es valido", Toast.LENGTH_LONG).show();
                return false;
            }
        }

        if (password.equals("") || password.length() <6){
            Toast.makeText(RegisterActivity.this, "Tu contraseña debe tener al menos 6 caracteres", Toast.LENGTH_LONG).show();
            return false;
        }

        if (alias.equals("")){
            Toast.makeText(RegisterActivity.this, "Escribe tu nombre o Alias", Toast.LENGTH_LONG).show();
            return false;
        }

        if (age.equals("") || Integer.parseInt(age) < 18){
            Toast.makeText(RegisterActivity.this, "Debes ser mayor de edad", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }
}