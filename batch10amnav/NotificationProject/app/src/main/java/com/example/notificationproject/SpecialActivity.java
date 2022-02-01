package com.example.notificationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SpecialActivity extends AppCompatActivity {

    String firstvlaue,secondvalue;
    private static final String TAG = "SpecialActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special);
        if(getIntent() != null)
        {
            firstvlaue = getIntent().getStringExtra("mymsgone");
            secondvalue = getIntent().getStringExtra("mymsgtwo");
        }
        Log.e(TAG, "onCreate: "+firstvlaue+" and \n "+secondvalue );
    }
}