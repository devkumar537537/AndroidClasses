package com.cbitss.serviceexample;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyServiceExample extends Service {
    public static final String CHANNELID="channleid";
MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
        mediaPlayer = MediaPlayer.create(this,R.raw.song);
        mediaPlayer.start();
    }
public void pause(){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }else
        {
            mediaPlayer.start();
        }
}

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        NotificationManager notificationManager =(NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {

            NotificationChannel nfchannel = new NotificationChannel(CHANNELID,"sometghing",NotificationManager.IMPORTANCE_DEFAULT);
            nfchannel.setDescription("Music Player");
            nfchannel.enableLights(true);
            nfchannel.enableVibration(true);
            nfchannel.setVibrationPattern(new long[]{100,200,300,400,500,400,300,200,400});
            notificationManager.createNotificationChannel(nfchannel);
        }

        NotificationCompat.Builder notification = new NotificationCompat.Builder(this,CHANNELID)
                .setSmallIcon(android.R.drawable.ic_media_play)

                .setContentTitle("Service")
                .setContentText("Service is running")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        startForeground(12,notification.build());
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Stop", Toast.LENGTH_SHORT).show();
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
    }
}
