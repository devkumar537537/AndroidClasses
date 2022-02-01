package com.example.biomatricexample

import android.content.Context
import android.content.Intent
import android.hardware.biometrics.BiometricPrompt
import android.hardware.biometrics.BiometricPrompt.*
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.P)
public class MyCallbacks(var contextt: Context) : BiometricPrompt.AuthenticationCallback(){

    var commonfunctions: Commonfunctions
    init {
        commonfunctions = Commonfunctions()
    }

    override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
        super.onAuthenticationError(errorCode, errString)

        commonfunctions.notifyuser(" $errString",contextt)
    }

    override fun onAuthenticationFailed() {
        super.onAuthenticationFailed()
        commonfunctions.notifyuser("some internal error ",contextt)
    }

    override fun onAuthenticationSucceeded(result: AuthenticationResult?) {
        super.onAuthenticationSucceeded(result)
        commonfunctions.notifyuser("user verified",contextt)
        var intent = Intent(contextt,SecondActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

      contextt.startActivity(intent)
    }
}