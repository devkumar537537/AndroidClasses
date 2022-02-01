package com.example.sampleprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class DatePickerExample extends AppCompatActivity {
DatePicker datePicker;
Button pickdate,showdate;
TextView dateview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_example);
        combine();
        pickdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String datetext = getdatetext();

            dateview.setText(datetext);


                pickdate.setVisibility(View.GONE);

                datePicker.setVisibility(View.GONE);

                showdate.setVisibility(View.VISIBLE);
            }
        });

        showdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickdate.setVisibility(View.VISIBLE);
                dateview.setVisibility(View.VISIBLE);
                datePicker.setVisibility(View.VISIBLE);

                showdate.setVisibility(View.GONE);
            }
        });
    }

    private String getdatetext() {

        int date = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();

        String datetext = date+"/"+month+"/"+year;
        return datetext;
    }

    private void combine()
    {
        datePicker = findViewById(R.id.datepicker);
        pickdate = findViewById(R.id.pickdate);
        showdate = findViewById(R.id.showdatepicker);
        dateview = findViewById(R.id.dateview);
    }
}