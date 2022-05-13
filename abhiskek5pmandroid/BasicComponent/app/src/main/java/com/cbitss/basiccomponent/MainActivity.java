package com.cbitss.basiccomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TimePicker timePicker;
TextView timeview;
Button picktimebbtn,pickratingbutton,movetosecond;
RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        picktimebbtn = findViewById(R.id.picktimebtn);
        timeview = findViewById(R.id.timetextview);
        timePicker = findViewById(R.id.timelayout);
        ratingBar = findViewById(R.id.ratingbar);
        pickratingbutton = findViewById(R.id.pickratingbtn);
        movetosecond=findViewById(R.id.movetosecond);

        movetosecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveint = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(moveint);
            }
        });
        pickratingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float rating = ratingBar.getRating();
             Toast.makeText(MainActivity.this,"selected rating => "+rating,Toast.LENGTH_SHORT).show();

            }
        });

        picktimebbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >=  Build.VERSION_CODES.M)
                {
                  int hour = timePicker.getHour();
                  int minutes = timePicker.getMinute();

                  String time = " "+String.valueOf(hour)+":"+String.valueOf(minutes);
                  timeview.setText(time);
                }


            }
        });

    }
}