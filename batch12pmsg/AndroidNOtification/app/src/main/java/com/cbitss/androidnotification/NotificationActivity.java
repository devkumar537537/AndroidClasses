package com.cbitss.androidnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.RemoteInput;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {
String value = "324";
String replytext="right";
String playtext="some";
TextView textView,replyview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        textView = findViewById(R.id.notificationtextview);
        replyview = findViewById(R.id.replyview);
        if (getIntent() != null)
        {

//                        Bundle bundle1 = RemoteInput.getResultsFromIntent(getIntent());
//                        replytext = bundle1.getString("textReply");

           // value = getIntent().getStringExtra("message");
            playtext = getIntent().getStringExtra("Right");

        }

        textView.setText(value);
        replyview.setText(replytext);
        if(playtext.equals("play"))
        {
            MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.mysong);
            mediaPlayer.start();
        }else
        {
            replyview.setText(playtext);
        }
    }
}