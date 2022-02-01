package com.example.androidtelophonymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMSActivity extends AppCompatActivity {
    EditText numberedit,messageedit;
    Button sendsmsbtn;
    int requestcode  = 45665;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsactivity);
        numberedit = findViewById(R.id.user_sms_number);
        messageedit = findViewById(R.id.sms_body);
        sendsmsbtn = findViewById(R.id.send_sms_btn);
        sendsmsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number_text = numberedit.getText().toString().trim();
                String message_text = messageedit.getText().toString().trim();

                Intent  intent = new Intent(SMSActivity.this,MainActivity.class);

                SmsManager sms = SmsManager.getDefault();
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),requestcode,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                sms.sendTextMessage(number_text,null,message_text,pendingIntent,null);
                Toast.makeText(getApplicationContext(), "sms sended", Toast.LENGTH_SHORT).show();
            }
        });
    }
}