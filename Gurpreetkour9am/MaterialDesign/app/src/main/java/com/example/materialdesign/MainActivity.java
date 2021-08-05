package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
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
        emailedit = findViewById(R.id.email_edit);
        passwordedit = findViewById(R.id.password_edit);
        loginbtn = findViewById(R.id.logintbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtext = emailedit.getText().toString().trim();
                String passwordtext = passwordedit.getText().toString().trim();
                Snackbar.make(loginbtn,"myemail"+emailtext,Snackbar.LENGTH_LONG)
                        .setAction("show", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast toast = new Toast(getApplicationContext());
                                LayoutInflater layoutInflater =(LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                View view = layoutInflater.inflate(R.layout.customtoast,null);
                                TextView emailview = view.findViewById(R.id.emailview);


                                emailview.setText(passwordtext);
                                toast.setView(view);
                                toast.setGravity(Gravity.CENTER_HORIZONTAL,100,200);
                                toast.setDuration(Toast.LENGTH_LONG);
                                toast.show();
                            }
                        }).show();



            }
        });
    }
}