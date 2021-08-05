package com.example.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

@SuppressWarnings("deprecation")
public class TimePickerExample extends AppCompatActivity {
TimePicker timePicker;
Button timepickbtn;
TextView timetextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_example);
        connectxml();
        timetextview.setText(gettime());
        timepickbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timetextview.setText(gettime());
            }
        });

    }

    private  void connectxml()
    {
        timepickbtn = findViewById(R.id.picktime);
        timePicker = findViewById(R.id.timepicker);
        timetextview = findViewById(R.id.timetextview);
    }

    private  String gettime()
    {
        int hour;
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M)
        {
             hour = timePicker.getHour();
        }else
        {
             hour = timePicker.getCurrentHour();
        }

        int minutes = timePicker.getMinute();
        String timetext = "Updated time "+ String.valueOf(hour) +" : "+String.valueOf(minutes);
        return timetext;
    }
}