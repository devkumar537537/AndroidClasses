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
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
EditText emailedit,passwordedit,numberedit,otpedit;
Button submintbtn,registermovebtn,subtinnumberbtn,submitotpbtn,openanumberdirectionbtn;
FirebaseAuth firebaseAuth;
ProgressBar progressBar;
String verification_code;
String phnenumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        bindviews();

        openanumberdirectionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openanumberdirectionbtn.setVisibility(View.GONE);
                numberedit.setVisibility(View.VISIBLE);
                otpedit.setVisibility(View.VISIBLE);
                subtinnumberbtn.setVisibility(View.VISIBLE);
                submitotpbtn.setVisibility(View.VISIBLE);
            }
        });
        subtinnumberbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numbertext = numberedit.getText().toString().trim();
                phnenumber = "+91"+numbertext;
                if(TextUtils.isEmpty(numbertext))
                {
                    Toast.makeText(getApplicationContext(),"please enter numbert",Toast.LENGTH_LONG).show();
                }else
                {
                    progressBar.setVisibility(View.VISIBLE);
                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            phnenumber,
                            60,
                            TimeUnit.SECONDS,
                            TaskExecutors.MAIN_THREAD,
                            mCallbaake
                    );
                }

            }
        });
        submitotpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp_text = otpedit.getText().toString().trim();
                if(TextUtils.isEmpty(otp_text))
                {
                    Toast.makeText(MainActivity.this, "please provide otp", Toast.LENGTH_SHORT).show();
                }else{
                    progressBar.setVisibility(View.VISIBLE);
                    verfiycode(otp_text);
                }
            }
        });

        registermovebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });
        submintbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_text = emailedit.getText().toString();
                String password_text = passwordedit.getText().toString();

                if(TextUtils.isEmpty(email_text))
                {
                    Toast.makeText(MainActivity.this, "Enter your email", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(password_text))
                {
                    Toast.makeText(MainActivity.this, "Enter Your password", Toast.LENGTH_SHORT).show();
                }else
                {
                    progressBar.setVisibility(View.VISIBLE);
                    authenticateuser(email_text,password_text);
                }
            }
        });
    }

    private  PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbaake = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            verfiycode(code);
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(MainActivity.this, "error "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verification_code = s;
        }
    };

    private void verfiycode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verification_code,code);
        signinWithNumbercreditenls(credential);

    }

    private void signinWithNumbercreditenls(PhoneAuthCredential credential) {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Your are verfied", Toast.LENGTH_SHORT).show();
                }else
                {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Verification failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void authenticateuser(String email_text, String password_text) {

        firebaseAuth.signInWithEmailAndPassword(email_text,password_text).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Your are authenticatted", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,HomeActivity.class));

                }else
                {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "error: "+task.getException(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,RegisterActivity.class));
                }
            }
        });

    }


    private void bindviews() {
        emailedit = findViewById(R.id.user_email);
        passwordedit = findViewById(R.id.user_password);
        progressBar = findViewById(R.id.progerbar);
        submintbtn = findViewById(R.id.login_user_btn);
        registermovebtn = findViewById(R.id.register_move_btn);
        numberedit = findViewById(R.id.user_number_otp);
        otpedit = findViewById(R.id.user_otp);

        subtinnumberbtn = findViewById(R.id.submint_number_btn);
        submitotpbtn = findViewById(R.id.submit_opt_btn);
        openanumberdirectionbtn = findViewById(R.id.login_with_number);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(firebaseAuth.getCurrentUser() != null){
            startActivity(new Intent(MainActivity.this,HomeActivity.class));
        }
    }
}