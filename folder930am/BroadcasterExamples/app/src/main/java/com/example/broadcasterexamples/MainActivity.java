package com.example.broadcasterexamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    EditText numbertext;
    Button callbtn,movetosms,movetoemail,sharebtn;
    String[] permssions = {Manifest.permission.CALL_PHONE,Manifest.permission.RECEIVE_SMS,Manifest.permission.SEND_SMS};
    int requestcode = 345;

    Switch wifiswitch;
    WifiManager wifiManager;
    MyBroadCaster myBroadCaster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callbtn = findViewById(R.id.sendCall);
        numbertext = findViewById(R.id.usern_number);
        movetosms=findViewById(R.id.move_t0_sms);
        movetoemail=findViewById(R.id.move_to_email);
        sharebtn = findViewById(R.id.move_to_share);
myBroadCaster = new MyBroadCaster();

        if(Build.VERSION.SDK_INT> Build.VERSION_CODES.M)
        {
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {
                requestPermissions(permssions,requestcode);
            }
        }

        wifiswitch = findViewById(R.id.wifiswtich);
        wifiManager =(WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
wifiswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


    }
});

        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = numbertext.getText().toString().trim();
                Intent sendIntent = new Intent(Intent.ACTION_CALL);

                sendIntent.setData(Uri.parse("tel:"+number));
                startActivity(sendIntent);


            }
        });
        movetosms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SmsActivity.class));
            }
        });
        movetoemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,EmailActivity.class));
            }
        });

        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = numbertext.getText().toString().trim();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);

                sendIntent.putExtra(Intent.EXTRA_TEXT,number);
                sendIntent.setType("text/plain");
                Intent.createChooser(sendIntent,"Share via");
                startActivity(sendIntent);
            }
        });
    }


    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifistate = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN);

            switch (wifistate)
            {
                case WifiManager.WIFI_STATE_ENABLED:
                    wifiswitch.setChecked(true);
                    wifiswitch.setText("Wifi Is On");
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    wifiswitch.setChecked(false);
                    wifiswitch.setText("Wifi Is ff");
                    break;
            }
        }
    };


    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        IntentFilter intentFilter1 = new IntentFilter();
        intentFilter1.addAction(Intent.ACTION_TIMEZONE_CHANGED);
        intentFilter1.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(myBroadCaster,intentFilter1);
        registerReceiver(broadcastReceiver,intentFilter);
    }


    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
        unregisterReceiver(myBroadCaster);
    }
}