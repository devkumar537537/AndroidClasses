package com.dailydose.lifehackes;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class QuotesShowActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<QuotsShowItems> quotsShowItems = new ArrayList<>();
    Toolbar toolbar;
    String[] quote;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes_show);


//        Tool Bar SetUp
        toolbar = findViewById(R.id.quotesShowToolBar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextAppearance(this, R.style.RobotoBoldTextAppearance);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
//        RecyclerView SetUp
        recyclerView = findViewById(R.id.quotesShowRecyclerView);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        int position = bundle.getInt("position");
        String title = bundle.getString("title");
        toolbar.setTitle(title);
        SetData(position, title);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adViewQuotes);
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

    public void SetData(int position, String title) {
        String str = title;
        String[] stringname = str.split("\\s+");
        int resourceId = getResources().getIdentifier(stringname[0], "array",
                this.getPackageName());
        quote = QuotesShowActivity.this.getResources().getStringArray(resourceId);
        for (String s : quote) {
            quotsShowItems.add(new QuotsShowItems(s));
        }
        SetAdapter(quotsShowItems);
    }


    public void SetAdapter(List<QuotsShowItems> quotsShowItems) {
        QuotesShowAdapter quotesShowAdapter = new QuotesShowAdapter(this, quotsShowItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();
        recyclerView.setAdapter(quotesShowAdapter);


    }

}