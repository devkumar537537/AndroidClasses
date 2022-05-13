package com.cbitss.broadcasterexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Switch wifiwitch;
MyGlobalReceiver  myGlobalReceiver = new MyGlobalReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wifiwitch = findViewById(R.id.wifiswitch);
        if(getIntent() != null)
        {
            if(getIntent().getStringExtra("network") != null){
                String text =getIntent().getStringExtra("network");
                if(text.equals("netband"))
                {
                    Toast.makeText(this, "net is closed here", Toast.LENGTH_SHORT).show();
                }
            }

        }
        wifiwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });
    }

    public BroadcastReceiver wifireceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifistate = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN);

            switch (wifistate)
            {
                case WifiManager.WIFI_STATE_ENABLED:
                    wifiwitch.setText(getString(R.string.onwifi));
                    wifiwitch.setChecked(true);
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    wifiwitch.setText(getString(R.string.offwifi));
                    wifiwitch.setChecked(false);
                    break;
            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
IntentFilter intentFilter1 = new IntentFilter();
        intentFilter1.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter1.addAction(Intent.ACTION_TIMEZONE_CHANGED);
        intentFilter1.addAction(Intent.ACTION_POWER_CONNECTED);
        registerReceiver(myGlobalReceiver,intentFilter1);
        registerReceiver(wifireceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifireceiver);
        unregisterReceiver(myGlobalReceiver);
    }



}