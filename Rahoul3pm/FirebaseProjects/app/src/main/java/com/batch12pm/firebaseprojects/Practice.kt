package com.batch12pm.firebaseprojects

import android.view.View
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks

class Practice {
//
//    private val mCallbacks: OnVerificationStateChangedCallbacks =
//        object : OnVerificationStateChangedCallbacks() {
//            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
//                progressBar.setVisibility(View.GONE)
//                val code = phoneAuthCredential.smsCode
//                verficode(code)
//            }
//
//            override fun onVerificationFailed(e: FirebaseException) {
//                progressBar.setVisibility(View.GONE)
//                Toast.makeText(getApplicationContext(), "error " + e.message, Toast.LENGTH_SHORT)
//                    .show()
//            }
//
//            override fun onCodeSent(s: String, forceResendingToken: ForceResendingToken) {
//                super.onCodeSent(s, forceResendingToken)
//                verification_code = s
//            }
//        }
}