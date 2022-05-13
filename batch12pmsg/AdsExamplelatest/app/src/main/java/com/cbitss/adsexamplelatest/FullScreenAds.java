package com.cbitss.adsexamplelatest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class FullScreenAds extends AppCompatActivity {
AdRequest adRequest ;
private InterstitialAd minterstitialAd;
    private static final String TAG = "FullScreenAds";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_ads);
MobileAds.initialize(this, new OnInitializationCompleteListener() {
    @Override
    public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
        Toast.makeText(FullScreenAds.this, "device is ready for ads", Toast.LENGTH_SHORT).show();
   adRequest = new AdRequest.Builder().build();
loadadd();
    }
});
    }

    private void loadadd() {


        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                Log.e(TAG, "onAdFailedToLoad: "+ loadAdError.getMessage() );
                minterstitialAd = null;
            }

            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                super.onAdLoaded(interstitialAd);

             minterstitialAd  = interstitialAd;
             if(minterstitialAd != null){

                 minterstitialAd.show(FullScreenAds.this);
                 minterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                     @Override
                     public void onAdClicked() {
                         super.onAdClicked();
                         Log.e(TAG, "onAdClicked: " );
                     }
                 });
             }
                Log.e(TAG, "onAdLoaded: " );
            }
        });
    }
}