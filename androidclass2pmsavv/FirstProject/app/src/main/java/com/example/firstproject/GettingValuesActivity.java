package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GettingValuesActivity extends AppCompatActivity {
EditText emailedit,passwordedit;
Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_values);
        emailedit =findViewById(R.id.editemailgetting);
        passwordedit = findViewById(R.id.passwordeditgetting);
        btnlogin = findViewById(R.id.loginbtn);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailtext =emailedit.getText().toString();
                String passwordtext = passwordedit.getText().toString();

                Intent intent= new Intent(GettingValuesActivity.this,TargetActivity.class);
                intent.putExtra("email",emailtext);
                intent.putExtra("password",passwordtext);
                startActivity(intent);
            }
        });
    }
}