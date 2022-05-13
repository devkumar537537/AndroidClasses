package com.example.voicerecorder;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.os.Build.VERSION.SDK_INT;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button play, stop, record,pause;
    private MediaRecorder myAudioRecorder;
    private String outputFile;
    MediaPlayer mediaPlayer;
    String[] permissions = {Manifest.permission.ACCESS_MEDIA_LOCATION, WRITE_EXTERNAL_STORAGE,Manifest.permission.RECORD_AUDIO, READ_EXTERNAL_STORAGE,};
    int permissioncode = 124;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connect();

        if(SDK_INT > Build.VERSION_CODES.M)
        {
            if(ActivityCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED)
            {
                requestPermissions(permissions,permissioncode);
            }
        }
        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath()+ "/recording.3gp";
        myAudioRecorder = new MediaRecorder();

        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myAudioRecorder.setOutputFile(getpathdirectory());

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer = new MediaPlayer();

                try {
                    mediaPlayer.setDataSource(getpathdirectory());
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    Toast.makeText(MainActivity.this, "Playing has started", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.pause();
                }else
                {
                    mediaPlayer.start();
                }
            }
        });

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    myAudioRecorder.prepare();
                    myAudioRecorder.start();
                    Toast.makeText(MainActivity.this, "Recording is Started", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudioRecorder.stop();
                myAudioRecorder.release();
                Toast.makeText(MainActivity.this, "Recording Stopped", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!Utils.isPermissionGranted(this))
        {
            new AlertDialog.Builder(this)
                    .setTitle("All Files permission")
                    .setMessage("Due to android 11 the file permission required by the app at runtime ok")
                    .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                             takepermssion();
                        }
                    })
                    .setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }else
        {
            Toast.makeText(getApplicationContext(), "permission already granted here", Toast.LENGTH_SHORT).show();
        }
    }

    private void takepermssion() {
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.R)
        {
            try {
                Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                intent.addCategory("android.intent.category.DEFAULT");
                Uri uri = Uri.fromParts("package",getPackageName(),null);
                intent.setData(uri);
              //  startActivityForResult(intent,1122);
                requestpermissionlanucher.launch(intent);
            }catch (Exception e)
            {
                e.printStackTrace();
                Intent intent =new Intent();
                intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                requestpermissionlanucher.launch(intent);
               // startActivityForResult(intent,1122);
            }
        }else
        {
            if(SDK_INT > Build.VERSION_CODES.M)
            {
                if(ActivityCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED)
                {
                    requestPermissions(permissions,permissioncode);
                }
            }
        }
    }
    ActivityResultLauncher<Intent> requestpermissionlanucher= registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                 if(result.getResultCode() == Activity.RESULT_OK)
                 {
                     Toast.makeText(getApplicationContext(), "permission granted", Toast.LENGTH_SHORT).show();
                 }
                }
            }
    );
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length>0)
        {
            if(requestCode == 101)
            {
                boolean readExt = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                if(!readExt)
                {
                    takepermssion();
                }
            }
        }
    }

    public void connect()
    {
        play =  findViewById(R.id.play);
        stop = findViewById(R.id.stop);
        record =  findViewById(R.id.record);
        pause = findViewById(R.id.pause);
    }
    private String getpathdirectory()
    {
        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        File musicdirectory = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File file = new File(musicdirectory,"testrecordingfile "+".mp3");
        return file.getPath();

    }
}