package com.example.myfackebookandgooglkotlinrahoule

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var loginButton:Button
    lateinit var profileimage: ImageView
    lateinit var email: TextView
    lateinit var name: TextView
    lateinit var id: TextView
    lateinit var signoutbtn: Button
    lateinit var firebaseAuth:FirebaseAuth
    lateinit var callbackManager: CallbackManager

    private  val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectxml()

        firebaseAuth = FirebaseAuth.getInstance()

        callbackManager = CallbackManager.Factory.create()
        LoginManager.getInstance().registerCallback(callbackManager,object : FacebookCallback<LoginResult>{
            override fun onCancel() {
                Toast.makeText(applicationContext, "User cancled login", Toast.LENGTH_SHORT).show()
               updateUI(null)
            }

            override fun onError(error: FacebookException) {
                Toast.makeText(applicationContext, "error " + error.message, Toast.LENGTH_SHORT)
                    .show()
                updateUI(null)
            }

            override fun onSuccess(result: LoginResult) {
                Log.d(TAG, "facebook:onSuccess:$result")
             handfacboologinwithfirebase(result.accessToken)
            }

        })
loginButton.setOnClickListener {
    LoginManager.getInstance().logInWithReadPermissions(this@MainActivity, Arrays.asList("public_profile"))
}
    }

    private fun handfacboologinwithfirebase(accessToken: AccessToken) {
     var credials = FacebookAuthProvider.getCredential(accessToken.token)
        firebaseAuth.signInWithCredential(credials).addOnCompleteListener { taskt->
            if(taskt.isSuccessful)
            {
                Toast.makeText(applicationContext, "login successfull", Toast.LENGTH_SHORT)
                    .show()
                val user: FirebaseUser = firebaseAuth.currentUser!!
                updateUI(user)
            }else
            {
                Toast.makeText(
                    applicationContext, "Authentication failed.",
                    Toast.LENGTH_SHORT
                ).show()
                updateUI(null)
            }
        }
    }


    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {

            name.text = user.displayName

            email.text = user.email

            id.text = user.uid
            if (user.photoUrl == null) {
                Toast.makeText(this, "There is no url in image", Toast.LENGTH_SHORT).show()
            } else {
                val imageure: String = user.photoUrl.toString()
                Glide.with(applicationContext).load(imageure).into(profileimage)
            }
            loginButton.visibility = View.GONE
            signoutbtn.visibility = View.VISIBLE
        } else {
            name.text = "NO name"
            email.text = "NO email"
            id.text = "no id"
            profileimage.setImageResource(R.drawable.ic_launcher_background)
            Toast.makeText(this, "There is no url in image", Toast.LENGTH_SHORT).show()
            loginButton.visibility = View.VISIBLE
            signoutbtn.visibility = View.GONE
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data)
    }
    private fun connectxml() {
        loginButton = findViewById(R.id.login_button)
        profileimage = findViewById(R.id.profileImage)
        email = findViewById(R.id.email)
        name = findViewById(R.id.name)
        id = findViewById(R.id.userId)
        signoutbtn = findViewById(R.id.facesignout)
    }
}


