package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfirstapp.fragments.FirstFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button  loginbtn,movetobtn;
    EditText emailedit,passwordedit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginbtn = findViewById(R.id.login);
        emailedit = findViewById(R.id.emailedit);
        passwordedit = findViewById(R.id.passwordedit);
       movetobtn = findViewById(R.id.movetosecond);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String email_text =  emailedit.getText().toString();
               String pasword_text = passwordedit.getText().toString();

                Toast.makeText(MainActivity.this,"email => "+email_text+" \n password => "+pasword_text,Toast.LENGTH_SHORT).show();

            }
        });
   movetobtn.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {

            String email_text = emailedit.getText().toString().trim();
//String email = "kdevoe@fgmali.com"

           Intent moveintent = new Intent(MainActivity.this,SecondActivity.class);
           moveintent.putExtra("email",email_text);
           startActivity(moveintent);
       }
   });

        Log.e(TAG, "onCreate: " );

        //fragment attaching code

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmcontainer,new FirstFragment());
        fragmentTransaction.commit();

    }


}