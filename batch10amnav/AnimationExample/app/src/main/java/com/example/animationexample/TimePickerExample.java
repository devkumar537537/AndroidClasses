package com.example.animationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class TimePickerExample extends AppCompatActivity {
TimePicker timePicker;
Button picktime;
TextView timeviw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_example);
        connectxml();
        String timetext = gettime();
        timeviw.setText(timetext);
picktime.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String timetext = gettime();
        timeviw.setText(timetext);

    }
});


    }

    private String gettime() {

        int hour = timePicker.getHour();
        int minutes = timePicker.getMinute();

        String finaltimetext = "Current Time => "+String.valueOf(hour)+" : "+String.valueOf(minutes);
        return finaltimetext;
    }

    private void connectxml() {
        timePicker = findViewById(R.id.timepicker);
        picktime = findViewById(R.id.picktimebtn);
        timeviw = findViewById(R.id.timeview);
    }
}