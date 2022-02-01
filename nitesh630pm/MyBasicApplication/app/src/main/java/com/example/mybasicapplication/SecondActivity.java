package com.example.mybasicapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
EditText emailedit,passwordedit;
Button loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        emailedit = findViewById(R.id.editemail);
        passwordedit= findViewById(R.id.editpassword);
        loginbtn = findViewById(R.id.logintbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtext = emailedit.getText().toString();
                String passwordtext = passwordedit.getText().toString();

                Toast.makeText(SecondActivity.this,"email =>"+emailtext+" \n password =>"+passwordtext,Toast.LENGTH_LONG).show();

            }
        });
    }
}