package com.example.voicerecorder.newpackage;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.voicerecorder.MainActivity;

import java.io.IOException;

public class MyCallService extends Service {

    private MediaRecorder myAudioRecorder;
    private String outputFile;
    MediaPlayer mediaPlayer;
    IBinder mybinder = new MyLocalBinder();


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mybinder;
    }

    public class MyLocalBinder extends Binder {
        MyCallService getService() {
            return MyCallService.this;
        }
    }

    public void startmedia()
    {
        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath()+ "/recording.3gp";
        myAudioRecorder = new MediaRecorder();
        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myAudioRecorder.setOutputFile(outputFile);
    }
    public void playsong()
    {
        mediaPlayer = new MediaPlayer();

        try {
            mediaPlayer.setDataSource(outputFile);
            mediaPlayer.prepare();
            mediaPlayer.start();
            Toast.makeText(this, "Playing has started", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void pausmedia(){
        if(mediaPlayer.isPlaying())
        {
            mediaPlayer.pause();
        }else
        {
            mediaPlayer.start();
        }
    }
    public  void startrecording()
    {
        try {
            myAudioRecorder.prepare();
            myAudioRecorder.start();
            Toast.makeText(this, "Recording is Started", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void stoprecording(){
        myAudioRecorder.stop();
        myAudioRecorder.release();
        Toast.makeText(this, "Recording Stopped", Toast.LENGTH_SHORT).show();
    }
}
