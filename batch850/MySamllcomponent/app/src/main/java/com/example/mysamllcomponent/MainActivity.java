package com.example.mysamllcomponent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button producealertdial,pickdate,movetoradio;
    AlertDialog.Builder builder;

    DatePicker datePicker;
    TextView dateview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      connect();


        builder = new AlertDialog.Builder(this);
        dateview.setText("Current Date"+pickdate());
        pickdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String datevalue = pickdate();
                dateview.setText("Updated Date"+datevalue);
            }
        });
        producealertdial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
builder.setIcon(R.drawable.warningsign);
builder.setMessage("Are you going to stop activity ?")
        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
       builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "you choose no btn", Toast.LENGTH_SHORT).show();
            }
        })
        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        })
        .setCancelable(false);


                AlertDialog alertDialog = builder.create();
                alertDialog.setTitle("Alerdiaglog");

                alertDialog.show();

            }
        });
        movetoradio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RadioButtonExample.class));
            }
        });
    }
    private void connect(){
        movetoradio = findViewById(R.id.movetoradiobtn);
        producealertdial = findViewById(R.id.alertdialogbtn);
        pickdate = findViewById(R.id.pickdate);
        datePicker = findViewById(R.id.datepicker);
        dateview = findViewById(R.id.dateview);
    }
    private String pickdate()
    {
        int date = datePicker.getDayOfMonth();
        int month = datePicker.getMonth()+1;
        int year = datePicker.getYear();

        String datetext = " "+date+"/"+month+"/"+year;
        return datetext;
    }
}