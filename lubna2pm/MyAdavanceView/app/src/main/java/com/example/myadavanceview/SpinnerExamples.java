package com.example.myadavanceview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerExamples extends AppCompatActivity {
Button choosebtn,pikcratingbtn;
RatingBar ratingBar;
Spinner cityspinner;
TextView cityview;
String slectedtcity;
String[] cities = {"[--select--t--city-]","Mohali","Hisar","Ambala","Chandigarh", "Mubarakpur","Derabassi","kurkshetra","Panchula","Mohali","Hisar","Ambala","Chandigarh", "Mubarakpur","Derabassi","kurkshetra","Panchula","Mohali","Hisar","Ambala","Chandigarh", "Mubarakpur","Derabassi","kurkshetra","Panchula","Mohali","Hisar","Ambala","Chandigarh", "Mubarakpur","Derabassi","kurkshetra","Panchula"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_examples);

        choosebtn = findViewById(R.id.choosecity);
        cityspinner = findViewById(R.id.spinnercity);
        cityview = findViewById(R.id.selecteccity);
       pikcratingbtn = findViewById(R.id.pickrating);
       ratingBar = findViewById(R.id.ratingbar);

       pikcratingbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              float rating =  ratingBar.getRating();
               Toast.makeText(getApplicationContext(), "rating is "+rating, Toast.LENGTH_SHORT).show();
           }
       });
        ArrayAdapter<String> cityadapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.listviewformate,cities);

        cityadapter.setDropDownViewResource(R.layout.listviewformate);

        cityspinner.setAdapter(cityadapter);


        cityspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                slectedtcity = cities[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        choosebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(slectedtcity.equals("[--select--t--city-]")){
                    Toast.makeText(getApplicationContext(), "slectec the city", Toast.LENGTH_SHORT).show();
                }else
                {
                    cityview.setText(slectedtcity);
                }

            }
        });
    }
}