package com.batch12pm.firebaseprojects

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class LOgInActivity : AppCompatActivity() {
    private lateinit var verifcaiton: String
    lateinit var editemail: EditText
    lateinit var editpassword:EditText
    lateinit var btnlogin: Button
lateinit var regsiterbtn:Button
    lateinit var firebaseAuth:FirebaseAuth
    lateinit var numbereidt:EditText
    lateinit var otpedit:EditText
    lateinit var numbersubmitbtn:Button
    lateinit var otpsubmitbtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       connect()
        regsiterbtn.setOnClickListener {
            startActivity(Intent(applicationContext,RegisterActivity::class.java))
        }
        firebaseAuth = FirebaseAuth.getInstance()
        btnlogin.setOnClickListener {
            var emailtext = editemail.text.toString()
            var passwordtext = editpassword.text.toString()

            firebaseAuth.signInWithEmailAndPassword(emailtext,passwordtext).addOnCompleteListener { task->

                if(task.isSuccessful)
                {
                    Toast.makeText(applicationContext,"Login Successfull",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(applicationContext,HomeActivity::class.java))
                    finish()
                }else
                {
                    Toast.makeText(applicationContext,"error ${task.exception}",Toast.LENGTH_SHORT).show()
                }

            }
        }
otpsubmitbtn.setOnClickListener {
    var code = otpedit.text.toString()
    verfiycode(code)
}
        numbersubmitbtn.setOnClickListener {
            var numtext = numbereidt.text.toString()
            var numbwerwithcod = "+91$numtext"
            val options = PhoneAuthOptions.newBuilder(firebaseAuth)
                .setPhoneNumber(numbwerwithcod)       // Phone number to verify
                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(this)                 // Activity (for callback binding)
                .setCallbacks(callbacks)          // OnVerificationStateChangedCallbacks
                .build()
            PhoneAuthProvider.verifyPhoneNumber(options)
        }

    }

    private val callbacks = object :PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
        override fun onVerificationCompleted(p0: PhoneAuthCredential) {
            Toast.makeText(applicationContext," number verified",Toast.LENGTH_SHORT).show()
               var code = p0.smsCode
               verfiycode(code)
        }

        override fun onVerificationFailed(p0: FirebaseException) {
          Toast.makeText(applicationContext," error ${p0.message}",Toast.LENGTH_SHORT).show()
        }

        override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
            super.onCodeSent(p0, p1)

            verifcaiton = p0
        }

    }

    private fun verfiycode(code: String?) {
         var credential = PhoneAuthProvider.getCredential(verifcaiton,code!!)
        sighinwithfirebase(credential)

    }

    private fun sighinwithfirebase(credential: PhoneAuthCredential) {
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(applicationContext," login successfull",Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext," error ${it.exception}",Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun connect()
{
    editemail = findViewById(R.id.emailedit);
    editpassword = findViewById(R.id.passwordedit);
    btnlogin = findViewById(R.id.loginbtn);
    regsiterbtn=findViewById(R.id.registerbtn)
    numbereidt = findViewById(R.id.numberlayout)
    otpedit = findViewById(R.id.otplayout)
    numbersubmitbtn = findViewById(R.id.submitnumber)
    otpsubmitbtn = findViewById(R.id.submitotp)
}
    override fun onStart() {
        super.onStart()
//
//        if(firebaseAuth.currentUser != null)
//        {
//            startActivity(Intent(applicationContext,HomeActivity::class.java))
//            finish()
//        }
    }
}