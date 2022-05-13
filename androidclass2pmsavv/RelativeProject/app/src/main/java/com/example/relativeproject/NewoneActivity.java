package com.example.relativeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NewoneActivity extends AppCompatActivity {
    TextView textView;
    String emailvalue,passwordvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newone);
        textView = findViewById(R.id.textview);
        textView.setText("No values");
        if(getIntent() != null)
        {
            emailvalue = getIntent().getStringExtra("email");
            passwordvalue = getIntent().getStringExtra("password");
            textView.setText("email is => "+emailvalue+"\n and password is => "+passwordvalue);
        }
    }
}