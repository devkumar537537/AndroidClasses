package com.example.firebaseconcept;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AfterNotification extends AppCompatActivity {
TextView textView;
String somevalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_notification);
        textView = findViewById(R.id.textView3);
        if(getIntent() != null)
        {
            somevalue = getIntent().getStringExtra("myvalue");
        }
        textView.setText(somevalue);
    }
}