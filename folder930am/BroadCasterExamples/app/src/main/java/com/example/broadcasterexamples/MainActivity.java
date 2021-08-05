package com.example.broadcasterexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Switch wifiswitch;

    private WifiManager wifiManager;

    MyBraodCasteralone myBraodCasteralone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wifiswitch = findViewById(R.id.wifiswitch);
        myBraodCasteralone = new MyBraodCasteralone();
        wifiManager =(WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });


    }

    private BroadcastReceiver mybroadcaseter = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int wifiStateExtra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN);

            switch (wifiStateExtra)
            {
                case WifiManager.WIFI_STATE_ENABLED:
                    wifiswitch.setChecked(true);
                    wifiswitch.setText("Wifi Is On");
                    break;

                case WifiManager.WIFI_STATE_DISABLED:
                    wifiswitch.setChecked(false);
                    wifiswitch.setText("Wifit is Off");
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
        registerReceiver(mybroadcaseter,intentFilter);
        registerReceiver(myBraodCasteralone,intentFilter1);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mybroadcaseter);
        unregisterReceiver(myBraodCasteralone);
    }
}