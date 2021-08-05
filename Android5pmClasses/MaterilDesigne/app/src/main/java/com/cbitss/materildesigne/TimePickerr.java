package com.cbitss.materildesigne;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class TimePickerr extends AppCompatActivity {
TimePicker timePicker;
TextView timeviewtext;
Button changetext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        timePicker = findViewById(R.id.timperpicker);
        timeviewtext = findViewById(R.id.timeview_text);
        changetext = findViewById(R.id.changetimebtn);
        timeviewtext.setText(getculrrenttime());
        changetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeviewtext.setText(getculrrenttime());
            }
        });

    }
    public String getculrrenttime()
    {
        String  currentitme = "Current time: "+timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute();
        return currentitme;
    }
}