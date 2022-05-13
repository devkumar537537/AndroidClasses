package com.example.androidtelophonymanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText numberedit;
    Button callbtn,movetosms,movetoemail;
    String[] perm = {Manifest.permission.CALL_PHONE,Manifest.permission.INTERNET,Manifest.permission.SEND_SMS,Manifest.permission.READ_SMS};
    int CALL_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectxml();

        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number_text = numberedit.getText().toString().trim();
                if(ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                {
                    requestPermissions(perm,CALL_REQUEST);
                } else {

                    Intent callintent = new Intent(Intent.ACTION_CALL);
                    callintent.setData(Uri.parse("tel:"+number_text));
                    startActivity(callintent);
                }
            }
        });

        movetoemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),EmailActivity.class);
                startActivity(intent);
            }
        });

        movetosms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SMSActivity.class);
                startActivity(intent);
            }
        });
    }

    public void connectxml()
    {
        callbtn = findViewById(R.id.sendCall);
        numberedit = findViewById(R.id.usern_number);
        movetosms=findViewById(R.id.move_t0_sms);
        movetoemail=findViewById(R.id.move_to_email);
    }
}