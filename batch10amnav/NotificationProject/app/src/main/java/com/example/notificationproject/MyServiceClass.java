package com.example.notificationproject;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;

import java.io.IOException;
import java.security.Provider;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MyServiceClass extends Service {

    MediaPlayer mediaPlayer;
    boolean res = false;


    private static final String CHANNEL_ID = "technicalGuyes";
    CharSequence name = "my_channel";
    String Description = "This is my channel";
    private final int NOTIFICATION_ID = 201;


    IBinder mybinder = new MyLocalBinder();


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mybinder;
    }

    public class MyLocalBinder extends Binder {
        MyServiceClass getService() {
            return MyServiceClass.this;
        }
    }

    public void startmedia()
    {
        mediaPlayer = new MediaPlayer();
         mediaPlayer = MediaPlayer.create(this,R.raw.mysong);
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
    public void createnotification(){
        NotificationManager notificationManager =(NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            int improtance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mchannel = new NotificationChannel(CHANNEL_ID,name,improtance);
            mchannel.setDescription(Description);
            mchannel.enableLights(true);
            mchannel.enableVibration(true);
            mchannel.setVibrationPattern(new long[]{100,200,300,400,500,400,300,200,400});
            notificationManager.createNotificationChannel(mchannel);
        }

        RemoteInput remoteInput =new RemoteInput.Builder("txtrply").setLabel("Reply").build();
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this,CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.stat_notify_missed_call)
                        .setContentTitle("Missed Call")
                        .setContentText("You have terrorist call")
                        .setAutoCancel(true)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Intent yesReceiveintent = new Intent(getApplicationContext(),SpecialActivity.class);
        PendingIntent pendingIntentYes = PendingIntent.getActivity(this, NOTIFICATION_ID,yesReceiveintent, PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Action action = new NotificationCompat.Action.Builder(android.R.drawable.ic_dialog_alert,"Reply",pendingIntentYes).addRemoteInput(remoteInput).build();
        Intent secondaction =new Intent(getApplicationContext(),SpecialActivity.class);
        secondaction.putExtra("play_text","play");

        PendingIntent pendingIntenttwo =PendingIntent.getActivity(this,23,secondaction,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Action action1 =new NotificationCompat.Action.Builder(android.R.drawable.ic_media_play,"Play",pendingIntenttwo).build();
        builder.addAction(action1);
        builder.addAction(action);

        notificationManager.notify(NOTIFICATION_ID,builder.build());
    }
}
