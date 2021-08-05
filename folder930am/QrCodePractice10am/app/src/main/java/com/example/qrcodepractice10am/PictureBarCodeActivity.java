package com.example.qrcodepractice10am;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



import java.io.IOException;

public class PictureBarCodeActivity extends AppCompatActivity {
    SurfaceView surfaceView;
    TextView texBArcodevalue;
    private BarcodeDetector barcodeDetector;
    private CameraSource cameraSource;
    private static final int REQUEST_CAMERA_PERMISSION = 201;
    Button btnaciton;
    String intendData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_bar_code);
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
        initialiseDetectorAndSoruces();
    }

    @Override
    protected void onPause() {
        super.onPause();

        cameraSource.release();
    }

    private void initialiseDetectorAndSoruces() {

        Toast.makeText(this, "BarCodeScnned started", Toast.LENGTH_SHORT).show();
        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.ALL_FORMATS)
                .build();

        cameraSource = new CameraSource.Builder(this,barcodeDetector)
                .setRequestedPreviewSize(1920,1080)
                .setAutoFocusEnabled(true)
                .build();

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                try {
                if(ActivityCompat.checkSelfPermission(PictureBarCodeActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)
                {

                        cameraSource.start(surfaceView.getHolder());


                }else
                {
                    ActivityCompat.requestPermissions(PictureBarCodeActivity.this,new String[] {Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_CAMERA_PERMISSION);
                }

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
                Toast.makeText(PictureBarCodeActivity.this, "bar code stopped", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void receiveDetections(@NonNull Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();
                if(barcodes.size() !=0)
                {
                    texBArcodevalue.post(new Runnable() {
                        @Override
                        public void run() {


                            btnaciton.setText("LAUNCH URL");
                            intendData = barcodes.valueAt(0).displayValue;
                            texBArcodevalue.setText(intendData);

                        }
                    });
                }else
                {
                    Toast.makeText(PictureBarCodeActivity.this, "It is empty in size", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}