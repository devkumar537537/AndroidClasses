package com.example.radiobuttonexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class MainActivity extends AppCompatActivity {
RadioGroup radioGroup;
ExtendedFloatingActionButton checkbtn;
RadioButton responsebtn,firstoption,secondoption,thirdoption,fourthoption;
TextView questiontext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     connectxml();
        checkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = -1;
                id = radioGroup.getCheckedRadioButtonId();
                if( id <0)
                {
                    Toast.makeText(MainActivity.this, "Select Atleast one option", Toast.LENGTH_SHORT).show();
                }else
                {

                    responsebtn = findViewById(id);
                    String reponsetext = responsebtn.getText().toString().trim();
                    if(reponsetext.equals("Nine"))
                    {
                        Toast.makeText(MainActivity.this, "You are Right", Toast.LENGTH_SHORT).show();
                    }else
                    {
                        Toast.makeText(MainActivity.this, "Try Again ?", Toast.LENGTH_SHORT).show();
                    }

                    questiontext.setText("Who is the Prime minsiter of India ?");
                    firstoption.setText("Dr. manmohan Singh");
                    secondoption.setText("Narendra Modi");
                    thirdoption.setText("Pranv mukergi");
                    fourthoption.setText("Indra Gandhi");
                }


            }
        });
    }
    private void connectxml()
    {
        radioGroup = findViewById(R.id.planetradiogroup);
        checkbtn = findViewById(R.id.checkbtn);
        firstoption = findViewById(R.id.sixradiobtn);
        secondoption = findViewById(R.id.fourbtn);
        thirdoption = findViewById(R.id.ninebtn);
        fourthoption = findViewById(R.id.fourbtn);
        questiontext = findViewById(R.id.squestiontext);
    }
}