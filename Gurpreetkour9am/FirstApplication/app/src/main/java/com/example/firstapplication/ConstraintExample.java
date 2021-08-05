package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class ConstraintExample extends AppCompatActivity {
CheckBox penn,eragerr,sharpnar;
Button calculate;
int sum =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_example);
        calculate = findViewById(R.id.firstbutton);
        penn = findViewById(R.id.pen);
        eragerr = findViewById(R.id.erager);
        sharpnar = findViewById(R.id.sarpnar);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(penn.isChecked()){
                    sum = sum+20;
                }

                if(eragerr.isChecked())
                {
                    sum = sum+10;
                }

                if(sharpnar.isChecked())
                {
                    sum = sum+10;
                }

                Toast.makeText(ConstraintExample.this, "Bill is "+sum, Toast.LENGTH_SHORT).show();
                sum = 0;
            }
        });
    }
}