package com.dailydose.lifehackes;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ShareCompat;


public class SettingActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView imageView;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));

        toolbar = findViewById(R.id.settingToolBar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextAppearance(this, R.style.RobotoBoldTextAppearance);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adViewQuotesSetting);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
                                  @Override
                                  public void onAdLoaded() {
                                      super.onAdLoaded();
                                      mAdView.setVisibility(View.VISIBLE);
                                  }
                              }
        );
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.push_down_in_backpress, R.anim.push_down_out_backpress);

    }

    public void ContactUs(View view) {


        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "anshulthakurhp29@gmail.com"));
            intent.putExtra(Intent.EXTRA_TEXT, "");
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            //TODO smth
        }


    }

    public void RateUs(View view) {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
        }

    }

    public void ShearUs(View view) {

        ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setChooserTitle("Life Hacks")
                .setText("http://play.google.com/store/apps/details?id=" + this.getPackageName())
                .startChooser();
    }



    public void About(View view) {
        imageView = findViewById(R.id.profileImage);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(view.getContext()).inflate(R.layout.profile_card_view, viewGroup, false);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void Instagram(View view) {

        Uri uri = Uri.parse("https://www.instagram.com/anshul_anshu_/?fbclid=IwAR2IqTxGYYNkGQSwFPkYLJuAwaOeOrt_15zBD-w8hIfUuHDm28gkupFcQ-E");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/xxx")));
        }
    }

    public void Facebook(View view) {

        Intent intent = null;
        try {
            getPackageManager().getPackageInfo("com.facebook.katana", 0);
            String url = "https://www.facebook.com/profile.php?id=100040261951264.co";
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href=" + url));
        } catch (Exception e) {
            // no Facebook app, revert to browser
            String url = "https://www.facebook.com/profile.php?id=100040261951264.co";
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
        }
        startActivity(intent);

    }

    public void Whatsapp(View view) {
        String url = "https://api.whatsapp.com/send?phone=" + "+918219518557";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}