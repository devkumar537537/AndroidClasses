package com.example.myfirebaseproject5pm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

import org.w3c.dom.Text;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
EditText emailedit,nameedit,passwordedit,numberedit;
ProgressBar progressBar;
Button registerbtn;
FirebaseAuth firebaseAuth;
DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        bindviews();
        firebaseAuth = FirebaseAuth.getInstance();

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(TextUtils.isEmpty(email_text))
                {
                    Toast.makeText(RegisterActivity.this, "Enter your email", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(name_text))
                {
                    Toast.makeText(RegisterActivity.this, "Enter Your name", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(numbetr_text))
                {
                    Toast.makeText(RegisterActivity.this, "Enter your number", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(password_text))
                {
                    Toast.makeText(RegisterActivity.this, "Enter Your password", Toast.LENGTH_SHORT).show();
                }else
                {
                    progressBar.setVisibility(View.VISIBLE);
                    cretatuser(email_text,name_text,numbetr_text,password_text);
                }
            }
        });

    }

    private void cretatuser(String email_text, String name_text, String numbetr_text, String password_text) {
        firebaseAuth.createUserWithEmailAndPassword(email_text,password_text).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    String userid = firebaseAuth.getCurrentUser().getUid();
                    databaseReference = FirebaseDatabase.getInstance().getReference("UserData").child(userid);
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("name",name_text);
                    hashMap.put("email",email_text);
                    hashMap.put("number",numbetr_text);
                    hashMap.put("password",password_text);
                    hashMap.put("userId",userid);


                    databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(RegisterActivity.this, "Your are register successfully", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(RegisterActivity.this,HomeActivity.class));
                           finish();

                            }else
                            {
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(RegisterActivity.this, "Try Again For Register", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                                finish();
                            }
                        }
                    });
                }else
                {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(RegisterActivity.this, "create errro: "+task.getException(), Toast.LENGTH_SHORT).show();
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