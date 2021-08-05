package com.example.sharepreferencess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.value_ofkey);

        String vlaue =   SharePreferconfigaration.showvalue("Email",getApplicationContext());
        textView.setText(vlaue);
    }
}