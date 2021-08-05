package com.example.sharepreferencess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button insertbtn,showbtn,deleltbtn,movetorecyclerview;
    TextView showtext;
    EditText editvalue,editkey;
    String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conecxml();
        insertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                key = editkey.getText().toString();
                String value = editvalue.getText().toString();

                SharePreferconfigaration.insertvalue(key,value,getApplicationContext());
            }
        });
        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                key = editkey.getText().toString();
                String getvalue = SharePreferconfigaration.showvalue(key,getApplicationContext());
                showtext.setText(getvalue);
            }
        });

        deleltbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                key = editkey.getText().toString();
                SharePreferconfigaration.deletekey(key,getApplicationContext());
            }
        });
        movetorecyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
    }

    private void conecxml() {
        insertbtn = findViewById(R.id.insertbtn);
        showbtn = findViewById(R.id.Showbtn);
        showtext = findViewById(R.id.valuetextview);
        editvalue = findViewById(R.id.value);
        editkey = findViewById(R.id.keyedit);
        deleltbtn = findViewById(R.id.deletebtn);
        movetorecyclerview = findViewById(R.id.movetoanotherbtn);
    }
}