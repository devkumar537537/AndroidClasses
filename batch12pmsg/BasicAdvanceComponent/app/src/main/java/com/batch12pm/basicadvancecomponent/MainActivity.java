package com.batch12pm.basicadvancecomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    Button btnspinner;
    TextView spinnerviewtext;
    String citytext;
String[] citylist={"[choose -your city---]","Ambala","Derabassi","Mohali","Panipat","Chandigarh", "Mansa","Lucknow","Kaithal","Sirmour","solan","Shamli","Ambala","Derabassi","Mohali","Panipat","Chandigarh", "Mansa","Lucknow","Kaithal","Sirmour","solan","Shamli"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            connection();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.spiinnerformatelayout,citylist);
        adapter.setDropDownViewResource(R.layout.spiinnerformatelayout);

        spinner.setAdapter(adapter);
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         citytext = citylist[position];


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});


btnspinner.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        spinnerviewtext.setText(citytext);
        TestModel testModel = new TestModel();
        testModel.setAge("nice");
        testModel.setName("cut");
        SecondModel sone = new SecondModel();
        sone.setEmail("abc@gmail.com");
        sone.setNumber("345345345");
        testModel.setSecondModel(sone);
        Intent intent = new Intent(MainActivity.this,TimePikcerExample.class);
        intent.putExtra("myarray",  testModel);
        startActivity(intent);
    }
});


    }

    private void connection()
    {
        spinner = findViewById(R.id.spinnerlayout);
        btnspinner = findViewById(R.id.spinnerbtn);
        spinnerviewtext = findViewById(R.id.slectectedtextview);
    }
}