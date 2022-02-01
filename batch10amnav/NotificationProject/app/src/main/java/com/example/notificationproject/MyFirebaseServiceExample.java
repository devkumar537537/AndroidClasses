package com.example.notificationproject;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseServiceExample extends FirebaseMessagingService {


    private static final String CHANNEL_ID = "technicalGuyes";
    CharSequence name = "my_channel";
    String Description = "This is my channel";
    private final int NOTIFICATION_ID = 201;
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if(remoteMessage.getNotification() != null)
        {



            String title = remoteMessage.getNotification().getTitle();
            String body = remoteMessage.getNotification().getBody();



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


            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(this,CHANNEL_ID)
                            .setSmallIcon(android.R.drawable.stat_notify_missed_call)
                            .setContentTitle(title)
                            .setContentText(body)
                            .setAutoCancel(true)

                            .setPriority(NotificationCompat.PRIORITY_DEFAULT);




            Intent yesReceiveintent = new Intent(getApplicationContext(),SpecialActivity.class);
            if(remoteMessage.getData().size() > 0)
            {
                for(String key : remoteMessage.getData().keySet())
                {
                    if(key.equals("title"))
                    {
                       yesReceiveintent.putExtra("mymsgone",remoteMessage.getData().get(key));
                    }

                    if(key.equals("url"))
                    {
                        yesReceiveintent.putExtra("mymsgtwo",remoteMessage.getData().get(key));
                    }

                    Log.e("servictag","onMessageRecieved: Data : "+remoteMessage.getData().toString());
                }
            }



            PendingIntent pendingIntentYes = PendingIntent.getActivity(this, NOTIFICATION_ID,yesReceiveintent, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pendingIntentYes);
            notificationManager.notify(NOTIFICATION_ID,builder.build());

        }
    }
}
