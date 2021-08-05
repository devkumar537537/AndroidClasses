package com.example.serviceexample

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class MyService : Service(){
        lateinit var medaplayer:MediaPlayer
    override fun onBind(intent: Intent?): IBinder? {
        return null;
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(applicationContext,"Service Created",Toast.LENGTH_SHORT).show()

        medaplayer = MediaPlayer.create(this,R.raw.mysong)
        medaplayer.isLooping = false
    }

    @Suppress("DEPRECATION")
    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        Toast.makeText(applicationContext,"Service Started",Toast.LENGTH_SHORT).show()
        medaplayer.start();
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext,"Service Stopped",Toast.LENGTH_SHORT).show()
        medaplayer.stop()

    }

}