package com.example.radiobuttonexamplejava;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
RadioGroup radioGroup;
RadioButton radioButton;
RatingBar rating;
Spinner spinner;
Button checkbtn,checkrating;
String[] cities ={"Select city","Mohali","Chandigarh","Ambala","Amritsar","jalandar","Ludiana","Husyarpur","Mohali","Chandigarh","Ambala","Amritsar","jalandar","Ludiana","Husyarpur"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radiogroudp);
        checkbtn = findViewById(R.id.checkbtn);
           checkrating=findViewById(R.id.showrating);
           rating = findViewById(R.id.ratingbar);
           spinner = findViewById(R.id.spinneritem);
           checkrating.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   float ratingtext = rating.getRating();
                   Toast.makeText(MainActivity.this, "selected rating "+ratingtext, Toast.LENGTH_SHORT).show();
               }
           });
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.listitem,cities);
        arrayAdapter.setDropDownViewResource(R.layout.listitem);

        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = cities[position];
                Toast.makeText(MainActivity.this, "selected ciyt "+text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        checkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = -1;
                id = radioGroup.getCheckedRadioButtonId();
                if(id >0)
                {
                    radioButton = findViewById(id);
                    String text= radioButton.getText().toString();
                    if(text.equals("9"))
                    {
                        Toast.makeText(MainActivity.this, "Right Answer", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(MainActivity.this, "Select altlest one option", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}