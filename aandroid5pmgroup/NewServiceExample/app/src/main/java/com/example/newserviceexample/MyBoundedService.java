package com.example.newserviceexample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MyBoundedService extends Service {

    MediaPlayer mediaPlayer;

    private final IBinder myBinder = new MyLocalBinder();

    boolean res =false;
    String start;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public MyBoundedService()
    {

    }

    public class MyLocalBinder extends Binder {

        MyBoundedService getServics()
        {

            return MyBoundedService.this;
        }
    }

    public void startmedia()
    {
        mediaPlayer = MediaPlayer.create(this,R.raw.song);
        mediaPlayer.start();

    }
    public void pausemedia()
    {
        if( res == true)
        {
            mediaPlayer.pause();
            res = false;
        }else
        {
            mediaPlayer.start();
            res = true;
        }
    }
    public void reset(){
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}
