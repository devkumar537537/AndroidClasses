package com.example.facebookandgooglesinginkotlin

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener

class SecondActivity : AppCompatActivity() {
    var account: GoogleSignInAccount? = null

    // [START declare_auth]
    // [END declare_auth]
    var signInButton: SignInButton? = null
    var statuse: TextView? = null
    var uid: TextView? = null
    var profileimage: ImageView? = null
    var signout: Button? = null
    var disconnextbtn: Button? = null
    private var googleSignInClient: GoogleSignInClient? = null
    var firebaseAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        connectxml()
        firebaseAuth = FirebaseAuth.getInstance()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("369341452315-mnn3mgvls3qtvupvsdv23q378nv6kgie.apps.googleusercontent.com")
            .requestEmail()
            .build()
        //        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
//
//        signInButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = mGoogleSignInClient.getSignInIntent();
//                startActivityForResult(intent,RC_SIGN_IN);
//            }
//        });
        googleSignInClient = GoogleSignIn.getClient(this, gso)
        signInButton!!.setOnClickListener {
            val intent = googleSignInClient!!.signInIntent
            startActivityForResult(intent, RC_SIGN_IN)
        }
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            statuse!!.text = "useremail =>" + user.getEmail()
            uid!!.text = "username =>" + user.getDisplayName()
            val url: String = user.getPhotoUrl().toString()
            Glide.with(applicationContext).load(url).into(profileimage)
            signInButton!!.visibility = View.GONE
            signout!!.visibility = View.VISIBLE
            disconnextbtn!!.visibility = View.VISIBLE
        } else {
            statuse!!.text = "user is not signin"
            uid!!.text = "null"
            profileimage!!.setImageResource(R.drawable.ic_launcher_background)
            signInButton!!.visibility = View.VISIBLE
            signout!!.visibility = View.GONE
            disconnextbtn!!.visibility = View.GONE
        }
    }

    private fun connectxml() {
        signInButton = findViewById(R.id.googlesinginbutn)
        statuse = findViewById(R.id.userstatus)
        uid = findViewById(R.id.userdetail)
        profileimage = findViewById(R.id.userprofiel)
        signout = findViewById(R.id.signoutbtn)
        disconnextbtn = findViewById(R.id.disconnextbtn)
    }
    var CamereResultLauncher = registerForActivityResult(StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val bitmap = result.data!!.extras!!["data"] as Bitmap?
            imageView.setImageBitmap(bitmap)
            imageuri = getimageurifrombitmap(applicationContext, bitmap)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN && data != null) {

            //   Toast.makeText(getApplicationContext(), "error "+data.getExtras(), Toast.LENGTH_SHORT).show();
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                account = task.getResult(ApiException::class.java)
            } catch (e: ApiException) {
                e.printStackTrace()
                Log.w(TAG, "Google sign in failed", e)
                // [START_EXCLUDE]
                updateUI(null)
            }
            Log.d(TAG, "firebaseAuthWithGoogle:" + account!!.id)
            firebaseAuthWithGoogle(account!!.idToken)
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String?) {
        val googleauthcrediatl: AuthCredential = GoogleAuthProvider.getCredential(idToken, null)
        firebaseAuth.signInWithCredential(googleauthcrediatl).addOnCompleteListener(this,
            OnCompleteListener<Any?> { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this@SecondActivity, "LogIn Success full", Toast.LENGTH_SHORT)
                        .show()
                    val user: FirebaseUser = firebaseAuth.getCurrentUser()
                    updateUI(user)
                } else {
                    Toast.makeText(
                        this@SecondActivity,
                        "error " + task.exception,
                        Toast.LENGTH_SHORT
                    ).show()
                    //                    Toast.makeText(MainActivity.this, "error"+task.getException(), Toast.LENGTH_SHORT).show();
                    updateUI(null)
                }
            })
    }

    companion object {
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001
    }
}