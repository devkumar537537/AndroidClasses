package com.example.facebookandgooglesinging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ImageView profileimage;
    TextView email,name,id;
    Button signoutbtn;
    Button loginButton;
    CallbackManager callbackManager;
    FirebaseAuth firebaseAuth;
    private static final String TAG = "ProfileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectxml();

        firebaseAuth = FirebaseAuth.getInstance();

        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                        Log.d(TAG, "facebook:onSuccess:" + loginResult);
                        handfacboologinwithfirebase(loginResult.getAccessToken());
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getApplicationContext(), "User cancled login", Toast.LENGTH_SHORT).show();
                updateUI(null);
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(getApplicationContext(), "error "+exception.getMessage(), Toast.LENGTH_SHORT).show();

              updateUI(null);
                    }
                });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logInWithReadPermissions(MainActivity.this, Arrays.asList("public_profile"));

            }
        });
signoutbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        firebaseAuth.signOut();
        LoginManager.getInstance().logOut();

        updateUI(null);
    }
});
    }

    private void handfacboologinwithfirebase(AccessToken accessToken) {

        AuthCredential authCredential = FacebookAuthProvider.getCredential(accessToken.getToken());
        firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "login successfull", Toast.LENGTH_SHORT).show();
                    FirebaseUser user =  firebaseAuth.getCurrentUser();
                    updateUI(user);
                }else
                {
                    Toast.makeText(getApplicationContext(), "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
            }
        });

    }


    private void updateUI(FirebaseUser user)
    {
        if(user != null)
        {
            name.setText(user.getDisplayName());
            email.setText(user.getEmail());
            id.setText(user.getUid());


            if(user.getPhotoUrl() == null)
            {

                Toast.makeText(this, "There is no url in image", Toast.LENGTH_SHORT).show();
            }else
            {
                String imageure = user.getPhotoUrl().toString();
                Glide.with(getApplicationContext()).load(imageure).into(profileimage);
            }



            loginButton.setVisibility(View.GONE);
            signoutbtn.setVisibility(View.VISIBLE);
        }else
        {
            name.setText("NO name");
            email.setText("NO email");
            id.setText("no id");

profileimage.setImageResource(R.drawable.ic_launcher_background);

                Toast.makeText(this, "There is no url in image", Toast.LENGTH_SHORT).show();




            loginButton.setVisibility(View.VISIBLE);
            signoutbtn.setVisibility(View.GONE);
        }

    }
    private void connectxml() {

        loginButton = findViewById(R.id.facebookbtn);
        profileimage = findViewById(R.id.profileImage);
        email =findViewById(R.id.email);
        name = findViewById(R.id.name);
        id = findViewById(R.id.userId);
        signoutbtn = findViewById(R.id.facesignout);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}