package com.example.androidnotification;

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

public class MyNotificationServices extends FirebaseMessagingService {

    private static final String CHANNEL_ID = "technicalGuyes";
    CharSequence name = "my_channel";
    String Description = "This is my channel";
    private final int NOTIFICATION_ID = 201;
    Context context;
    @Override
    public void onMessageReceived( RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        if(remoteMessage.getNotification() != null)
        {
            String title = remoteMessage.getNotification().getTitle();
            String body = remoteMessage.getNotification().getBody();

            NotificationManager notificationManager =  (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
            if(Build.VERSION.SDK_INT > Build.VERSION_CODES.O)
            {
                int importance = NotificationManager.IMPORTANCE_HIGH;

                NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);

                mChannel.setDescription(Description);
                mChannel.enableLights(true);

                mChannel.enableVibration(true);
                mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                notificationManager.createNotificationChannel(mChannel);


            }

            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(this,CHANNEL_ID)
                            .setSmallIcon(android.R.drawable.ic_notification_clear_all) //set icon for notification
                            .setContentTitle(title) //set title of notification
                            .setContentText(body)//this is notification message
                            .setAutoCancel(true)// makes auto cancel of notification
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            Intent intent = new Intent(this,AfterNotificationActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            if(remoteMessage.getData().size() > 0)
            {
                for(String key: remoteMessage.getData().keySet())
                {
                    if(key.equals("title"))
                    {
                        intent.putExtra("myvalue",remoteMessage.getData().get(key));
                    }

                }

                Log.d("servictag","onMessageRecieved: Data : "+remoteMessage.getData().toString());
            }

            PendingIntent pendingIntent = PendingIntent.getActivity(this,123,intent,PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pendingIntent);
            notificationManager.notify(123,builder.build());


        }
    }
}
