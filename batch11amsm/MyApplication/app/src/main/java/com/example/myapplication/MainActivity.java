package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     textView = findViewById(R.id.textview);
        if(getIntent() != null  && getIntent().hasExtra("title")){

            for(String key: getIntent().getExtras().keySet())
            {
                Log.e(TAG, "onCreate: key :  "+key+" data is " + getIntent().getExtras().getString(key) );
                textView.append(getIntent().getExtras().getString(key) + "\n");
            }
        }
    }
}