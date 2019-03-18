package com.salah.salim.project.mytour.mytour;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class TermsAndConditions extends AppCompatActivity {

    private CheckBox cbAccept;
    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);

        cbAccept = findViewById(R.id.cbAccept);
        btnOK = findViewById(R.id.btnOK);
        btnOK.setEnabled(false);

        cbAccept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    btnOK.setEnabled(true);
                }
                else
                {
                    btnOK.setEnabled(false);
                }

            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("spFile", MODE_PRIVATE);
                sp.edit().putBoolean("accept", true).commit();
                Intent toLogin = new Intent(TermsAndConditions.this, LogIn.class);
                startActivity(toLogin);
                finish();
            }
        });
    }
}
