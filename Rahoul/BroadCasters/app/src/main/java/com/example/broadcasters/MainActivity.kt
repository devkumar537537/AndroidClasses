package com.example.broadcasters

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.wifi.WifiManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import java.util.jar.Manifest

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    lateinit var  wifiSwitch:Switch
    lateinit var wifiManager: WifiManager
val broadcaseter = BroadCasterClass()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wifiSwitch = findViewById(R.id.wifit_switch);

        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        wifiSwitch.setOnCheckedChangeListener { buttonView, isChecked ->

            if(isChecked)
            {
                wifiManager.setWifiEnabled(true)
                wifiSwitch.setText("Wifi is On");
            }else
            {
                wifiManager.setWifiEnabled(false)
                wifiSwitch.setText("Wifi is off")
            }
        }
    }
    private  val wifistatereceviewr: BroadcastReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            val wifistateextra = intent?.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN)

     when(wifistateextra)
     {
         WifiManager.WIFI_STATE_ENABLED ->
         {
             wifiSwitch.isChecked = true
             wifiSwitch.text = "Wifi is on"
         }
         WifiManager.WIFI_STATE_DISABLED ->
         {
             wifiSwitch.isChecked = false
             wifiSwitch.text = "Wifi is off"
         }
     }
        }

    }

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        var intentFilter2  = IntentFilter();
        intentFilter2.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        intentFilter2.addAction(Intent.ACTION_TIMEZONE_CHANGED)
        this.registerReceiver(broadcaseter,intentFilter2)
        this.registerReceiver(wifistatereceviewr,intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcaseter)
        unregisterReceiver(wifistatereceviewr)
    }
}