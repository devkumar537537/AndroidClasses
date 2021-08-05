package com.example.qrscannerproject;

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

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

public class PictureBarCodeActivity extends AppCompatActivity {

    SurfaceView surfaceView;
    TextView textView;
    private BarcodeDetector barcodeDetector;
    private CameraSource cameraSource;
    private static final int REQUEST_CAMERA_PERMISSION = 201;
    Button btnaction;
    String intentData = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_bar_code);
        bindview();

        btnaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(intentData.length() > 0)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(intentData)));
                }
            }
        });
    }

    private void bindview() {
        surfaceView = findViewById(R.id.surfaceview);
        btnaction = findViewById(R.id.btnaction);
        textView = findViewById(R.id.textbacrcode);
    }

    private void initialiseDetectorAndSource()
    {
        Toast.makeText(this, "Barcode Scanner start", Toast.LENGTH_SHORT).show();
        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.ALL_FORMATS)
                .build();
        cameraSource =new  CameraSource.Builder(this,barcodeDetector)
                .setRequestedPreviewSize(1920,1080)
                .setAutoFocusEnabled(true)
                .build();

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
              try {
                  if(ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){

                      cameraSource.start(surfaceView.getHolder());
                  }else
                  {
                      ActivityCompat.requestPermissions(PictureBarCodeActivity.this,new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA_PERMISSION);
                  }
              }catch (IOException e)
              {
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
                Toast.makeText(PictureBarCodeActivity.this, "Resource Released", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
              final SparseArray<Barcode> barcode = detections.getDetectedItems();
              if(barcode.size() != 0)
              {
                  textView.post(new Runnable() {
                      @Override
                      public void run() {
                          btnaction.setText("Launch Url");
                          intentData = barcode.valueAt(0).displayValue;
                          textView.setText(intentData);
                      }
                  });
              }else
              {
                  Toast.makeText(PictureBarCodeActivity.this, "It is empty size", Toast.LENGTH_SHORT).show();
              }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        cameraSource.release();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initialiseDetectorAndSource();
    }
}