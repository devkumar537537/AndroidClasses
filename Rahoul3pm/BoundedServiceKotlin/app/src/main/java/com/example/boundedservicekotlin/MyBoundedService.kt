package com.example.boundedservicekotlin

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder

class MyBoundedService(): Service() {
    lateinit var mediaPlayer: MediaPlayer
    var res = false



    private val myBinder: IBinder = MyBounderClass()

    override fun onBind(p0: Intent?): IBinder? {
          return myBinder

    }

    fun startsone()
    {
mediaPlayer = MediaPlayer.create(applicationContext,R.raw.song)
        mediaPlayer.start()
    }

    fun paussong()
    {
        res = if (res == true) {
            mediaPlayer.pause()
            false
        } else {
            mediaPlayer.start()
            true
        }
    }

    fun resetsong()
    {

        mediaPlayer.stop()
        mediaPlayer.release()
    }

inner class MyBounderClass :Binder(){
    fun getbinder():MyBoundedService{
              return  this@MyBoundedService
    }
}
}

