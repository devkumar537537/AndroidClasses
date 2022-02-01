package com.example.typesofadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.typesofadapters.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class MatrialExample extends AppCompatActivity {

    TextInputEditText emailedit,passwordedit;
    ExtendedFloatingActionButton login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrial_example);

        login = findViewById(R.id.floatinloginbtn);
        emailedit = findViewById(R.id.email_edit);
        passwordedit = findViewById(R.id.passwordedit);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailtext = emailedit.getText().toString();
                String passswordtext = passwordedit.getText().toString();

                Snackbar.make(login,"email is \n "+emailtext,Snackbar.LENGTH_SHORT)
                        .setAction("Revers", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getApplicationContext(), "password is "+passswordtext, Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
    }
}