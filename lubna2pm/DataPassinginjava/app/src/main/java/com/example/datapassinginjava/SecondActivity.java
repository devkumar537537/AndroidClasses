package com.example.datapassinginjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
TextView textView;
String emailvalue;
int agevalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView =findViewById(R.id.textView);

       if( getIntent() != null)
       {
           emailvalue = getIntent().getStringExtra("email");
           agevalue = getIntent().getIntExtra("age",18);
       }

       textView.setText(" "+emailvalue+ "\n "+agevalue);
    }

}