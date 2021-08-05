package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstapplication.fragments.FirstFragment;

public class MainActivity extends AppCompatActivity {
TextView textView;
EditText editText,passwordedit;
Button button,movebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.firsttext);
        button = findViewById(R.id.submintbtn);
        editText = findViewById(R.id.email);
         passwordedit = findViewById(R.id.passord);
         movebtn = findViewById(R.id.movebtn);
         movebtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String emailtext = editText.getText().toString();

                 Intent intent = new Intent(MainActivity.this,SecondActivit.class);
                 intent.putExtra("data",emailtext);
                 startActivity(intent);
             }
         });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtext =editText.getText().toString();
                String passwordtext = passwordedit.getText().toString();
                textView.setText(emailtext);




            Toast.makeText(MainActivity.this, "email => "+emailtext+" \n password is  "+passwordtext,Toast.LENGTH_LONG).show();

            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentcontainer,new FirstFragment());
        fragmentTransaction.commit();

    }
}