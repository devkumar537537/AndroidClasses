package com.example.voicerecorder.newpackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.voicerecorder.R;

public class NewActivity extends AppCompatActivity {
MyCallService myBoundedService;
boolean isBound ;
    private Button play, stop, record,pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        connect();
        Intent intent =new Intent(NewActivity.this,MyCallService.class);
        bindService(intent,myConnection, Context.BIND_AUTO_CREATE);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBoundedService.startmedia();
                myBoundedService.startrecording();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBoundedService.stoprecording();
            }
        });
    }

    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyCallService.MyLocalBinder binder = (MyCallService.MyLocalBinder)service;
            myBoundedService = binder.getService();
            isBound = true;
            Toast.makeText(myBoundedService, "service connected", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            isBound = false;
            Toast.makeText(myBoundedService, "service false", Toast.LENGTH_SHORT).show();
        }
    };

    public void connect()
    {
        play =  findViewById(R.id.play);
        stop = findViewById(R.id.stop);
        record =  findViewById(R.id.record);
        pause = findViewById(R.id.pause);
    }
}