package com.example.biomatricexample

import android.Manifest
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CancellationSignal
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat

@RequiresApi(Build.VERSION_CODES.P)
class MainActivity : AppCompatActivity() {



    var permissions = arrayOf(Manifest.permission.USE_BIOMETRIC)
    var requestcode = 123
    private  lateinit var bioMatricCallbacksExample: MyCallbacks
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var cancellationSignal: CancellationSignal
    private lateinit var commonfucntions: Commonfunctions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        commonfucntions = Commonfunctions()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.USE_BIOMETRIC
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissions(permissions, requestcode)
            } else {

            }
        }

     bioMatricCallbacksExample = MyCallbacks(applicationContext)
     biometricPrompt = BiometricPrompt.Builder(this)
         .setTitle("Bio Matric")
         .setSubtitle("It finger Print")
         .setDescription("We will use this information for accessing your device")
         .setNegativeButton("Cancel",mainExecutor, DialogInterface.OnClickListener {
                 dialog, which ->
             commonfucntions.notifyuser("user cancled ",applicationContext)
         })
         .build()
        biometricPrompt.authenticate(getCanclesingle(),mainExecutor,bioMatricCallbacksExample)

    }

    fun getCanclesingle(): CancellationSignal{
        cancellationSignal = CancellationSignal()
    cancellationSignal.setOnCancelListener {
        commonfucntions.notifyuser("cancelation",applicationContext)
    }
    return cancellationSignal
    }
}