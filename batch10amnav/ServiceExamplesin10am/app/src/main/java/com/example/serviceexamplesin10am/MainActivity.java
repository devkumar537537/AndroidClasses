package com.example.serviceexamplesin10am;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   Button startbtn,stopbtn;
    private Button pusebtn,movebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MySerivice mySerivice = new MySerivice();
        startbtn = findViewById(R.id.start_servicet_btn);
         stopbtn = findViewById(R.id.stop_servicet_btn);

         pusebtn = findViewById(R.id.pause_servicet_btn);
          movebtn= findViewById(R.id.moveboundeservice);
          movebtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  startActivity(new Intent(MainActivity.this,MyBoundeActivity.class));
              }
          });
         startbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
            startService(new Intent(MainActivity.this,MySerivice.class));
             }
         });

         stopbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
              stopService(new Intent(MainActivity.this,MySerivice.class));
             }
         });
         pusebtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 mySerivice.onpause();
             }
         });
    }
}