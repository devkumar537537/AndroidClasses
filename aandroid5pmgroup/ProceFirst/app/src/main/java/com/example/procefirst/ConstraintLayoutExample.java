package com.example.procefirst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class ConstraintLayoutExample extends AppCompatActivity {
Button pickdate;
DatePicker datePicker;
TextView dateview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout_example);
        connectxml();
dateview.setText(getDate());


pickdate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String datevalue = getDate();
        dateview.setText(getDate());
    }
});
    }


    private void connectxml(){
        pickdate = findViewById(R.id.pickdate);
        datePicker = findViewById(R.id.datepickerview);
        dateview = findViewById(R.id.curretntedateview);
    }

    private  String getDate()
    {
        int month = datePicker.getMonth()+1;
        int date = datePicker.getDayOfMonth();
        int year = datePicker.getYear();

        String finaldate = " Updated Date => "+String.valueOf(date)+"/"+String.valueOf(month)+"/"+String.valueOf(year);
        return finaldate;
    }
}