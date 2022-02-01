package com.example.qrcodeexamplehere;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.FocusingProcessor;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;
@SuppressLint("MissingPermission")
public class ScanActivity extends AppCompatActivity {
    SurfaceView surfaceView;
    TextView texBArcodevalue;
    private BarcodeDetector barcodeDetector;
    private CameraSource cameraSource;

    Button btnaciton;
    String intendData = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        bindview();
btnaciton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(intendData.length() > 0) {

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(intendData)));

        }
    }
});
    }

    private void bindview() {
        surfaceView = findViewById(R.id.surfaceview);
        btnaciton = findViewById(R.id.btnaction);
        texBArcodevalue = findViewById(R.id.textbarcodevalue);



    }



    @Override
    protected void onResume() {
        super.onResume();
        intialisecamerasource();

    }

    private void intialisecamerasource() {
        Toast.makeText(this, "Initialisation start", Toast.LENGTH_SHORT).show();

        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.ALL_FORMATS)
                .build();


        cameraSource = new CameraSource.Builder(this,barcodeDetector)
                .setAutoFocusEnabled(true)
                .setRequestedPreviewSize(1920,1080)
                .build();

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {

            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                try {
                    cameraSource.start(surfaceView.getHolder());
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
                cameraSource.stop();
            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
                Toast.makeText(ScanActivity.this, "Release Resorces here", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();

                if(barcodes.size() != 0) {
                    texBArcodevalue.post(new Runnable() {
                        @Override
                        public void run() {

                            btnaciton.setText("LAUNCH URL");
                            intendData = barcodes.valueAt(0).displayValue;
                            texBArcodevalue.setText(intendData);
                        }
                    });

                }
            }
        });



    }
}