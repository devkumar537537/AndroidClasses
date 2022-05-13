package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText editanyvalue;
Button clickbtn;
Button movebtn,movetothird;
Button movetogetting;
TextView textsample;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editanyvalue = findViewById(R.id.anyvalue);
        clickbtn = findViewById(R.id.checkbtn);
        textsample = findViewById(R.id.sampletext);
           movebtn = findViewById(R.id.moveToSecond);
           movetothird = findViewById(R.id.moveTothird);
          movetogetting = findViewById(R.id.movetogettingvalue);
          movetogetting.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent movetogettingintent =new Intent(MainActivity.this,GettingValuesActivity.class);
                  startActivity(movetogettingintent);


              }
          });
           movetothird.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent =new Intent(MainActivity.this,SignUpPage.class);
                   startActivity(intent);
               }
           });
           movebtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent =new Intent(MainActivity.this,SecondActivity.class);
                   startActivity(intent);
               }
           });
        clickbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value =editanyvalue.getText().toString();
               int age = Integer.parseInt(value);

               if(age >= 18)
               {
                   textsample.setText("You can vote");
               }else {
                   textsample.setText("you can  not vote");
               }
            }
        });
    }
}