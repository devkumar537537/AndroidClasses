package com.example.servicesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button startbtn,stopbtn,pausebtn,movebtn;
MyUnboucndeService myUnboucndeService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startbtn = findViewById(R.id.start_servicet_btn);
        stopbtn = findViewById(R.id.stop_servicet_btn);
        pausebtn = findViewById(R.id.pause_servicet_btn);
        movebtn = findViewById(R.id.move_to_other);
        movebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
startActivity(new Intent(MainActivity.this,MyBoundedActivity.class));
            }
        });
        myUnboucndeService = new MyUnboucndeService();
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(MainActivity.this,MyUnboucndeService.class));
            }
        });

        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               stopService(new Intent(MainActivity.this,MyUnboucndeService.class));
            }
        });
        pausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myUnboucndeService.ispaue();
            }
        });

    }
}