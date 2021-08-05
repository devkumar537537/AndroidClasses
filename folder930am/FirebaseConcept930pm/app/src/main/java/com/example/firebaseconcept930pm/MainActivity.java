package com.example.firebaseconcept930pm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.firebaseconcept930pm.helper.SqliteHelpterClass;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;

import java.util.concurrent.TimeUnit;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {
EditText emaillayout,passwordlayout,numberedit,otpedit;
Button logoin,signupbtn,numberbtn,otpbtn;
FirebaseAuth firebaseAuth;
String phonenumber;
String verification_code;
TextView notifiondata;
SqliteHelpterClass sqliteHelpterClass;
String title;
String date;
String body;


    private static final String TAG = "GoogleActivity";
    private static final int RC_SIGN_IN = 9001;

    // [START declare_auth]

    // [END declare_auth]
    SignInButton signInButton;
    TextView statuse,uid;
    ImageView profileimage;
    Button signout,disconnextbtn,facebooksigninmove;
    private GoogleSignInClient mGoogleSignInClient;


    //face book resource
    LoginButton loginButton;
    CallbackManager callbackManager;


    ImageView profileimageface;
    TextView email,name,id;
    Button signoutbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqliteHelpterClass = new SqliteHelpterClass(this);
        firebaseAuth =  FirebaseAuth.getInstance();
        connextcml();
        loginButton.setReadPermissions("email", "public_profile");
        callbackManager = CallbackManager.Factory.create();
notifiondata = findViewById(R.id.notificationdata);
     signupbtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             startActivity(new Intent(MainActivity.this,RegisterPage.class));
         }
     });
        logoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailt_text = emaillayout.getText().toString().trim();
                String passwort_text = passwordlayout.getText().toString().trim();
                if(emailt_text.isEmpty())
                {
                    emaillayout.setError("Empty email");

                }else if(passwort_text.isEmpty())
                {
                    passwordlayout.setError("Empty password");

                }else
                {
                    lgoineuser(emailt_text,passwort_text);
                }
            }
        });
        numberbtn.setOnClickListener(new View.OnClickListener() {
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
        otpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otptext = otpedit.getText().toString().trim();

                verficode(otptext);
            }
        });

        if(getIntent() != null  && getIntent().hasExtra("title")){
        StringBuilder stringBuilder = new StringBuilder();
            for(String key: getIntent().getExtras().keySet())
            {
                if(key.equals("title"))
                {
                    title = getIntent().getExtras().getString(key);
                }else if(key.equals("date"))
                {
                    date = getIntent().getExtras().getString(key);
                }else if(key.equals("body"))
                {
                    body = getIntent().getExtras().getString(key);
                }
                Log.e(TAG, "onCreate: key :  "+key+" data is " + getIntent().getExtras().getString(key) );
                stringBuilder.append(getIntent().getExtras().getString(key) + "\n");
            }
            sqliteHelpterClass.insertdata(title,date,body);
            notifiondata.append(stringBuilder.toString());
        }

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(MainActivity.this, "reslult "+loginResult, Toast.LENGTH_SHORT).show();
                handfacboologinwithfirebase(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
                Toast.makeText(MainActivity.this, "user cancleed logoin", Toast.LENGTH_SHORT).show();
                updatefacebookUI(null);
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError"+ error);
                Toast.makeText(MainActivity.this, "reslult "+error, Toast.LENGTH_SHORT).show();
                updatefacebookUI(null);
            }
        });
    }

    private void updatefacebookUI(FirebaseUser user) {

        if (user != null) {
            name.setText(user.getDisplayName());
            email.setText(user.getEmail());
            id.setText(user.getUid());

            String imageure = user.getPhotoUrl().toString();
            if(user.getPhotoUrl().toString() == null)
            {
                Toast.makeText(this, "There is no url in image", Toast.LENGTH_SHORT).show();
            }else
            {
                Glide.with(getApplicationContext()).load(imageure).into(profileimage);
            }



            loginButton.setVisibility(View.GONE);
            signoutbtn.setVisibility(View.VISIBLE);
        } else {


            loginButton.setVisibility(View.VISIBLE);
            signoutbtn.setVisibility(View.GONE);
        }
    }

    private void handfacboologinwithfirebase(AccessToken accessToken) {
        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user =  firebaseAuth.getCurrentUser();
                            updatefacebookUI(user);
                        } else {

                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updatefacebookUI(null);
                        }


                    }
                });
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbaake =new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

    @Override
    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
        String code = phoneAuthCredential.getSmsCode();
     verficode(code);
  }

    @Override
    public void onVerificationFailed(@NonNull FirebaseException e) {

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


        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "NumberVerified", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MainActivity.this, "error "+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void lgoineuser(String emailt_text, String passwort_text) {
        firebaseAuth.signInWithEmailAndPassword(emailt_text,passwort_text).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "You are authenticated", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,HomeActivity.class));
                    finish();
                }else
                {
                    Toast.makeText(MainActivity.this, "error "+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void connextcml() {
        emaillayout = findViewById(R.id.emaillayout);
        passwordlayout = findViewById(R.id.passwordlayout);
        signupbtn = findViewById(R.id.registemove);
        logoin = findViewById(R.id.login);
        numberbtn = findViewById(R.id.submitnumber);
        otpbtn = findViewById(R.id.submitotp);
        numberedit = findViewById(R.id.enternumber);
        otpedit = findViewById(R.id.otpedti);
        signInButton=findViewById(R.id.sign_in_button);
        statuse = findViewById(R.id.userstatus);
        uid = findViewById(R.id.userdetail);
        profileimage = findViewById(R.id.userprofiel);
        signout = findViewById(R.id.signoutbtn);
        disconnextbtn = findViewById(R.id.disconnextbtn);

        loginButton = findViewById(R.id.login_button);
        profileimage = findViewById(R.id.profileImage);
        email =findViewById(R.id.email);
        name = findViewById(R.id.name);
        id = findViewById(R.id.userId);
        signoutbtn = findViewById(R.id.facesignout);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN && resultCode == Activity.RESULT_OK && data != null) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // [START_EXCLUDE]
                updateUI(null);
                // [END_EXCLUDE]
            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);

        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success");
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    updateUI(user);
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.getException());
                    Toast.makeText(MainActivity.this, "error"+task.getException(), Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
            }
        });
    }

    private void updateUI(FirebaseUser user) {

        if (user != null) {
            statuse.setText("useremail =>"+user.getEmail());
            uid.setText("userid =>"+user.getDisplayName());

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
}