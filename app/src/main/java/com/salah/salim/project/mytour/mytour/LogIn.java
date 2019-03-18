package com.salah.salim.project.mytour.mytour;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private CheckBox cbRememberMe;
    private Button btnSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        cbRememberMe = findViewById(R.id.cbRememberMe);
        btnSign = findViewById(R.id.btnSign);

        final SharedPreferences sp = getSharedPreferences("spFile", MODE_PRIVATE);
        if(sp.getBoolean("rememberMe", false))
        {
            etUsername.setText(sp.getString("username", null));
            etPassword.setText(sp.getString("password", null));
            cbRememberMe.setChecked(true);
        }

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etUsername.getText().toString().trim().isEmpty() || etPassword.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(LogIn.this, "Login Unsuccessful", Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (cbRememberMe.isChecked())
                    {
                        sp.edit().putBoolean("rememberMe", true).commit();
                        sp.edit().putString("username", etUsername.getText().toString().trim()).commit();
                        sp.edit().putString("password", etPassword.getText().toString().trim()).commit();
                    }
                    else
                    {
                        sp.edit().putBoolean("rememberMe", false).commit();
                        sp.edit().putString("username", "").commit();
                        sp.edit().putString("password", "").commit();
                    }

                    Toast.makeText(LogIn.this, "Login Successful", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
