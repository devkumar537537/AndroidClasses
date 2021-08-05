package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class SecondActivit extends AppCompatActivity {
TextView secondtext,dateview;
Button pickdatebtn;
DatePicker datePicker;
String emailalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        pickdatebtn = findViewById(R.id.pickdate);
        dateview = findViewById(R.id.dateview);
        datePicker = findViewById(R.id.datepicker);
        secondtext = findViewById(R.id.secontext);

        dateview.setText("Current Date => "+getdate());
pickdatebtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String dataupdatetext = getdate();
        dateview.setText("Updated Date => "+dataupdatetext);
    }
});
      emailalue =   getIntent().getStringExtra("data");
      secondtext.setText(emailalue);
    }
    private String getdate()
    {
        int date = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() +1;
        int year = datePicker.getYear();
        String datetext = ""+date+"/"+month+"/"+year;
        return datetext;
    }
}