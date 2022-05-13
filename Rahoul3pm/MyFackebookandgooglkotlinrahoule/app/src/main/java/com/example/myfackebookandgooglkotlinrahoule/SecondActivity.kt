package com.example.myfackebookandgooglkotlinrahoule

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.*


class SecondActivity : AppCompatActivity() {


    // [START declare_auth]
    // [END declare_auth]

   lateinit var signInButton: SignInButton
  lateinit  var statuse: TextView
    lateinit var uid: TextView
  lateinit  var profileimage: ImageView
  lateinit  var signout: Button
  lateinit  var disconnextbtn: Button
    private lateinit var googleSignInClient: GoogleSignInClient
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        connectxml()
        firebaseAuth = FirebaseAuth.getInstance()

    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken("921838982915-n0ene31mllgdmjuq2531r4eoh9m3f0dr.apps.googleusercontent.com")
        .requestEmail()
        .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)
        signInButton.setOnClickListener {

        val intent = googleSignInClient.signInIntent
            googlesignlaucher.launch(intent)
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
    var googlesignlaucher = registerForActivityResult(
        StartActivityForResult()
    ){result->
        if(result.resultCode ==Activity.RESULT_OK)
        {
            var task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            try {
                var account = task.getResult(ApiException::class.java)
                Log.d(TAG, "firebaseAuthWithGoogle:" + account!!.id)

                firebaseAuthWithGoogleaccount(account.idToken)
            }catch (e:ApiException)
            {
                e.printStackTrace()
                Log.w(TAG, "Google sign in failed", e)

                // [START_EXCLUDE]
                updateUi(null)
            }

        }else
        {
            Toast.makeText(applicationContext,"error ${result.resultCode}",Toast.LENGTH_LONG).show()
        }
    }

    private fun updateUi(user: FirebaseUser?) {
        if (user != null) {

            statuse.text = "useremail =>" + user.getEmail()
            uid.text = "username =>" + user.getDisplayName()
            val url: String = user.getPhotoUrl().toString()
            Glide.with(applicationContext).load(url).into(profileimage)
            signInButton.visibility = View.GONE
            signout.visibility = View.VISIBLE
            disconnextbtn.visibility = View.VISIBLE
        } else {
            statuse.text = "user is not signin"
            uid.text = "null"
            profileimage.setImageResource(R.drawable.ic_launcher_background)
            signInButton.visibility = View.VISIBLE
            signout.visibility = View.GONE
            disconnextbtn.visibility = View.GONE
        }
    }

    private fun firebaseAuthWithGoogleaccount(idToken: String?) {
var googlecreatial = GoogleAuthProvider.getCredential(idToken,null)
        firebaseAuth.signInWithCredential(googlecreatial).addOnCompleteListener(this@SecondActivity,OnCompleteListener<AuthResult>{task->
            if(task.isSuccessful)
            {
                Toast.makeText(this@SecondActivity, "LogIn Success full", Toast.LENGTH_SHORT)
                    .show()
                val user: FirebaseUser = firebaseAuth.currentUser!!
                updateUi(user)
            }else{
                Toast.makeText(
                    this@SecondActivity,
                    "error " + task.exception,
                    Toast.LENGTH_SHORT
                ).show()
                //                    Toast.makeText(MainActivity.this, "error"+task.getException(), Toast.LENGTH_SHORT).show();
          updateUi(null)
            }
        })
    }



//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//
//        if (requestCode == RC_SIGN_IN && data != null) {
//
//            //   Toast.makeText(getApplicationContext(), "error "+data.getExtras(), Toast.LENGTH_SHORT).show();
//            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
//            try {
//
//                var account = task.getResult(ApiException::class.java)
//                Log.d(TAG, "firebaseAuthWithGoogle:" + account!!.id)
//
//                firebaseAuthWithGoogle(account!!.idToken)
//            } catch (e: ApiException) {
//                e.printStackTrace()
//                Log.w(TAG, "Google sign in failed", e)
//
//                // [START_EXCLUDE]
//                updateUI(null)
//            }
//
//        }
//    }
//
//    private fun firebaseAuthWithGoogle(idToken: String?) {
//        val googleauthcrediatl: AuthCredential = GoogleAuthProvider.getCredential(idToken, null)
//        firebaseAuth!!.signInWithCredential(googleauthcrediatl).addOnCompleteListener(this@SecondActivity,
//            OnCompleteListener<AuthResult> { task ->
//                if (task.isSuccessful) {
//                    Toast.makeText(this@SecondActivity, "LogIn Success full", Toast.LENGTH_SHORT)
//                        .show()
//                    val user: FirebaseUser = firebaseAuth!!.getCurrentUser()!!
//                    updateUI(user)
//                } else {
//                    Toast.makeText(
//                        this@SecondActivity,
//                        "error " + task.exception,
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    //                    Toast.makeText(MainActivity.this, "error"+task.getException(), Toast.LENGTH_SHORT).show();
//                    updateUI(null)
//                }
//            })
//    }

    companion object {
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001
    }
}