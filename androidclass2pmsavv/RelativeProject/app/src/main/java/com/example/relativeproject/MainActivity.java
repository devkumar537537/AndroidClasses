package com.example.relativeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText editemail,editpassword;
Button movebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editemail = findViewById(R.id.emailedit);
        editpassword = findViewById(R.id.passwordedit);
        movebtn = findViewById(R.id.movetoanother);

        movebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailtext = editemail.getText().toString();
                String passwordtext = editpassword.getText().toString();


                if(TextUtils.isEmpty(emailtext))
                {
                   Toast.makeText(MainActivity.this,"Enter email",Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(passwordtext))
                {
                    Toast.makeText(MainActivity.this,"Enter password",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this,NewoneActivity.class);
                    intent.putExtra("email",emailtext);
                    intent.putExtra("password",passwordtext);
                    startActivity(intent);
                }

            }
        });
    }
}