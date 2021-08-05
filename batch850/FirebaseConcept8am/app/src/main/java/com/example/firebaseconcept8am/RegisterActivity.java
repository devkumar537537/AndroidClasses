package com.example.firebaseconcept8am;

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
        databaseReference = FirebaseDatabase.getInstance().getReference("User8amdata");
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_text = emailedit.getText().toString();
                String name_text = nameedit.getText().toString();
                String numbetr_text = numberedit.getText().toString();
                String password_text = passwordedit.getText().toString();
                if(TextUtils.isEmpty(email_text))
                {
                    emailedit.setError("Empty Email");

                }else if(TextUtils.isEmpty(name_text))
                {
                  nameedit.setError("Empty Name");
                }else if(TextUtils.isEmpty(numbetr_text))
                {
                  numberedit.setError("Empty Number");
                }else if(TextUtils.isEmpty(password_text))
                {
                   passwordedit.setError("Empty password");
                }else
                {
                    progressBar.setVisibility(View.VISIBLE);
                    createUser(email_text,numbetr_text,password_text,name_text);
                }

            }
        });

    }

private void createUser(String emailText,String numberText,String passwordText,String userName){
    firebaseAuth.createUserWithEmailAndPassword(emailText,passwordText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete( Task<AuthResult> task) {
         if(task.isSuccessful())
         {

             //insert infromation
             String userid = firebaseAuth.getCurrentUser().getUid();

             HashMap<String,String> usermap = new HashMap<>();
             usermap.put("email",emailText);
             usermap.put("password",passwordText);
             usermap.put("number",numberText);
             usermap.put("name",userName);
             usermap.put("userid",userid);
             usermap.put("imageurl","default");

             databaseReference.child(userid).setValue(usermap).addOnCompleteListener(new OnCompleteListener<Void>() {
                 @Override
                 public void onComplete( Task<Void> task) {
                     if(task.isSuccessful())
                     {
                         progressBar.setVisibility(View.GONE);
                         startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                         finish();
                     }else
                     {
                         progressBar.setVisibility(View.GONE);
                         Toast.makeText(RegisterActivity.this, "error "+task.getException(), Toast.LENGTH_SHORT).show();
                     }
                 }
             });



         }else
         {
             progressBar.setVisibility(View.GONE);
             Toast.makeText(RegisterActivity.this, "error "+task.getException(), Toast.LENGTH_SHORT).show();
         }
        }
    })  ;
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