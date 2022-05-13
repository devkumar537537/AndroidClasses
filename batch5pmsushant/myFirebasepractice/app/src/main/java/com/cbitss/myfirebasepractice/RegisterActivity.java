package com.cbitss.myfirebasepractice;

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
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    EditText numberedit,emailedit,passwordedit,namedit;
    Button signupbtn;
    ProgressBar registerbar;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        connectml();
        firebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailtext = emailedit.getText().toString().trim();
                String passorttext = passwordedit.getText().toString().trim();
                String name_text = namedit.getText().toString().trim();
                String numbert_text = numberedit.getText().toString().trim();
                if(TextUtils.isEmpty(emailtext))
                {
                    emailedit.setError("Empty Email");
                }else if(TextUtils.isEmpty(passorttext))
                {
                    passwordedit.setError("Empty password");
                }else if(TextUtils.isEmpty(name_text))
                {
                    namedit.setError("Empty name");
                }else if(TextUtils.isEmpty(numbert_text))
                {
                    numberedit.setError("Empty number");
                }else
                {
                    registerbar.setVisibility(View.VISIBLE);
                    createuser(emailtext,passorttext,numbert_text,name_text);
                }
            }
        });
    }

    private void createuser(String emailtext, String passorttext, String numbert_text, String name_text) {
        firebaseAuth.createUserWithEmailAndPassword(emailtext,passorttext).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    String uniqueid= firebaseAuth.getCurrentUser().getUid();

                    HashMap<String,String> userdata = new HashMap<>();

                    userdata.put("userEmail",emailtext);
                    userdata.put("userPassword",passorttext);
                    userdata.put("userNumber",numbert_text);
                    userdata.put("userName",name_text);
                    userdata.put("userId",uniqueid);

                    db.collection("AllUser").document(uniqueid).set(userdata).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    registerbar.setVisibility(View.GONE);
                                    Toast.makeText(RegisterActivity.this, "You registered Successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(RegisterActivity.this,HomeActivity.class));
                                     finish();

                                }else
                                {
                                    registerbar.setVisibility(View.GONE);
                                    Toast.makeText(RegisterActivity.this, "error "+task.getException(), Toast.LENGTH_SHORT).show();
                                }
                        }
                    });
                }else{
                    registerbar.setVisibility(View.GONE);
                    Toast.makeText(RegisterActivity.this, "error "+task.getException(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void connectml() {
        numberedit = findViewById(R.id.numberlayoutregister);
        emailedit = findViewById(R.id.emailayoutregister);
        passwordedit = findViewById(R.id.passwordlayotlayoutregister);
        namedit = findViewById(R.id.namelayoutregister);
        signupbtn = findViewById(R.id.signuptbtn);
        registerbar = findViewById(R.id.registerprogress);
    }
}