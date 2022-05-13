package com.cbitss.newqrcodeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class QrCodeGenerator extends AppCompatActivity {
    private ImageView qrCodeIV;
    private EditText dataEdt;
    private Button generateQrBtn;

    Bitmap bitmap;
    QRGEncoder qrgEncoder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code_generator);
        qrCodeIV = findViewById(R.id.idIVQrcode);
        dataEdt = findViewById(R.id.idEdt);
        generateQrBtn = findViewById(R.id.idBtnGenerateQR);
        generateQrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String datatext = dataEdt.getText().toString().trim();

                if (TextUtils.isEmpty(datatext)) {


                    Toast.makeText(QrCodeGenerator.this, "Enter some text to generate QR Code", Toast.LENGTH_SHORT).show();
                } else {

                    WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);

                    Display display = manager.getDefaultDisplay();
                    Point point = new Point();
                    display.getSize(point);
                    int width = point.x;
                            int height = point.y;

                            int dimens = width<height? width:height;
                            dimens = dimens*3/4;
qrgEncoder = new QRGEncoder(datatext,null,QRGContents.Type.TEXT,dimens);
                    try {
                        bitmap = qrgEncoder.encodeAsBitmap();
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }
                    qrCodeIV.setImageBitmap(bitmap);

                }
            }
        });
    }
}