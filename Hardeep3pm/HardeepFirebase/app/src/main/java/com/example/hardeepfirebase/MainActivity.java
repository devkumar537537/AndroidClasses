package com.example.hardeepfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
EditText emailedit,passwordedit;
Button loginbtn,registermove;
FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

  firebaseAuth = FirebaseAuth.getInstance();
registermove = findViewById(R.id.registermove);
registermove.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this,Regsiteruser.class));
    }
});

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String emailt_text = emailedit.getText().toString();
             String passwordtext = passwordedit.getText().toString();
firebaseAuth.signInWithEmailAndPassword(emailt_text,passwordtext).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(task.isSuccessful())
        {
            startActivity(new Intent(MainActivity.this,HomeActivity.class));

            Toast.makeText(MainActivity.this, "You are logged In", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(MainActivity.this, "error "+task.getException(), Toast.LENGTH_SHORT).show();
        }
    }
});


            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
//        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
//        if(firebaseUser != null)
//        {
//             startActivity(new Intent(MainActivity.this,HomeActivity.class));
//        }
    }
    private void connectxml()
    {
        otpedit = findViewById(R.id.otpeditext);
        numberedit = findViewById(R.id.usernumber);
        submintnumber = findViewById(R.id.submintnumber);
        otpsubmit = findViewById(R.id.submitotp);
        emailedit = findViewById(R.id.email);
        passwordedit = findViewById(R.id.password);
        loginbtn = findViewById(R.id.login);
    }
}