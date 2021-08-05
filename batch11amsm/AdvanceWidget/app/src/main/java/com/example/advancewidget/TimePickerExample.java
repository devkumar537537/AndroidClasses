package com.example.advancewidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class TimePickerExample extends AppCompatActivity {
TimePicker timePicker;
TextView datetext;
Button choosebtn,chooserating,showtoast;
RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_example);
        connectxml();
        datetext.setText(gettime());
        choosebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String timetext = gettime();
                datetext.setText(timetext);
            }
        });
        chooserating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float ratingvalue = ratingBar.getRating();
                Toast.makeText(TimePickerExample.this, "selected rating => "+String.valueOf(ratingvalue), Toast.LENGTH_SHORT).show();
            }
        });
        showtoast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void connectxml() {
        timePicker = findViewById(R.id.timpleppicker);
        datetext = findViewById(R.id.timeview);
        choosebtn = findViewById(R.id.submitbtn);
        chooserating = findViewById(R.id.choosrating);
        ratingBar = findViewById(R.id.ratingbar);
        showtoast = findViewById(R.id.customtoast);
    }

    private String gettime()
    {
        int hour = timePicker.getHour();
        int minutes = timePicker.getMinute();
        String time = "Current Time => "+String.valueOf(hour)+"/"+String.valueOf(minutes);
        return time;
    }
}