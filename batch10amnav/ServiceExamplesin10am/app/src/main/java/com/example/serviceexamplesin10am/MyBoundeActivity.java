package com.example.serviceexamplesin10am;

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

public class MyBoundeActivity extends AppCompatActivity {
    TextView textView;
    Button btntime,pausebtn,resetbtn;
    private boolean isBound;
MyBoundedService myBoundedService;
    private static final String CHANNEL_ID = "technicalGuyes";
    CharSequence name = "my_channel";
    String Description = "This is my channel";
    private final int NOTIFICATION_ID = 201;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bounde);
        textView = findViewById(R.id.timetextview);
        btntime = findViewById(R.id.showtimebtn);
        pausebtn = findViewById(R.id.pausebtn);
        resetbtn = findViewById(R.id.resetbtn);
        Intent intent = new Intent(this, MyBoundedService.class);
        bindService(intent,myConnection,Context.BIND_AUTO_CREATE);
        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBound == true)
                {
                    //createnotifcaiont();
                    myBoundedService.startmedia();
                }


            }
        });
        pausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBoundedService.pausemedia();
                String currentTime = myBoundedService.getCurrentTime();
                textView.setText(currentTime);
            }
        });
        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBoundedService.reset();
            }
        });

    }




    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBoundedService.MyLocalBinder binder = (MyBoundedService.MyLocalBinder)service;
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
}