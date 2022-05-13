package com.cbitss.androidnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button produceNotification;
public static final String CAHANNEL_ID="My channel";
public static final String CHANNEL_NAME="My channel name";
public static final String CHANNEL_DES="DEscription";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        produceNotification =findViewById(R.id.prodoucenotification);

        produceNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createnotification();
            }
        });
    }

    private void createnotification() {
        NotificationManager notificationManager =(NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
         if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
         {

             NotificationChannel nfchannel = new NotificationChannel(getString(R.string.Channel_ID),getString(R.string.Channel_Nmae),NotificationManager.IMPORTANCE_DEFAULT);
             nfchannel.setDescription(CHANNEL_DES);
             nfchannel.enableLights(true);
             nfchannel.enableVibration(true);

             nfchannel.setVibrationPattern(new long[]{100,200,300,400,500,400,300,200,400});
             notificationManager.createNotificationChannel(nfchannel);
         }
         View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.custom_notfication,null);
        RemoteViews remoteViews = new RemoteViews(getPackageName(),R.layout.custom_notfication);


         NotificationCompat.Builder notification = new NotificationCompat.Builder(this,CAHANNEL_ID)
                 .setSmallIcon(R.drawable.notfication_small)
                 .setLargeIcon(getBitmapFromVectorDrawable(getApplicationContext(),R.drawable.notification_big))
                 .setContentTitle("Testing")
                 .setContentText("this is just for testing")
                 .setAutoCancel(true)
                 .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                 .setCustomContentView(remoteViews)
                 .setPriority(NotificationCompat.PRIORITY_DEFAULT);

         Intent intent =new Intent(getApplicationContext(),NotificationActivity.class);
        intent.putExtra("message","this is sample message");

        Intent replyintent= new Intent(getApplicationContext(),NotificationActivity.class);
        PendingIntent pendingIntentreply = PendingIntent.getActivity(this,13,replyintent, PendingIntent.FLAG_UPDATE_CURRENT);

        RemoteInput remoteInput = new RemoteInput.Builder("textReply").setLabel("Your Reply").build();

        NotificationCompat.Action action = new NotificationCompat.Action.Builder(android.R.drawable.ic_media_play,"Reply",pendingIntentreply).addRemoteInput(remoteInput).build();

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),12,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);


        Intent secondaction =new Intent(getApplicationContext(),NotificationActivity.class);
        secondaction.putExtra("play_text","play");



        PendingIntent pendingIntenttwo =PendingIntent.getActivity(this,23,secondaction,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Action action1 =new NotificationCompat.Action.Builder(android.R.drawable.ic_media_play,"Play",pendingIntenttwo).build();

Intent intent1 = new Intent(MainActivity.this,NotificationActivity.class);
intent1.putExtra("Right","I am from notification");
PendingIntent pendingIntent1 = PendingIntent.getActivity(getApplicationContext(),34,intent1,PendingIntent.FLAG_UPDATE_CURRENT);

        notification.addAction(action1);
        notification.addAction(action);
        remoteViews.setOnClickPendingIntent(R.id.btn,pendingIntent1);
         notificationManager.notify(12,notification.build());


    }

    public static Bitmap getBitmapFromVectorDrawable(Context context, int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }

        Bitmap bitmap =Bitmap.createBitmap(drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0,0,canvas.getWidth(),canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
//
    }
}