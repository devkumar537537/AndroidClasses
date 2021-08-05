package com.example.parallaxeffecrt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Button;

import com.example.parallaxeffecrt.fragments.FirstFragment;
import com.example.parallaxeffecrt.fragments.SecondFragment;
import com.example.parallaxeffecrt.fragments.ThirdFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    TabLayout tabLayout;
    Toolbar toolbar;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectxml();



        ViewPagerAdapter viewPagerAdapter = getPagerAdapter();



        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

    private ViewPagerAdapter getPagerAdapter() {
        ViewPagerAdapter viewPageAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPageAdapter.addFragment(new FirstFragment(),"First");
        viewPageAdapter.addFragment(new SecondFragment(),"Second");
        viewPageAdapter.addFragment(new ThirdFragment(),"Third");
        viewPageAdapter.addFragment(new FirstFragment(),"First");
        viewPageAdapter.addFragment(new SecondFragment(),"Second");
        viewPageAdapter.addFragment(new ThirdFragment(),"Third");
        return viewPageAdapter;
    }

    private void connectxml() {

        tabLayout = findViewById(R.id.tablayout);
        toolbar = findViewById(R.id.home_toolbar);
        viewPager = findViewById(R.id.viewpage);
    }
}