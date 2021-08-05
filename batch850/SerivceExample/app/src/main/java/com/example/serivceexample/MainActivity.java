package com.example.serivceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button startbtn,stopbtn,pausebtn,movebtn;
    MyUnboundedService myUnboundedService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startbtn = findViewById(R.id.start_servicet_btn);
        stopbtn = findViewById(R.id.stop_servicet_btn);
        pausebtn = findViewById(R.id.pause_servicet_btn);
        movebtn = findViewById(R.id.move_to_other);
        myUnboundedService = new MyUnboundedService();
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyUnboundedService.class);
                startService(intent);
            }
        });
//pausebtn.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        myUnboundedService.paudemedit();
//    }
//});
        movebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BoundedServiceExample.class));
            }
        });
        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyUnboundedService.class);
                stopService(intent);
            }
        });
    }
}