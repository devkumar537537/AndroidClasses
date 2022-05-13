package com.cbitss.adsexamplelatest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    Button movetofllscreen,movetovideoadd;
    AdRequest adRequest;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdView = findViewById(R.id.adView);
        movetofllscreen = findViewById(R.id.movetofullscreen);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
                Toast.makeText(MainActivity.this, "device is ready for showing ads", Toast.LENGTH_SHORT).show();
            adRequest = new AdRequest.Builder().build();

            mAdView.loadAd(adRequest);

            }
        });


        if(mAdView != null)
        {
            mAdView.setAdListener(new AdListener() {
                @Override
                public void onAdClicked() {
                    super.onAdClicked();
                    Log.e(TAG, "onAdClicked: " );
                }

                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    Log.e(TAG, "onAdClosed: " );
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.e(TAG, "onAdFailedToLoad: ");
                }

                @Override
                public void onAdImpression() {
                    super.onAdImpression();
                    Log.e(TAG, "onAdImpression: " );
                }

                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    Log.e(TAG, "onAdLoaded: ");
                }

                @Override
                public void onAdOpened() {
                    super.onAdOpened();
                    Log.e(TAG, "onAdOpened: " );
                }
            });


        }
        movetofllscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,FullScreenAds.class));
            }
        });

    }
}