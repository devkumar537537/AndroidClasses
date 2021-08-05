package com.example.typesadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class MaterialDesignExamples extends AppCompatActivity {
TextInputEditText emailedit,passwordedit;
ExtendedFloatingActionButton loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design_examples);

        emailedit = findViewById(R.id.email_edit);
        passwordedit = findViewById(R.id.password_edit);
        loginbtn = findViewById(R.id.loginbtnn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_text = emailedit.getText().toString().trim();
                String password_text = passwordedit.getText().toString().trim();

                Snackbar.make(loginbtn,"email => "+email_text+"\n  password => "+password_text+"\n",Snackbar.LENGTH_LONG)
                        .setAction("Perform", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getApplicationContext(),"This is snackbar example",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setBackgroundTint(getResources().getColor(R.color.snacbar_color,null))
                        .show();


            }
        });
    }
}