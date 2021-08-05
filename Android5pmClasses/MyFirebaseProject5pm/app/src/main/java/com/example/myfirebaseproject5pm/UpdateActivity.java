package com.example.myfirebaseproject5pm;

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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class UpdateActivity extends AppCompatActivity {
     private  EditText emailedit,nameedit,passwordedit,numberedit;
  private   ProgressBar progressBar;
  private   Button registerbtn,delletbtn;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    String eamilvalue,numbervalue,namevalue,passwordvalue,useridvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        firebaseAuth = FirebaseAuth.getInstance();
        bindviews();
        getvalues();
        setvalue();
        delletbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                deleltefunciton();

            }

            private void deleltefunciton() {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("UserData").child(useridvalue);
                databaseReference.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            progressBar.setVisibility(View.GONE);
                            startActivity(new Intent(UpdateActivity.this,HomeActivity.class));
                            finish();
                        }else
                        {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(UpdateActivity.this, "error"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_text = emailedit.getText().toString();
                String name_text = nameedit.getText().toString();
                String number_text = numberedit.getText().toString();
                String password_text = passwordedit.getText().toString();
          progressBar.setVisibility(View.VISIBLE);
                insertdata(email_text,name_text,number_text,password_text);
            }
        });


    }

    private void insertdata(String email_text, String name_text, String number_text, String password_text) {
        databaseReference = FirebaseDatabase.getInstance().getReference("UserData").child(useridvalue);
        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("name",name_text);
        hashMap.put("email",email_text);
        hashMap.put("number",number_text);
        hashMap.put("password",password_text);
        databaseReference.updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(UpdateActivity.this, "Updated Success fully", Toast.LENGTH_SHORT).show();
                }else
                {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(UpdateActivity.this, "error "+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void setvalue() {
        emailedit.setText(eamilvalue);
        nameedit.setText(namevalue);
        numberedit.setText(numbervalue);
        passwordedit.setText(passwordvalue);

    }

    private void getvalues() {
        eamilvalue = getIntent().getStringExtra("email");
        namevalue = getIntent().getStringExtra("name");
        numbervalue = getIntent().getStringExtra("number");
        passwordvalue = getIntent().getStringExtra("password");
        useridvalue = getIntent().getStringExtra("userid");
    }

    private void bindviews() {
        progressBar = findViewById(R.id.progerbar_update);
        emailedit = findViewById(R.id.user_email_update);
        nameedit = findViewById(R.id.user_name_update);
        passwordedit = findViewById(R.id.user_password_update);
        numberedit = findViewById(R.id.user_number_update);
        registerbtn = findViewById(R.id.update_user_btn);
        delletbtn = findViewById(R.id.deletbtn_user_btn);
    }
}