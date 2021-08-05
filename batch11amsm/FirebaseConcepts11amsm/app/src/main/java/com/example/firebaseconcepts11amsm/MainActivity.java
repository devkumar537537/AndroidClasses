package com.example.firebaseconcepts11amsm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
EditText editemail,editpassword,editotp,editnumber;
Button loginbt,moveregister,submintnumber,submitotp;
FirebaseAuth firebaseAuth;
    String phonenumber;
    String verification_code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
connectcml();

        firebaseAuth = FirebaseAuth.getInstance();

        moveregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegisterUser.class));
            }
        });
        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emial_text = editemail.getText().toString().trim();
                String password_text = editpassword.getText().toString().trim();

                if(TextUtils.isEmpty(emial_text))
                {
                    editemail.setError("Empty Email");
                }else if(TextUtils.isEmpty(password_text))
                {
                    editpassword.setError("Empty password");
                }else
                {
                    login(emial_text,password_text);
                }
            }
        });

        submintnumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numbertext = editnumber.getText().toString().trim();//ccp
                phonenumber= "+91"+numbertext;

                PhoneAuthOptions options = PhoneAuthOptions.newBuilder(firebaseAuth)
                        .setPhoneNumber(phonenumber)
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(MainActivity.this)
                        .setCallbacks(mCallbacks)
                        .build();

                PhoneAuthProvider.verifyPhoneNumber(options);








            }
        });

        submitotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otptext = editotp.getText().toString().trim();
                verficode(otptext);
            }
        });
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted( PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            verficode(code);
        }

        @Override
        public void onVerificationFailed( FirebaseException e) {
            Toast.makeText(MainActivity.this, "error "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCodeSent( String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verification_code = s;
        }
    };

    private void verficode(String code) {
        PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(verification_code,code);
        signinwwithfirebase(phoneAuthCredential);
    }

    private void signinwwithfirebase(PhoneAuthCredential phoneAuthCredential) {
        firebaseAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete( Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "Number Verified", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MainActivity.this, "error "+task.getException(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void connectcml() {
        editemail = findViewById(R.id.emailedit);
        editpassword = findViewById(R.id.passwordedit);
        loginbt = findViewById(R.id.loginbtn);
        moveregister = findViewById(R.id.registerbtn);
        editnumber = findViewById(R.id.numberedit);
        editotp = findViewById(R.id.otpedit);
        submintnumber = findViewById(R.id.submitnumberbtn);
        submitotp = findViewById(R.id.submitOtp);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        if(firebaseAuth.getCurrentUser() != null)
//        {
//            startActivity(new Intent(MainActivity.this,HomeActivity.class));
//            finish();
//        }
    }

    private void login(String emial_text, String password_text) {
         firebaseAuth.signInWithEmailAndPassword(emial_text,password_text).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
             @Override
             public void onComplete( Task<AuthResult> task) {
               if(task.isSuccessful())
               {
                  startActivity(new Intent(MainActivity.this,HomeActivity.class));
                  finish();
               }else
               {
                   Toast.makeText(MainActivity.this, "error => "+task.getException(), Toast.LENGTH_SHORT).show();
               }
             }
         });
    }
}