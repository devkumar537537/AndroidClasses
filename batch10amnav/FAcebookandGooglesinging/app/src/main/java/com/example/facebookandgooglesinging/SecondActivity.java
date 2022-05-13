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
public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "GoogleActivity";
    private static final int RC_SIGN_IN = 9001;
    GoogleSignInAccount  account ;
    // [START declare_auth]

    // [END declare_auth]
    SignInButton signInButton;
    TextView statuse,uid;
    ImageView profileimage;
    Button signout,disconnextbtn;
   private GoogleSignInClient googleSignInClient;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        connectxml();
        firebaseAuth = FirebaseAuth.getInstance();

        GoogleSignInOptions  gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("369341452315-sge22thjubc60uhmfhaiipqp5ueqv469.apps.googleusercontent.com")
                .requestEmail()
                .build();
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
//
//        signInButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = mGoogleSignInClient.getSignInIntent();
//                startActivityForResult(intent,RC_SIGN_IN);
//            }
//        });

        googleSignInClient = GoogleSignIn.getClient(this,gso);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = googleSignInClient.getSignInIntent();
                startActivityForResult(intent,RC_SIGN_IN);
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
    private void connectxml() {
        signInButton=findViewById(R.id.googlesinginbutn);
        statuse = findViewById(R.id.userstatus);
        uid = findViewById(R.id.userdetail);
        profileimage = findViewById(R.id.userprofiel);
        signout = findViewById(R.id.signoutbtn);
        disconnextbtn = findViewById(R.id.disconnextbtn);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode== RC_SIGN_IN  && data !=null)
        {

         //   Toast.makeText(getApplicationContext(), "error "+data.getExtras(), Toast.LENGTH_SHORT).show();
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

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
        AuthCredential googleauthcrediatl = GoogleAuthProvider.getCredential(idToken,null);
firebaseAuth.signInWithCredential(googleauthcrediatl).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(task.isSuccessful())
        {
            Toast.makeText(SecondActivity.this, "LogIn Success full", Toast.LENGTH_SHORT).show();
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    updateUI(user);
        }else
        {
            Toast.makeText(SecondActivity.this, "error "+task.getException(), Toast.LENGTH_SHORT).show();
//                    Toast.makeText(MainActivity.this, "error"+task.getException(), Toast.LENGTH_SHORT).show();
                  updateUI(null);
        }
    }
});



    }
}