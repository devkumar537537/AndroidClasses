package com.example.spinnerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class RelativeExample extends AppCompatActivity {

    EditText valueedit;
    String citytext;
    int agevalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_example);
        valueedit = findViewById(R.id.valueedit);

       if( getIntent() != null)
       {
           citytext = getIntent().getStringExtra("city");
           agevalue = getIntent().getIntExtra("age",18);
       }

       valueedit.setText(" "+citytext+ " and "+ agevalue);
    }
}