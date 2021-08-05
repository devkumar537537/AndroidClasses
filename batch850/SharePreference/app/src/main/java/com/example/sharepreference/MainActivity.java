package com.example.sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
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
                String values = editvalue.getText().toString().trim();
                key = editkey.getText().toString().trim();

                insertvalues(values,key);
            }
        });

        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                key = editkey.getText().toString();
                showvalue(key);
            }
        });

        deleltbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                key = editkey.getText().toString();
                deletebtn(key);
            }
        });
    }

    private void deletebtn(String key) {
        SharePreferenceLogices.deletekey(key,getApplicationContext());
    }

    private void showvalue(String key) {
         String getvlues = SharePreferenceLogices.showvalue(key,getApplicationContext());
        showtext.setText(getvlues);
    }

    private void insertvalues(String values, String key) {
        SharePreferenceLogices.insert(values,key,getApplicationContext());

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