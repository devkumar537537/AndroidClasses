package com.example.facebookandgooglesinginkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.CallbackManager.Factory.create
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton

class MainActivity : AppCompatActivity() {
    lateinit var loginButton:LoginButton
    lateinit var profileimage:ImageView
    lateinit var email:TextView
    lateinit var name:TextView
    lateinit var id:TextView
    lateinit var signoutbtn:Button
    var callbackManager: CallbackManager? = null
    var firebaseAuth: FirebaseAuth? = null
    private const val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectxml()
        firebaseAuth = FirebaseAuth.getInstance()

        callbackManager = create()
        loginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult?> {


            override fun onCancel() {
                Toast.makeText(applicationContext, "User cancled login", Toast.LENGTH_SHORT).show()
                updateUI(null)
            }

            override fun onError(error: FacebookException) {
                Toast.makeText(applicationContext, "error " + error.message, Toast.LENGTH_SHORT)
                    .show()
                updateUI(null)
            }

            override fun onSuccess(result: LoginResult?) {
                   Log.d(MainActivity.this, "facebook:onSuccess:$loginResult")
                handfacboologinwithfirebase(loginResult.accessToken)
            }
        })

        signoutbtn.setOnClickListener {
            firebaseAuth.signOut()
            LoginManager.getInstance().logOut()
            updateUI(null)
        }
    }
    private fun handfacboologinwithfirebase(accessToken: AccessToken) {
        val authCredential: AuthCredential = FacebookAuthProvider.getCredential(accessToken.token)
        firebaseAuth.signInWithCredential(authCredential)
            .addOnCompleteListener(this, object : OnCompleteListener<AuthResult?>() {
                fun onComplete(task: Task<AuthResult?>) {
                    if (task.isSuccessful()) {
                        Toast.makeText(applicationContext, "login successfull", Toast.LENGTH_SHORT)
                            .show()
                        val user: FirebaseUser = firebaseAuth.getCurrentUser()
                        updateUI(user)
                    } else {
                        Toast.makeText(
                            applicationContext, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                        updateUI(null)
                    }
                }
            })
    }


    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            name.setText(user.getDisplayName())
            email.setText(user.getEmail())
            id.setText(user.getUid())
            if (user.getPhotoUrl() == null) {
                Toast.makeText(this, "There is no url in image", Toast.LENGTH_SHORT).show()
            } else {
                val imageure: String = user.getPhotoUrl().toString()
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
        callbackManager!!.onActivityResult(requestCode, resultCode, data)
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