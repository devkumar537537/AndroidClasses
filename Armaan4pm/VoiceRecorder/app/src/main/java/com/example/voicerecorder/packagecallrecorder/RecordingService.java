package com.example.voicerecorder.packagecallrecorder;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.format.DateFormat;

import androidx.annotation.Nullable;

import java.io.File;

import java.io.IOException;
import java.util.Date;

public class RecordingService extends Service {
    private MediaRecorder mediaRecorder;
    private boolean recordstarted;
    private File file;
    String path = "sdcard/alarms";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS);
        Date date =new Date();
        CharSequence sdf = DateFormat.format("MM-dd-yy-hh-mm-ss",date.getTime());
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioSource.VOICE_CALL);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(file.getAbsoluteFile()+"/"+sdf+"rec.3gp");
        TelephonyManager telephonyManager =(TelephonyManager) getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);

     telephonyManager.listen(new PhoneStateListener(){
         @Override
         public void onCallStateChanged(int state, String phoneNumber) {

if(TelephonyManager.CALL_STATE_IDLE == state && mediaRecorder ==null)
{
    mediaRecorder.stop();
    mediaRecorder.reset();
    mediaRecorder.release();
    recordstarted = false;
    stopSelf();
}else if(TelephonyManager.CALL_STATE_OFFHOOK == state)
{
    try {
        mediaRecorder.prepare();
        mediaRecorder.start();
         recordstarted = true;
    } catch (IOException e) {
        e.printStackTrace();
    }

}
             }

     },PhoneStateListener.LISTEN_CALL_STATE);

        return START_STICKY;
    }
}
