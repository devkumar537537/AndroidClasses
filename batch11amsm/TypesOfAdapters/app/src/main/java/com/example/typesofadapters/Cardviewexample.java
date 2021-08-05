package com.example.typesofadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class Cardviewexample extends AppCompatActivity {
TextInputEditText emailedit,passwordedit;
ExtendedFloatingActionButton loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardviewexample);
        emailedit = findViewById(R.id.emailedit);
        passwordedit = findViewById(R.id.passwordedit);
        loginbtn = findViewById(R.id.btnlgoin);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtext = emailedit.getText().toString();
                String passwordtext = passwordedit.getText().toString();

                Snackbar.make(loginbtn,"email is => "+emailtext,Snackbar.LENGTH_LONG)
                        .setAction("show password", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(Cardviewexample.this, "password is => "+passwordtext, Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
    }
}