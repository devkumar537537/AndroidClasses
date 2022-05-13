package com.example.voicerecorder.packagecallrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.voicerecorder.R;

public class CAllActivity extends AppCompatActivity {
ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        toggleButton = findViewById(R.id.togglebutton);
    }
    public void toggleonclick(View view)
    {
        boolean checked = ((ToggleButton)view).isChecked();
        if(checked)
        {
            Intent intent =new Intent(this,RecordingService.class);
            startService(intent);
            Toast.makeText(this, "Call recording started", Toast.LENGTH_SHORT).show();
        }else
        {
            Intent intent =new Intent(this,RecordingService.class);
            stopService(intent);
            Toast.makeText(this, "Call recording stop", Toast.LENGTH_SHORT).show();
        }

    }
}