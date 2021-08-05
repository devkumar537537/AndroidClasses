package com.example.serviceproject;

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

public class MyBounderServiceActivity extends AppCompatActivity {

    TextView textView;
    Button btntime,pausebtn,resetbtn;
    boolean isBound;
    MyboudedService myboudedService ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bounder_services);
        textView = findViewById(R.id.timetextview);
        btntime = findViewById(R.id.showtimebtn);
        pausebtn = findViewById(R.id.pausebtn);
        resetbtn = findViewById(R.id.resetbtn);

        Intent intent = new Intent(this, MyboudedService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);


        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myboudedService.startmedia();
               String datetext = myboudedService.getCurrentTime();
               textView.setText("Current data"+datetext);
            }
        });
        pausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myboudedService.pausemedia();


            }
        });
        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myboudedService.reset();
            }
        });


    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        MyboudedService.MyLocalBinder binder =(MyboudedService.MyLocalBinder) service;
        myboudedService = binder.getService();
        isBound =true;
        Toast.makeText(myboudedService, "Service Connected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

        isBound = false;
        Toast.makeText(myboudedService, "Service Disconnected", Toast.LENGTH_SHORT).show();
    }
};


}