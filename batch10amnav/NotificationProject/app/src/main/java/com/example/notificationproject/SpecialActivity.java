package com.example.notificationproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.RemoteInput;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

public class SpecialActivity extends AppCompatActivity {

    String firstvlaue,secondvalue;
    TextView textView;
    String message="some";
    private static final String TAG = "SpecialActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special);
        if(getIntent() != null)
        {
//            Bundle bundle = RemoteInput.getResultsFromIntent(getIntent());
//            String message = bundle.getCharSequence("txtrply").toString();
//            textView =findViewById(R.id.textView);
//            textView.setText(message);
//            Log.e(TAG, "onCreate: "+message);
            message = getIntent().getStringExtra("play_text");
        }
if(message.equals("play"))
{
    MediaPlayer mediaPlayer =  MediaPlayer.create(getApplicationContext(),R.raw.mysong);
  mediaPlayer.start();


}
    }
}