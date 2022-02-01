package com.example.mybasicapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btncalculate;
    Button btnmovetosecond;
    EditText editage;
    TextView ageviewtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncalculate = findViewById(R.id.calcutateage);
        editage = findViewById(R.id.ageEdit);
        ageviewtext =findViewById(R.id.elegibltext);
btnmovetosecond = findViewById(R.id.movetosecondbtn);

btnmovetosecond.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent moveintent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(moveintent);

    }
});

        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String agetext =editage.getText().toString();
              int age =  Integer.parseInt(agetext);

              if(age >=18)
              {
                 ageviewtext.setText("you can vote");
              }else
              {
                  ageviewtext.setText("you can not vote");
              }
            }
        });
    }
}