package com.example.firebaseconcept8am;

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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
EditText emailEdit,passwordEdit,numberedit,otpedit;
Button loginBtn,movetoRegister,submitnumber,submitotp;
FirebaseAuth firebaseAuth;
String phonenumber;
    private String verification_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectXml();
        firebaseAuth = FirebaseAuth.getInstance();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = emailEdit.getText().toString();
                String passwordText = passwordEdit.getText().toString();

                if(TextUtils.isEmpty(emailText))
                {
                    emailEdit.setError("Empty Email");

                }else if(TextUtils.isEmpty(passwordText))
                {
                   passwordEdit.setError("Password empty");
                }else
                {
                  loginUser(emailText,passwordText);
                }
            }
        });
        movetoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });
        submitnumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number_text = numberedit.getText().toString().trim();
                phonenumber = "+91"+number_text;


                PhoneAuthOptions options =
                        PhoneAuthOptions.newBuilder(firebaseAuth)
                                .setPhoneNumber(phonenumber)       // Phone number to verify
                                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                .setActivity(MainActivity.this)                 // Activity (for callback binding)
                                .setCallbacks(mCallbaake)          // OnVerificationStateChangedCallbacks
                                .build();
                PhoneAuthProvider.verifyPhoneNumber(options);
            }
        });
        submitotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otptext = otpedit.getText().toString();
                if(TextUtils.isEmpty(otptext))
                {
                    Toast.makeText(MainActivity.this, "please enter otp", Toast.LENGTH_SHORT).show();
                }else
                {
                    verficode(otptext);
                }
            }

        });
    }

    public PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbaake = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted( PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            verficode(code);
        }

        @Override
        public void onVerificationFailed( FirebaseException e) {

        }

        @Override
        public void onCodeSent( String s,  PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verification_code = s;

        }
    };

    private void verficode(String code) {
      PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(verification_code,code);

      verfiyuser(phoneAuthCredential);


    }

    private void verfiyuser(PhoneAuthCredential phoneAuthCredential) {
        firebaseAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete( Task<AuthResult> task) {
                if(task.isSuccessful())
                {

                    Toast.makeText(MainActivity.this, "Your phone number verified", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MainActivity.this, "error => "+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
//        FirebaseUser user = firebaseAuth.getCurrentUser();
//        if(user != null)
//        {
//            startActivity(new Intent(MainActivity.this,HomeActivity.class));
//            finish();
//        }
    }

    private void loginUser(String emailText, String passwordText) {
        firebaseAuth.signInWithEmailAndPassword(emailText,passwordText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "login successFull", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,HomeActivity.class));
                    finish();
                }else
                {
                    Toast.makeText(MainActivity.this, "Error "+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void connectXml() {
        emailEdit = findViewById(R.id.emailedit);
        passwordEdit = findViewById(R.id.passwordedit);
        loginBtn = findViewById(R.id.loginbtn);
        movetoRegister  = findViewById(R.id.moveregisterbtn);
        numberedit = findViewById(R.id.numberedit);
        otpedit = findViewById(R.id.otpedit);
        submitotp = findViewById(R.id.otpbttn);
        submitnumber = findViewById(R.id.sumbmitnumberbtn);
    }
}