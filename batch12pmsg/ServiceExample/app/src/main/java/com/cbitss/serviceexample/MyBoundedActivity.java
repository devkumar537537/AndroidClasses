package com.cbitss.serviceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyBoundedActivity extends AppCompatActivity {
    TextView textView;
    Button btntime,pausebtn,resetbtn;
    private boolean isBound;
    MyBoundedService myBoundedService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bounded);

        textView = findViewById(R.id.timetextview);
        btntime = findViewById(R.id.showtimebtn);
        pausebtn = findViewById(R.id.pausebtn);
        resetbtn = findViewById(R.id.resetbtn);


        Intent intent = new Intent(MyBoundedActivity.this,MyBoundedService.class);
        bindService(intent,myconnection,Context.BIND_AUTO_CREATE);

        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             myBoundedService.startmedia();
            }
        });

        pausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBoundedService.pausemedia();
            }
        });

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
     myBoundedService.reset();
            }
        });
    }

    private ServiceConnection myconnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
          MyBoundedService.MyLocalBinder binder = (MyBoundedService.MyLocalBinder) iBinder;
          myBoundedService = binder.getService();
          isBound = true;
            Toast.makeText(myBoundedService, "Service is connected", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;
         Toast.makeText(myBoundedService, "service disconnected", Toast.LENGTH_SHORT).show();
        }
    };


}