package com.example.myapplcationads;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class RewardedAdExample extends AppCompatActivity {
    Button button;

    private static final String TAG = "RewardedAdExample";
    private RewardedAd mrewardedAd;
    ProgressBar progressBar;
    AdRequest adRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewarded_ad);

        button = findViewById(R.id.showvideobtn);
        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);

        adRequest = new AdRequest.Builder().build();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadadd();

                if(mrewardedAd != null)
                {
                    Activity activitycontext = RewardedAdExample.this;
                    mrewardedAd.show(activitycontext, new OnUserEarnedRewardListener() {
                        @Override
                        public void onUserEarnedReward( RewardItem rewardItem) {
                            Log.e(TAG, "The user earned the reward" );
                            int rewardamount = rewardItem.getAmount();
                            String rewardTyep = rewardItem.getType();
                            Log.e(TAG, "amount is => "+rewardamount +" and type is => "+rewardTyep );

                        }
                    });

                }
            }
        });
    }

    private void loadadd() {
        RewardedAd.load(this, "ca-app-pub-3940256099942544/5224354917", adRequest, new RewardedAdLoadCallback() {
            @Override
            public void onAdLoaded( RewardedAd rewardedAd) {
                super.onAdLoaded(rewardedAd);
                mrewardedAd = rewardedAd;

                Log.e(TAG, "onAdLoaded: ");
                progressBar.setVisibility(View.GONE);
                Toast.makeText(RewardedAdExample.this, "Show the add now", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad( LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                Log.e(TAG, loadAdError.getMessage() );
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}