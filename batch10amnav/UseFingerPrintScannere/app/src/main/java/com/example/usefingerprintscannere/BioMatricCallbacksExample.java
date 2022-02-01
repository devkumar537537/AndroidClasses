package com.example.usefingerprintscannere;

import android.content.Context;
import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.usefingerprintscannere.utils.Commonfucntions;

@RequiresApi(api = Build.VERSION_CODES.P)
public class BioMatricCallbacksExample  extends BiometricPrompt.AuthenticationCallback {
    Context context;
  Commonfucntions commonfucntions;
    public BioMatricCallbacksExample(Context context) {
        this.context = context;
        commonfucntions = new Commonfucntions(context);
    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {
        super.onAuthenticationError(errorCode, errString);
        commonfucntions.notifiyuser("error "+errorCode);
    }

    @Override
    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
        super.onAuthenticationSucceeded(result);
        commonfucntions.notifiyuser("Successfully verified");
        Intent intent = new Intent(context.getApplicationContext(),SecondActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }



    @Override
    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();
        commonfucntions.notifiyuser("Wrong Information");

    }


}
