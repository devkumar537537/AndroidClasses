package com.batch12pm.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ConstraintLayoutExmaple extends AppCompatActivity {

    RadioGroup radioGroup;
    Button checkbtn;
    RadioButton responseradiobtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);
        radioGroup = findViewById(R.id.radiogroup);
        checkbtn = findViewById(R.id.checannsbtn);

        checkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = -1;
                 id =radioGroup.getCheckedRadioButtonId();
                 if(id >0){
                     responseradiobtn = findViewById(id);

                     String responsetext = responseradiobtn.getText().toString();

                     if(responsetext.equals("1996")){
                         Toast.makeText(getApplicationContext(), "you are right", Toast.LENGTH_SHORT).show();
                     }else
                     {
                         Toast.makeText(getApplicationContext(), "you are wrong", Toast.LENGTH_SHORT).show();
                     }
                 }else
                 {
                    Toast.makeText(getApplicationContext(),"select atleast one option",Toast.LENGTH_LONG).show();
                 }

            }
        });
    }


}