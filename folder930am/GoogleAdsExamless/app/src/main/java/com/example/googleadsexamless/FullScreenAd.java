package com.example.googleadsexamless;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class FullScreenAd extends AppCompatActivity {
    private InterstitialAd minterstitialAd;
    private static final String TAG = "InterestialAddss";
    TextView textView;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_ad);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {


            }
        });

        AdRequest adIRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712",adIRequest,new InterstitialAdLoadCallback(){
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                progressBar.setVisibility(View.GONE);
                textView.setText("Some Error occured");
                Toast.makeText(FullScreenAd.this, "some error"+loadAdError.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                super.onAdLoaded(interstitialAd);
                Toast.makeText(FullScreenAd.this, "Ad initialsed", Toast.LENGTH_SHORT).show();
                minterstitialAd = interstitialAd;
                if(minterstitialAd != null)
                {
                    minterstitialAd.show(FullScreenAd.this);
                }
                progressBar.setVisibility(View.GONE);
                textView.setText("Thanks for watching");
            }
        });
    }
}