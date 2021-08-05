package com.example.androidnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AfterNotificationActivity extends AppCompatActivity {
TextView value;
String receivevalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_notification);
        value = findViewById(R.id.notificationtext);
        if(getIntent() != null)
        {
            receivevalue = getIntent().getStringExtra("myvalue");
        }
    }
}