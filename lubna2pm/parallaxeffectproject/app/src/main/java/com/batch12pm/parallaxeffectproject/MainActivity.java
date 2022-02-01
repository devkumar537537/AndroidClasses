package com.batch12pm.parallaxeffectproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.batch12pm.parallaxeffectproject.fragements.FirstFragment;
import com.batch12pm.parallaxeffectproject.fragements.SecondFragment;
import com.batch12pm.parallaxeffectproject.fragements.ThirdFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;


    Button openbottomsheet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpage);
        tabLayout = findViewById(R.id.tablayout);
        openbottomsheet = findViewById(R.id.openbtoomsheet);

        ViewPagerADapter viewPagerADapter = getpagerADapter();

        viewPager.setAdapter(viewPagerADapter);
        tabLayout.setupWithViewPager(viewPager);
openbottomsheet.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        BottomSheetExample bottomSheet = new BottomSheetExample();


        bottomSheet.show(getSupportFragmentManager(),"MyBottomSheet");
    }
});

    }

    private ViewPagerADapter getpagerADapter() {
        ViewPagerADapter viewPagerADapter = new ViewPagerADapter(getSupportFragmentManager());
        viewPagerADapter.getfragtitle(new FirstFragment(),"First");
        viewPagerADapter.getfragtitle(new SecondFragment(),"Second");
        viewPagerADapter.getfragtitle(new ThirdFragment(),"Third");
        viewPagerADapter.getfragtitle(new FirstFragment(),"First");
        viewPagerADapter.getfragtitle(new SecondFragment(),"Second");
        viewPagerADapter.getfragtitle(new ThirdFragment(),"Third");
        return viewPagerADapter;

    }
}