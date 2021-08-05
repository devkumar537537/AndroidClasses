package com.example.serivceexample;

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

public class BoundedServiceExample extends AppCompatActivity {
    TextView textView;
    Button btntime,pausebtn,resetbtn;
MyBoundedService myBoundedService;
    boolean isBound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bounded_service_example);

        textView = findViewById(R.id.timetextview);
        btntime = findViewById(R.id.showtimebtn);
        pausebtn = findViewById(R.id.pausebtn);
        resetbtn = findViewById(R.id.resetbtn);
        Intent intent = new Intent(BoundedServiceExample.this,MyBoundedService.class);
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);

        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBoundedService.startmedia();
            }
        });

        pausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBoundedService.pausemedia();
            }
        });

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBoundedService.reset();
            }
        });
    }

    public ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBoundedService.MyLocalBinde binde = (MyBoundedService.MyLocalBinde) service;
            myBoundedService = binde.getService();
            isBound = true;
            Toast.makeText(myBoundedService, "service connected", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            isBound = false;
            Toast.makeText(myBoundedService, "service false", Toast.LENGTH_SHORT).show();
        }
    };
}