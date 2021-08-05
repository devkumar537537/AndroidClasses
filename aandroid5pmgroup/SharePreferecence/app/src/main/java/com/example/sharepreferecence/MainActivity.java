package com.example.sharepreferecence;

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
                String valuetext = editvalue.getText().toString().trim();
                key = editkey.getText().toString().trim();

                inservalue(valuetext,key);
            }
        });

        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                key = editkey.getText().toString().trim();
                showvalu(key);
            }
        });
        deleltbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                key = editkey.getText().toString().trim();
                deletedata(key);
            }
        });
    }

    private void deletedata(String key) {
        SharePreferences.deletevalue(key,getApplicationContext());
    }

    private void showvalu(String key) {
     String geted =    SharePreferences.showvalue(key,getApplicationContext());
     showtext.setText(geted);
    }

    private void inservalue(String valuetext, String key) {
        SharePreferences.insertvalue(valuetext,key,getApplicationContext());

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