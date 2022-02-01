package com.example.notificationproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        producenotfification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createnotification();
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

    private void createnotification() {


        try {
             url = new URL("https://picsum.photos/200/300");
             image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch(IOException e) {
            System.out.println(e);
        }
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
                .setContentTitle("Missed Call")
                .setContentText("You have terrorist call")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        Glide.with(getApplicationContext())
                .asBitmap()
                .load("https://picsum.photos/200/300")
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        //largeIcon
                        builder.setLargeIcon(resource);





                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {
                        builder.setLargeIcon(getBitmapFromVectorDrawable(getApplicationContext(), android.R.drawable.star_on));
                    }
                });
       Intent yesReceiveintent = new Intent(getApplicationContext(),SpecialActivity.class);

    PendingIntent pendingIntentYes = PendingIntent.getActivity(this, NOTIFICATION_ID,yesReceiveintent, PendingIntent.FLAG_UPDATE_CURRENT);
builder.setContentIntent(pendingIntentYes);
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
}