package com.example.firebaseconcepts11amsm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterUser extends AppCompatActivity {
    EditText emailedit,nameedit,passwordedit,numberedit;
    ProgressBar progressBar;
    Button registerbtn;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        bindviews();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("UserData");

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtext = emailedit.getText().toString().trim();
                String nametext = nameedit.getText().toString().trim();
                String passwordtext = passwordedit.getText().toString().trim();
                String numbertext = numberedit.getText().toString().trim();

                registerusre(emailtext,nametext,passwordtext,numbertext);
            }
        });
    }

    private void registerusre(String emailtext, String nametext, String passwordtext, String numbertext) {

        firebaseAuth.createUserWithEmailAndPassword(emailtext,passwordtext).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                   String userid = firebaseAuth.getCurrentUser().getUid();

                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("userEamil",emailtext);
                    hashMap.put("userName",nametext);
                    hashMap.put("userPassword",passwordtext);
                    hashMap.put("userNumber",numbertext);
                    hashMap.put("uderId",userid);
                    hashMap.put("imageurl","default");

                    databaseReference.child(userid).setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete( Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Intent intent = new Intent(RegisterUser.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                            }else
                            {
                                Toast.makeText(RegisterUser.this, "error "+task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });



                }else {
                    Toast.makeText(RegisterUser.this, "error => "+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void bindviews() {
        progressBar = findViewById(R.id.progerbar_register);
        emailedit = findViewById(R.id.user_email_register);
        nameedit = findViewById(R.id.user_name_register);
        passwordedit = findViewById(R.id.user_password_register);
        numberedit = findViewById(R.id.user_number_register);
        registerbtn = findViewById(R.id.register_user_btn);
    }
}