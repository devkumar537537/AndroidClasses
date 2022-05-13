package com.cbitss.biomatricexample;

import android.content.Context;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.P)
public class Authenticationcallbacks extends BiometricPrompt.AuthenticationCallback {

    Context context;

    public Authenticationcallbacks(Context context) {
        this.context = context;
    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {
        super.onAuthenticationError(errorCode, errString);
        Toast.makeText(context, "error => "+errorCode, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();

        Toast.makeText(context, "Not matched", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
        super.onAuthenticationSucceeded(result);

        Toast.makeText(context, "You are identified user", Toast.LENGTH_SHORT).show();
    }
}
