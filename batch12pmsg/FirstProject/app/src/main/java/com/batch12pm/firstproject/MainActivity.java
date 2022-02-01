package com.batch12pm.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editemail;
    Button submitbtnn,movetosecond;
    Button movetoconstraint;
String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editemail = findViewById(R.id.emailedit);
        submitbtnn = findViewById(R.id.submitbtn);
        movetosecond = findViewById(R.id.secondbtn);

        movetoconstraint = findViewById(R.id.moveseocndconstraintbtn);
        movetoconstraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ConstraintLayoutSecondExample.class);
                startActivity(intent);
            }
        });
Log.e(TAG,"oncreate called");

        submitbtnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String agetext =  editemail.getText().toString();
               int age = Integer.parseInt(agetext);
               if(age >= 18)
               {
                   Toast.makeText(MainActivity.this,"You can vote",Toast.LENGTH_SHORT).show();
               }else
               {
                   Toast.makeText(MainActivity.this,"you cannot vote",Toast.LENGTH_LONG).show();
               }

            }
        });

    movetosecond.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,ImageViewExample.class);
            startActivity(intent);
        }
    });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: " );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: " );
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.e(TAG, "onPause: " );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: " );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: " );
    }
}