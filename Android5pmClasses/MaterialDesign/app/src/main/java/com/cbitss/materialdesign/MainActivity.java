package com.cbitss.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText emaildit,passwordedit;
RelativeLayout loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emaildit = findViewById(R.id.email);
        passwordedit = findViewById(R.id.password);
        loginbtn = findViewById(R.id.logint_btn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_text = emaildit.getText().toString();
                String password_text = passwordedit.getText().toString();

                Toast.makeText(MainActivity.this, "email is : "+email_text+" and password is "+password_text, Toast.LENGTH_SHORT).show();
            }
        });

    }
}