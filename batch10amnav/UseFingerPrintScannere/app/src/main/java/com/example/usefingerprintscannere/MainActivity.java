package com.example.usefingerprintscannere;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;

import com.example.usefingerprintscannere.utils.Commonfucntions;

@RequiresApi(api = Build.VERSION_CODES.P)
public class MainActivity extends AppCompatActivity {
    String[] permissions = {Manifest.permission.USE_BIOMETRIC};
    int requestcode = 123;
BioMatricCallbacksExample bioMatricCallbacksExample;


   BiometricPrompt biometricPrompt;
   CancellationSignal cancellationSignal;
Commonfucntions commonfucntions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
bioMatricCallbacksExample = new BioMatricCallbacksExample(getApplicationContext());
commonfucntions = new Commonfucntions(getApplicationContext());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.USE_BIOMETRIC) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(permissions, requestcode);
            } else {

             biometricPrompt  = new BiometricPrompt.Builder(this)
                     .setTitle("Contace Data")
                     .setSubtitle("Authentication required")
                     .setDescription("We will use this information for accessing your personal data")
                     .setNegativeButton("Cancel", getMainExecutor(), new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                            commonfucntions.notifiyuser("User Cancel the dialog");
                         }
                     }).build();

             biometricPrompt.authenticate(getcanclesingle(),getMainExecutor(),bioMatricCallbacksExample);
            }
        }
    }

    public CancellationSignal getcanclesingle()
    {
        cancellationSignal = new CancellationSignal();
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() {
            @Override
            public void onCancel() {
                commonfucntions.notifiyuser("cancel signal activitated");
            }
        });
        return  cancellationSignal;
    }
}