package com.cbitss.biomatricexample;

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
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.P)
public class MainActivity extends AppCompatActivity {
    String[] permissions = {Manifest.permission.USE_BIOMETRIC};
    int requestcode = 123;
 BiometricPrompt biometricPrompt;
    Authenticationcallbacks authenticationcallbacks;
    CancellationSignal cancellationSignal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    protected void onStart() {
        super.onStart();
        authenticationcallbacks = new Authenticationcallbacks(getApplicationContext());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.USE_BIOMETRIC) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(permissions, requestcode);
            } else {
                biometricPrompt = new BiometricPrompt.Builder(this)
                        .setTitle("Hacker")
                        .setDescription("We will use this information for device hack")
                        .setNegativeButton("Cancel", this.getMainExecutor(), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "User Cancled the Authentication", Toast.LENGTH_SHORT).show();
                            finish();
                            }
                        }).build();

            }
            biometricPrompt.authenticate(getCancellationSignal(),getMainExecutor(),authenticationcallbacks);

        }
    }
    private CancellationSignal getCancellationSignal(){
        cancellationSignal =new CancellationSignal();
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() {
            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this, "user canclee authentication", Toast.LENGTH_SHORT).show();
             finish();
            }
        });
        return cancellationSignal;
    }

}