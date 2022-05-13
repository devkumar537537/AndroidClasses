package com.example.basiccomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
RadioGroup radioGroup;
RadioButton responsradioButton;
Button btncheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
     radioGroup = findViewById(R.id.radiogroup);
     btncheck =findViewById(R.id.checkbtn);
     btncheck.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             int id =-1;
            id = radioGroup.getCheckedRadioButtonId();
            if(id>0)
            {
                responsradioButton = findViewById(id);
                String responsetext = responsradioButton.getText().toString();
                if(responsetext.equals("Narendra Modi")){
                    Toast.makeText(SecondActivity.this, "user right", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(SecondActivity.this, "user wrong", Toast.LENGTH_SHORT).show();
                }
            }else
            {
                Toast.makeText(SecondActivity.this, "pls select option", Toast.LENGTH_SHORT).show();
            }


         }
     });

    }
}