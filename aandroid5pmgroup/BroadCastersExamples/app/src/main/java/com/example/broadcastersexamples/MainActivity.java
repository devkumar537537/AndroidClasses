package com.example.broadcastersexamples;

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
WifiManager wifiManager;
MyNewBroadCaster myNewBroadCaster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wifiswitch = findViewById(R.id.wifiswitch);
        wifiManager =(WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
myNewBroadCaster = new MyNewBroadCaster();
wifiswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked)
        {

        }else
        {

        }
    }
});
    }
    private BroadcastReceiver  myBroadCastReciever = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiStateExtra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN);
            switch (wifiStateExtra)
            {
                case WifiManager.WIFI_STATE_ENABLED:
                    wifiswitch.setText("wifi is on");
                    wifiswitch.setChecked(true);
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    wifiswitch.setText("wifi is off");
                    wifiswitch.setChecked(false);
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
        registerReceiver(myNewBroadCaster,intentFilter1);
        registerReceiver(myBroadCastReciever,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadCastReciever);
        unregisterReceiver(myNewBroadCaster);
    }
}