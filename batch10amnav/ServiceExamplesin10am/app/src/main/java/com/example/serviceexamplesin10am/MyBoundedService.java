package com.example.serviceexamplesin10am;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyBoundedService extends Service {
    MediaPlayer mediaPlayer;
    boolean res = false;
   String audioUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";


  private final IBinder myBinder = new MyLocalBinder();

   IBinder mybinder = new MyLocalBinder();


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mybinder;
    }

    public class MyLocalBinder extends Binder {
        MyBoundedService getService() {
            return MyBoundedService.this;
        }
    }
    public String getCurrentTime() {
        SimpleDateFormat dateformat =
                new SimpleDateFormat("HH:mm:ss MM/dd/yyyy",
                        Locale.US);
        return (dateformat.format(new Date()));

    }
    public void startmedia()
    {
        mediaPlayer = new MediaPlayer();
       // mediaPlayer = MediaPlayer.create(this,R.raw.song);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            mediaPlayer.setDataSource(audioUrl);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


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
