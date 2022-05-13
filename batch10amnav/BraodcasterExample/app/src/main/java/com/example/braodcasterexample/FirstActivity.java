package com.example.braodcasterexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    EditText valueedit;
    Button btnclick;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        valueedit = findViewById(R.id.valueedit);
        btnclick = findViewById(R.id.clickbtn);
        textView = findViewById(R.id.resultext);

        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textvalue =valueedit.getText().toString();
               int num = Integer.parseInt(textvalue);
               int sum = 0;
               for(int i =0;i<num;i++)
               {
                   sum = sum +i;
               }

                textView.setText("The final sum is => "+sum);
            }
        });
    }
}