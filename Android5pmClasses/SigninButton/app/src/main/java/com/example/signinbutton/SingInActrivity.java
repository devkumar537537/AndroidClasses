package com.example.signinbutton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class SingInActrivity extends AppCompatActivity {

    SignInButton signInButton;
    GoogleSignInClient googleSignInClient;
    GoogleSignInOptions googleSignInOptions;
    int GOOGLE_SIGN_IN_CODE = 123;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in_actrivity);

        signInButton = findViewById(R.id.google_sign_inbtn);
        firebaseAuth = FirebaseAuth.getInstance();

        googleSignInOptions =new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this,googleSignInOptions);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singInGoogle();
            }
        });
    }

    private void singInGoogle() {

        Intent sigininginten = googleSignInClient.getSignInIntent();
        startActivityForResult(sigininginten,GOOGLE_SIGN_IN_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GOOGLE_SIGN_IN_CODE)
        {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handletask(task);
        }
    }

    private void handletask(Task<GoogleSignInAccount> task) {

        try {
            GoogleSignInAccount googleSignInAccount = task.getResult(ApiException.class);
            firebaseauthewithgoogleclient(googleSignInAccount.getIdToken());
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    private void firebaseauthewithgoogleclient(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken,null);
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    startActivity(new Intent(SingInActrivity.this,MainActivity.class));
                    finish();
                }else
                {
                    Toast.makeText(SingInActrivity.this, "erroro"+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}