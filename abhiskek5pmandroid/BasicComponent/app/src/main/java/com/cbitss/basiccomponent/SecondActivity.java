package com.cbitss.basiccomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class SecondActivity extends AppCompatActivity {
Spinner cityspinner;
ExtendedFloatingActionButton pickcitybtn;
String[] citylist = {"Select the city","Derabassi","Delhi","Jaipur","Banglor","Mumbai","Chennai","kanyakumari","Derabassi","Delhi","Jaipur","Banglor","Mumbai","Chennai","kanyakumari","Derabassi","Delhi","Jaipur","Banglor","Mumbai","Chennai","kanyakumari"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        cityspinner = findViewById(R.id.spinnerlayout);
        pickcitybtn = findViewById(R.id.pickcity);
        ArrayAdapter<String> cityadapter= new ArrayAdapter<String>(SecondActivity.this,R.layout.spinnerlayout,citylist);

        cityspinner.setAdapter(cityadapter);
        pickcitybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String balue=(String)  cityspinner.getSelectedItem();
                Snackbar.make(pickcitybtn,"selected city => "+balue,Snackbar.LENGTH_SHORT)
                        .setAction("revers", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getApplicationContext(), "text will revers soon", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }
}