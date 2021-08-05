package com.example.parallaxeeffect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Button;

import com.example.parallaxeeffect.fragments.FirstFragment;
import com.example.parallaxeeffect.fragments.SecondFragment;
import com.example.parallaxeeffect.fragments.ThirdFragment;
import com.google.android.material.tabs.TabLayout;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    Toolbar toolbar;
    ViewPager viewPager;
    Button takeoutbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectxml();
        ViewPageAdapter viewPageAdapter = getFragmentadatper();
        viewPager.setAdapter(viewPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition())
                {
                    case 0:
                        new FirstFragment();
                        break;
                    case 1:
                        new SecondFragment();
                        break;
                    case 2:
                        new ThirdFragment();
                        break;
                    case 3:
                        new FirstFragment();
                        break;
                    case 4:
                        new SecondFragment();
                        break;
                    case 5:
                        new ThirdFragment();
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private ViewPageAdapter getFragmentadatper() {
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());
        viewPageAdapter.getfragments(new FirstFragment(),"First");
        viewPageAdapter.getfragments(new SecondFragment(),"Second");
        viewPageAdapter.getfragments(new ThirdFragment(),"Third");
        viewPageAdapter.getfragments(new FirstFragment(),"First");
        viewPageAdapter.getfragments(new SecondFragment(),"Second");
        viewPageAdapter.getfragments(new ThirdFragment(),"Third");
        return viewPageAdapter;
    }

    private void connectxml() {
        takeoutbtn = findViewById(R.id.putlloutbtnbottom);
        tabLayout = findViewById(R.id.tablayout);
        toolbar = findViewById(R.id.home_toolbar);
        viewPager = findViewById(R.id.viewpage);
    }
}