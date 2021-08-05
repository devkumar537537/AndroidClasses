package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AfterNotifcationActivity extends AppCompatActivity {
String value ;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_notifcation);
        textView = findViewById(R.id.notification);
        if(getIntent() != null)
        {
            value = getIntent().getStringExtra("message");
            textView.setText(value);
        }

    }
}