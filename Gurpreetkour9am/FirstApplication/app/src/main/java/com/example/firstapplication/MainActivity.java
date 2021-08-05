package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText emaillayout,passwordlayout;
Button loginbtn;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate: ");
        emaillayout= findViewById(R.id.emailedit);
        loginbtn = findViewById(R.id.logintbtn);
        passwordlayout = findViewById(R.id.passwordedit);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //value take from edittext
              String email_Text =   emaillayout.getText().toString();
              String passwordtext = passwordlayout.getText().toString();
//toast making
//                Toast.makeText(MainActivity.this,"email => "+email_Text +"\n  password => "+passwordtext,Toast.LENGTH_SHORT).show();

                Intent intent =new Intent(MainActivity.this,RelativeExample.class);

                //data seetomg
                intent.putExtra("email",email_Text);
                intent.putExtra("password",passwordtext);

                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
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