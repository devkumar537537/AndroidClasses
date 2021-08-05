package com.example.menus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class DatePickerExample extends AppCompatActivity {
DatePicker datePicker;
Button pickDateBtn,producedialog,movetotimepicker;
TextView dateViewText;

AlertDialog.Builder  builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_example);
        //combined
       connectxml();
        builder = new AlertDialog.Builder(this);


producedialog.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        builder.setTitle("Warning ?")
                .setMessage("Want to close Activity ?")
                .setIcon(R.drawable.warningplate)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(DatePickerExample.this,MainActivity.class);
                        startActivity(intent);
                    }
                })
                .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();

    }
});

        String datevalue =   getDate();
        dateViewText.setText(datevalue);


        pickDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  String dateValue = getDate();
                  dateViewText.setText("Updated date"+dateValue);
            }
        });

        movetotimepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatePickerExample.this,TimePickerExample.class);
                startActivity(intent);
            }
        });
    }

    private String getDate()
    {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth()+1;
        int year = datePicker.getYear();

        String datetext = String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year);
        return datetext;
    }

    private void connectxml()
    {
        datePicker = findViewById(R.id.datepicker);
        pickDateBtn = findViewById(R.id.pickdatebtn);
        dateViewText = findViewById(R.id.dateview);
        producedialog = findViewById(R.id.producedialogbtn);
        movetotimepicker = findViewById(R.id.movetotimepickebtn);
    }
}