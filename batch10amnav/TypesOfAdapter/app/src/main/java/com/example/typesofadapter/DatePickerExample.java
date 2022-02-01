package com.example.typesofadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class DatePickerExample extends AppCompatActivity {
DatePicker datePicker;
Button button;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_example);
        datePicker = findViewById(R.id.datepickerexample);
        button = findViewById(R.id.pickdatebtn);
        textView = findViewById(R.id.dateview);

        String datetext = getdatetext();
        textView.setText(datetext);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String datetext = getdatetext();
                textView.setText(datetext);
            }
        });
    }

    private String getdatetext() {

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth()+1;
        int year = datePicker.getYear();
        String datetext = "Updated Date "+day+"/"+month+"/"+year;
        return datetext;
    }
}