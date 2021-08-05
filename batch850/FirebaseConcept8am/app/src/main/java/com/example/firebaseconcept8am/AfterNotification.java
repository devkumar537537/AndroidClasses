package com.example.firebaseconcept8am;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AfterNotification extends AppCompatActivity {
String vauestext;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_notification);
        textView = findViewById(R.id.valuetext);

        if(getIntent() != null)
        {
            vauestext = getIntent().getStringExtra("data");
        }
        textView.setText(vauestext);
    }
}