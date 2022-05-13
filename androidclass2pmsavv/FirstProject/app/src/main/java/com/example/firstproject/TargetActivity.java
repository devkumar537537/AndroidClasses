package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TargetActivity extends AppCompatActivity {
String emailvalue;
String passwordvale;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        textView = findViewById(R.id.valuestext);
        if(getIntent() != null){
            emailvalue = getIntent().getStringExtra("email");
            passwordvale = getIntent().getStringExtra("password");
            String finalstring = "My email is "+emailvalue+" \n and password is "+passwordvale;
            textView.setText(finalstring);
        }
    }
}