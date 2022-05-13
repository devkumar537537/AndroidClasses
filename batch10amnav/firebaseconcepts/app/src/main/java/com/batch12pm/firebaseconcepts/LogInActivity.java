package com.batch12pm.firebaseconcepts;

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
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LogInActivity extends AppCompatActivity {
EditText email,password,numberedit,otpedit;
Button login,movetoregister,submitnumber,submintotp;
FirebaseAuth firebaseAuth;
String phonenumber;
String verification_code;
ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
            connecttion();
        firebaseAuth = FirebaseAuth.getInstance();
        submitnumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String number = numberedit.getText().toString().trim();
                  phonenumber = "+91"+number;

                PhoneAuthOptions options =
                        PhoneAuthOptions.newBuilder(firebaseAuth)
                                .setPhoneNumber(phonenumber)       // Phone number to verify
                                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                .setActivity(LogInActivity.this)                 // Activity (for callback binding)
                                .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                                .build();

                PhoneAuthProvider.verifyPhoneNumber(options);
            }
        });
submintotp.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String opttext = otpedit.getText().toString().trim();

        verficode(opttext);
    }
});

        movetoregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogInActivity.this,RegisterActivity.class));
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                String emailtext = email.getText().toString().trim();
                String passwordtext = password.getText().toString().trim();

                firebaseAuth.signInWithEmailAndPassword(emailtext,passwordtext).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(), "you are authenticated", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LogInActivity.this,HomeActivity.class);
                            startActivity(intent);

                        }else
                        {
                            Toast.makeText(getApplicationContext(), "error "+task.getException(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });
    }


    private  PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            progressBar.setVisibility(View.GONE);
                String code = phoneAuthCredential.getSmsCode();
                verficode(code);
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(getApplicationContext(), "error "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verification_code = s;
        }
    };

    private void verficode(String code) {

        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verification_code,code);
        singinwithcredention(credential);
    }

    private void singinwithcredention(PhoneAuthCredential credential) {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "Phone number verified", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(getApplicationContext(), "error "+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(firebaseAuth.getCurrentUser() != null)
        {
            Intent intent = new Intent(LogInActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }
      private  void connecttion()
      {
          login = findViewById(R.id.login);
          email = findViewById(R.id.emailedit);
          password = findViewById(R.id.passwordedit);
          movetoregister = findViewById(R.id.movetorgetiser);
          submitnumber = findViewById(R.id.submitnumber);
          submintotp = findViewById(R.id.submitotp);
          numberedit = findViewById(R.id.numberlayout);
          otpedit = findViewById(R.id.otplayout);
          progressBar = findViewById(R.id.progressbar);
      }
}