package com.dailydose.lifehackes;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

public class FullScreenImage extends AppCompatActivity {
    ImageView imageView;
    String url;
    int position;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image);
        Toolbar toolbar = findViewById(R.id.fullScreenToolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        imageView = (ImageView) findViewById(R.id.showImage);
        url = String.valueOf(intent.getStringExtra("url"));
        position = getIntent().getIntExtra("position", 0);
        Log.d("LOG_TAG", url);
        Glide.with(this)
                .load(url)
                .into(imageView);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.push_down_in_backpress, R.anim.push_down_out_backpress);
    }

    public void Download(View view) {
        final Vibrator vibe = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        vibe.vibrate(30);
        String name = "Images" + position + ".jpg";
        if (ActivityCompat.checkSelfPermission(FullScreenImage.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(FullScreenImage.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            // this will request for permission when user has not granted permission for the app
            ActivityCompat.requestPermissions(FullScreenImage.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {


            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), name);
            if (file.exists()) {
                Toast.makeText(FullScreenImage.this, "Image Already Downloaded !!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(FullScreenImage.this, "Downloading Start !!!!", Toast.LENGTH_SHORT).show();
                DownloadManager.Request dmr = new DownloadManager.Request(Uri.parse(url));

                dmr.setTitle(name);
                dmr.setDescription("Download"); //optional
                dmr.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, name);
                dmr.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                dmr.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                manager.enqueue(dmr);
            }
            //Download Script
AdsShow();

        }

    }

public void AdsShow()
{
    mInterstitialAd = new InterstitialAd(FullScreenImage.this);
    mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
    mInterstitialAd.loadAd(new AdRequest.Builder().build());
    mInterstitialAd.setAdListener(new AdListener() {
                                      @Override
                                      public void onAdLoaded() {
                                          super.onAdLoaded();
                                          mInterstitialAd.show();
                                      }

                                  }
    );
}
}