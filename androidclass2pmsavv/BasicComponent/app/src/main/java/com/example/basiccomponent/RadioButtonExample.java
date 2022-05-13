package com.example.basiccomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RadioButtonExample extends AppCompatActivity {
RadioGroup radioGroup;
TextView questionview;
RadioButton radioButton;
Button checkbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_example);
        questionview = findViewById(R.id.questiontext);
        radioGroup = findViewById(R.id.radiogroupt);
        checkbtn = findViewById(R.id.checkbtn);
        checkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id =-1;
                 id = radioGroup.getCheckedRadioButtonId();
                 if(id >0)
                 {
                     radioButton = findViewById(id);

                     String responsetext = radioButton.getText().toString();
                     if(responsetext.equals("Nredra Modi")){
                         Toast.makeText(RadioButtonExample.this, "you are correct", Toast.LENGTH_SHORT).show();
                     }else
                     {
                         Toast.makeText(RadioButtonExample.this, "Try again", Toast.LENGTH_SHORT).show();
                     }
                 }else
                 {
                     Toast.makeText(getApplicationContext(), "pls select at least one option", Toast.LENGTH_SHORT).show();
                 }


            }
        });
    }
}