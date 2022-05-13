package com.example.notificationproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
Button producenotfification;
TextView notificationtext;

    private static final String TAG = "MainActivity";

    private static final String CHANNEL_ID = "technicalGuyes";
    CharSequence name = "my_channel";
    String Description = "This is my channel";
    private final int NOTIFICATION_ID = 201;
    Context context;
    Bitmap image;
    URL url;
    boolean isBound = true;
    MyServiceClass myBoundedService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        notificationtext = findViewById(R.id.noatificationetext);
        producenotfification = findViewById(R.id.notificationbutton);
        Intent intent = new Intent(this, MyServiceClass.class);
        bindService(intent,myConnection,Context.BIND_AUTO_CREATE);
        producenotfification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              createnownotification();
            }
        });


        if(getIntent() != null && getIntent().hasExtra("title"))
        {

            for(String key : getIntent().getExtras().keySet())
            {
                Log.e(TAG, "key => "+key+"  value  is "+getIntent().getExtras().getString(key) );
            }
        }

    }

    private void createnownotification() {



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

    public static Bitmap getBitmapFromVectorDrawable(Context context, int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
        MyServiceClass.MyLocalBinder binder = (MyServiceClass.MyLocalBinder) service;
            myBoundedService = binder.getService();
            isBound = true;
           myBoundedService.createnotification();
            Toast.makeText(myBoundedService, "service connected", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            isBound = false;
            Toast.makeText(myBoundedService, "service false", Toast.LENGTH_SHORT).show();
        }
    };
}