package com.example.authenticatio5pm;

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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "GoogleActivity";
    private static final int RC_SIGN_IN = 9001;

    // [START declare_auth]
    FirebaseAuth mAuth;
    // [END declare_auth]
    SignInButton signInButton;
    TextView statuse,uid;
    ImageView profileimage;
    Button signout,disconnextbtn,facebooksigninmove;
    private GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connextxml();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)

                .requestIdToken("157370499047-22kmirvk671o8cg7igkukj6ke1mdr1ce.apps.googleusercontent.com")
                .requestEmail()
                .build();
        facebooksigninmove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Facebooklogin.class));
            }
        });
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        mAuth = FirebaseAuth.getInstance();

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(intent,RC_SIGN_IN);
            }
        });
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();

                mGoogleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete( Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this, "you signout", Toast.LENGTH_SHORT).show();
                            updateUI(mAuth.getCurrentUser());
                        }
                    }
                });
            }
        });

    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            statuse.setText("useremail =>"+user.getEmail());
            uid.setText("username =>"+user.getDisplayName());

            String url = user.getPhotoUrl().toString();
            Glide.with(getApplicationContext()).load(url).into(profileimage);
            signInButton.setVisibility(View.GONE);
            signout.setVisibility(View.VISIBLE);
            disconnextbtn.setVisibility(View.VISIBLE);
        } else {
            statuse.setText("user is not signin");
            uid.setText("null");
            profileimage.setImageResource(R.drawable.ic_launcher_background);
            signInButton.setVisibility(View.VISIBLE);
            signout.setVisibility(View.GONE);
            disconnextbtn.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_SIGN_IN)
        {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            GoogleSignInAccount account = null;
            try {
                account = task.getResult(ApiException.class);
            } catch (ApiException e) {
                e.printStackTrace();

                Log.w(TAG, "Google sign in failed", e);
                // [START_EXCLUDE]
                updateUI(null);
            }
            Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
            firebaseAuthWithGoogle(account.getIdToken());
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential googleAuthCredential = GoogleAuthProvider.getCredential(idToken,null);
        mAuth.signInWithCredential(googleAuthCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete( Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Log.d(TAG, "signInWithCredential:success");
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);
                }else {
                    Log.w(TAG, "signInWithCredential:failure", task.getException());
                    Toast.makeText(MainActivity.this, "error"+task.getException(), Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
            }
        });
    }

    private void connextxml() {
        signInButton=findViewById(R.id.sign_in_button);
        statuse = findViewById(R.id.userstatus);
        uid = findViewById(R.id.userdetail);
        profileimage = findViewById(R.id.userprofiel);
        signout = findViewById(R.id.signoutbtn);
        disconnextbtn = findViewById(R.id.disconnextbtn);
        facebooksigninmove = findViewById(R.id.movetofacebooksignin);
    }

}