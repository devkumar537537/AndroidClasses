package com.example.firebaseconcept;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
Button login,movetoregister,submitotp,submitnumber;
EditText emailedit,passwordedit,otpedit,numbereidt;
FirebaseAuth firebaseAuth;
    private String verification_code;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connect();
        if(getIntent() != null  && getIntent().hasExtra("title")){

            for(String key: getIntent().getExtras().keySet())
            {
                Log.e(TAG, "onCreate: key :  "+key+" data is " + getIntent().getExtras().getString(key) );
//                textView.append(getIntent().getExtras().getString(key) + "\n");
            }
        }
        movetoregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });
      firebaseAuth = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtext =emailedit.getText().toString().trim();
                String passwordtext = passwordedit.getText().toString().trim();

                if(TextUtils.isEmpty(emailtext))
                {
                    emailedit.setError("empty email");
                }else if(TextUtils.isEmpty(passwordtext))
                {
                    passwordedit.setError("empty password");
                }else
                {
                    loginuser(emailtext,passwordtext);
                }
            }
        });

        submitnumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
      String number = numbereidt.getText().toString().trim();
      String numberwithcode ="+91"+number;

                PhoneAuthOptions phoneAuthOptions = PhoneAuthOptions.newBuilder(firebaseAuth)
                        .setPhoneNumber(numberwithcode)
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(MainActivity.this)
                        .setCallbacks(mCallbacks)
                        .build();
                PhoneAuthProvider.verifyPhoneNumber(phoneAuthOptions);
            }
        });


        submitotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
String otptext = otpedit.getText().toString();
verficode(otptext);
            }
        });
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted( PhoneAuthCredential phoneAuthCredential) {
            String otptext = phoneAuthCredential.getSmsCode();
            verficode(otptext);
        }

        @Override
        public void onVerificationFailed( FirebaseException e) {
            Toast.makeText(MainActivity.this, "error "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCodeSent( String s,  PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verification_code = s;
        }
    };

    private void verficode(String otptext) {

PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(verification_code,otptext);
signinwithcrediatial(phoneAuthCredential);
    }

    private void signinwithcrediatial(PhoneAuthCredential phoneAuthCredential) {
        firebaseAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete( Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "Your number verified", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MainActivity.this, "otp or number is wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void connect() {
        login = findViewById(R.id.loginbtn);
        emailedit = findViewById(R.id.emailedit);
        passwordedit = findViewById(R.id.passwordedit);
        movetoregister = findViewById(R.id.registerbtn);
        submitnumber = findViewById(R.id.submitnumberbtn);
        submitotp = findViewById(R.id.submitotpbtn);
        otpedit = findViewById(R.id.otpedit);
        numbereidt = findViewById(R.id.numberedit);
    }

    private void loginuser(String emailtext, String passwordtext) {
firebaseAuth.signInWithEmailAndPassword(emailtext,passwordtext).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete( Task<AuthResult> task) {
        if(task.isSuccessful())
        {
            Toast.makeText(MainActivity.this, "Login successfull", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,HomeActivity.class));
            finish();
        }else
        {
            Toast.makeText(MainActivity.this, "error "+task.getException(), Toast.LENGTH_SHORT).show();
        }
    }
});
    }

    @Override
    protected void onStart() {
        super.onStart();
//        if(firebaseAuth.getCurrentUser() != null)
//        {
//            startActivity(new Intent(MainActivity.this,HomeActivity.class));
//          finish();
//        }
    }
}