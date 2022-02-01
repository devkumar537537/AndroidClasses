package com.example.materialdesigningexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText emailedit,passwordedit;
    ExtendedFloatingActionButton loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginbtn = findViewById(R.id.loginbtnround);
        emailedit = findViewById(R.id.email_edit);
        passwordedit = findViewById(R.id.password_edit);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtext = emailedit.getText().toString();
                String  passwordtext = passwordedit.getText().toString();

                Snackbar.make(loginbtn,"email is => "+emailtext, Snackbar.LENGTH_SHORT)
                        .setAction("Revers", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getApplicationContext(), "password is => "+passwordtext, Toast.LENGTH_SHORT).show();
                            }
                        }).show();

            }
        });
    }
}