package com.cbitss.newqrcodeapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button movetogeneratecode,movetoBarCode;
    String[] pemrisonssoino= {Manifest.permission.INTERNET,Manifest.permission.CAMERA};
    int requescod = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
            {
                requestPermissions(pemrisonssoino,requescod);
            }
        }
        movetoBarCode = findViewById(R.id.btnScanBarCode);
        movetogeneratecode = findViewById(R.id.moveto_generate);
        movetogeneratecode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,QrCodeGenerator.class));
            }
        });
        movetoBarCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,QrcodeScannerActivity.class));
            }
        });
    }
}