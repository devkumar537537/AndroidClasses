package com.example.bottomsheetexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button opentbtn,showcustomtoast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opentbtn = findViewById(R.id.openbtnid);
        showcustomtoast = findViewById(R.id.showcustomtoast);
        showcustomtoast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(getApplicationContext());

                LayoutInflater layoutInflater =(LayoutInflater)  getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             View view = layoutInflater.inflate(R.layout.customtoast,(ViewGroup) findViewById(R.id.customtoast));
                TextView textView = view.findViewById(R.id.usernamt);
                textView.setText("Dev Saxena");
             toast.setView(view);
             toast.setDuration(Toast.LENGTH_SHORT);
             toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
             toast.show();
            }
        });
        opentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetExample bottomSheetExample = new BottomSheetExample();
                bottomSheetExample.show(getSupportFragmentManager(),"Bottom Sheet");
            }
        });
    }
}