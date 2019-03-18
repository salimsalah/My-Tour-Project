package com.salah.salim.project.mytour.mytour;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sp = getSharedPreferences("spFile", MODE_PRIVATE);

                if(sp.getBoolean("accept", false)) {
                    Intent toLogin = new Intent(Splash.this, LogIn.class);
                    startActivity(toLogin);
                    finish();
                }
                else
                {
                    Intent toTerms = new Intent(Splash.this, TermsAndConditions.class);
                    startActivity(toTerms);
                    finish();
                }
            }
        }, 5000);
    }
}
