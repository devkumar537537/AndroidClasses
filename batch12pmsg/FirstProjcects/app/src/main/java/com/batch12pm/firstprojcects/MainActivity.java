package com.batch12pm.firstprojcects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText ageedit;
Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ageedit = findViewById(R.id.ageedit);
        submit = findViewById(R.id.submitnbtn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String agetext = ageedit.getText().toString();
               int age  = Integer.parseInt(agetext);

               if(age >= 18)
               {
                   Toast.makeText(MainActivity.this,"You can vote",Toast.LENGTH_SHORT).show();
               }else
               {
                   Toast.makeText(MainActivity.this,"You can not vote",Toast.LENGTH_LONG).show();
               }
            }
        });
    }
}