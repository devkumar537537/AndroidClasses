package com.dailydose.lifehackes;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BottomNavigationView bottomNavigationView;
    List<HomeItems> homeItems = new ArrayList<>();
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdView = findViewById(R.id.adView);
        Toolbar toolbar = findViewById(R.id.homeToolBar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextAppearance(this, R.style.RobotoBoldTextAppearance);
        recyclerView = findViewById(R.id.homeRecyclerView);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

//        Change Colour Of System Navigation Buttons
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
        //        Add items to RecyclerView
        AddItems();

        HomeRecyclerViewAdapter homeRecyclerViewAdapter = new HomeRecyclerViewAdapter(this, this, homeItems);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.hasFixedSize();
        recyclerView.setAdapter(homeRecyclerViewAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 && bottomNavigationView.isShown()) {
                    Animation aniFade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
                    bottomNavigationView.startAnimation(aniFade);
                    bottomNavigationView.setVisibility(View.GONE);
                } else if (dy < 0 && !bottomNavigationView.isShown()) {
                    Animation aniFade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
                    bottomNavigationView.startAnimation(aniFade);
                    bottomNavigationView.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                super.onScrollStateChanged(recyclerView, newState);
            }
        });

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
//       Working Of Bottom Navigation Bar
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bhome:
                        break;

                    case R.id.bvideo:
                        Toast toast = Toast.makeText(MainActivity.this, "Video Status Coming Soon...", Toast.LENGTH_SHORT);
                        View view = toast.getView();
                        toast.setView(view);
                        TextView text = (TextView) view.findViewById(android.R.id.message);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            text.setTextAppearance(R.style.toastTextStyle);
                        }
                        toast.setGravity(Gravity.BOTTOM, 0, 100);
                        toast.show();
                        break;
                    case R.id.bfavrouit:
                        Intent a = new Intent(MainActivity.this, FavriotQuotesActivity.class);
                        startActivity(a);
                        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
                        break;
                    case R.id.bsetting:
                        Intent b = new Intent(MainActivity.this, SettingActivity.class);
                        startActivity(b);
                        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
                        break;
                }
                return false;
            }
        });

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

    }

    public void AddItems() {
        homeItems.add(new HomeItems("Technology", R.drawable.technology));
        homeItems.add(new HomeItems("Food and Drinks", R.drawable.food));
        homeItems.add(new HomeItems("Health and Fitness", R.drawable.health));
        homeItems.add(new HomeItems("Money Saver", R.drawable.money));
        homeItems.add(new HomeItems("Ridiculous", R.drawable.ridiculous));
        homeItems.add(new HomeItems("Life", R.drawable.life));
        homeItems.add(new HomeItems("Party", R.drawable.party));
        homeItems.add(new HomeItems("Survivial", R.drawable.survival));
        homeItems.add(new HomeItems("Brainy", R.drawable.brain));
        homeItems.add(new HomeItems("Daily Life Solutions", R.drawable.solutions));
        homeItems.add(new HomeItems("Extras", R.drawable.extras));
        homeItems.add(new HomeItems("Nature Disasters", R.drawable.desaster));
        homeItems.add(new HomeItems("Self Defence", R.drawable.defence));
        homeItems.add(new HomeItems("Travel", R.drawable.travel));
        homeItems.add(new HomeItems("Study Effective", R.drawable.study));
        homeItems.add(new HomeItems("Flirt Girl", R.drawable.flirty));
        homeItems.add(new HomeItems("General", R.drawable.general));
        homeItems.add(new HomeItems("Relationship", R.drawable.relationship));
        homeItems.add(new HomeItems("StudyBoosters", R.drawable.booster));
        homeItems.add(new HomeItems("Parenting", R.drawable.parenting));
        homeItems.add(new HomeItems("MoneyMaking", R.drawable.money_making));
        homeItems.add(new HomeItems("Home Decor", R.drawable.home_decor));
        homeItems.add(new HomeItems("Hacks For Girls", R.drawable.hacks_for_girls));
        homeItems.add(new HomeItems("Grand Parenting", R.drawable.grand_parenting));
        homeItems.add(new HomeItems("Clothing", R.drawable.clothing));
        homeItems.add(new HomeItems("Summer Hacks", R.drawable.summer_hacks));
        homeItems.add(new HomeItems("Winter Hacks", R.drawable.winter_hacks));
        homeItems.add(new HomeItems("Gardening", R.drawable.gardening));
        homeItems.add(new HomeItems("Communication", R.drawable.communication));
        homeItems.add(new HomeItems("Productivity", R.drawable.productivity));
        homeItems.add(new HomeItems("Motivation", R.drawable.motivation));
        homeItems.add(new HomeItems("Office Work", R.drawable.office_work));
        homeItems.add(new HomeItems("Pet", R.drawable.pet));
        homeItems.add(new HomeItems("Car Hackes", R.drawable.car_hacks));
    }
}
