package com.example.spinnerexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spinnerexample.fragements.FirstFragment;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerview;
    TextView textView;
    Button checttext,movebtn;
    EditText valuedit;
    String selectedtext;
    String[] cities = {"[--Select--any--city--]","Ambala","Mohali","Chandigarah","Zirakpur","Derabassi","Maubarakpur","Panchkula","Ambala","Mohali","Chandigarah","Zirakpur","Derabassi","Maubarakpur","Panchkula","Ambala","Mohali","Chandigarah","Zirakpur","Derabassi","Maubarakpur","Panchkula","Ambala","Mohali","Chandigarah","Zirakpur","Derabassi","Maubarakpur","Panchkula"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerview = findViewById(R.id.spinnerlayout);
        textView = findViewById(R.id.spinnertextview);
       checttext = findViewById(R.id.picktext);
valuedit = findViewById(R.id.ageedit);
       movebtn = findViewById(R.id.movetoanother);

       movebtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
             String agetext = valuedit.getText().toString().trim();
             int age = Integer.parseInt(agetext);
               Intent movetobj = new Intent(MainActivity.this,RelativeExample.class);
               movetobj.putExtra("city",selectedtext);
               movetobj.putExtra("age",age);
               startActivity(movetobj);

           }
       });
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),R.layout.spinneritem,cities);
        arrayAdapter.setDropDownViewResource(R.layout.spinneritem);
        spinnerview.setAdapter(arrayAdapter);

        spinnerview.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                selectedtext = cities[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(), "nothing selected in spinner", Toast.LENGTH_SHORT).show();
            }
        });


        checttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedtext.equals("[--Select--any--city--]")){
                    Toast.makeText(getApplicationContext(), "select atleast one city", Toast.LENGTH_SHORT).show();
                    textView.setText("nothing  selected");
                }else
                {
                    textView.setText(selectedtext);
                }
            }
        });


        //for opening fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmnetcontainer,new FirstFragment());
        fragmentTransaction.commit();
    }
}