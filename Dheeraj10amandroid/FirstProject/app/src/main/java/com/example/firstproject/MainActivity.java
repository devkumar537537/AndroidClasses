package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button,movebtn;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       connectxml();
       clickevent();


    }

    private void clickevent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString().trim();
                int age = Integer.parseInt(text);

                if(age >= 18)
                {
                    Toast.makeText(MainActivity.this,"you can vote",Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MainActivity.this,"you can not vote",Toast.LENGTH_SHORT).show();
                }
            }
        });
        movebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    public void connectxml()
    {
        editText = findViewById(R.id.valueedit);
        button = findViewById(R.id.clickbtn);
        movebtn = findViewById(R.id.movetoanotherbtn);
    }
}