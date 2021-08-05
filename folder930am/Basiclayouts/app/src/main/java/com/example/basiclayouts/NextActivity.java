package com.example.basiclayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
String emailvalue;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        textView = findViewById(R.id.textView2);
        if(getIntent() != null)
        {
            emailvalue = getIntent().getStringExtra("email");

        }
        textView.setText(emailvalue);
    }
}