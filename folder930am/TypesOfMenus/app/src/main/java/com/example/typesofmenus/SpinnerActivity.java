package com.example.typesofmenus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SpinnerActivity extends AppCompatActivity{
    Spinner spinner;
    private static final String TAG = "SpinnerActivity";
    String[] bikes={"Select Bike Model","KTM","Splender","Duke","CT100","ABc","night","honda","tvs","KTM","Splender","Duke","CT100","ABc","night","honda","tvs"};
  DatePicker datePicker;
  Button pickbtn;
  TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

connextxml();
textView.setText("Current Date => "+getNowdate());

pickbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        textView.setText("Updated Date => "+getNowdate());
    }
});

        ArrayAdapter<String > arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,bikes);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String value = bikes[position];

                if(position <=0){
                    Toast.makeText(SpinnerActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(SpinnerActivity.this, "selecte "+value, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.e(TAG, "onNothingSelected: Nothing selected" );
            }
        });
    }

    private String getNowdate() {
        String datevalue = datePicker.getDayOfMonth()+"/"+(datePicker.getMonth() + 1) +"/"+datePicker.getYear();
        return datevalue;
    }

    private void connextxml() {
        spinner = findViewById(R.id.spinner);
        datePicker = findViewById(R.id.datepicker);
        pickbtn = findViewById(R.id.pickdate);
        textView = findViewById(R.id.datetextvew);
    }
}