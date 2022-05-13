package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button mybtn;
EditText myeidt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybtn = findViewById(R.id.clickbtn);
        myeidt = findViewById(R.id.valueedit);

        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valuetext =myeidt.getText().toString();
                int a =Integer.parseInt(valuetext);
                if(a%2==0)
                {
                    Toast.makeText(MainActivity.this,"number is event ",Toast.LENGTH_SHORT).show();
                }else{
                   Toast.makeText(MainActivity.this,"number is odd",Toast.LENGTH_LONG).show();
                }
              //  Toast.makeText(MainActivity.this,"my value is "+valuetext,Toast.LENGTH_SHORT).show();
            }
        });
    }
}