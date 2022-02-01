package com.example.parallaxedffetcin12pmexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.parallaxedffetcin12pmexample.fragements.FirstFragment;
import com.example.parallaxedffetcin12pmexample.fragements.SecondFragment;
import com.example.parallaxedffetcin12pmexample.fragements.ThirdFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    Button pulloutbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpage);
        tabLayout = findViewById(R.id.tablayout);
pulloutbtn =findViewById(R.id.putlloutbtnbottom);
        CustomFragmentAdapter customFragmentAdapter = getAdapter();

        viewPager.setAdapter(customFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        pulloutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetExample bottomSheetExample = new BottomSheetExample();
                bottomSheetExample.show(getSupportFragmentManager(),"MyBottomSheet");
            }
        });
    }
    public CustomFragmentAdapter getAdapter()
    {
        CustomFragmentAdapter customFragmentAdapter = new CustomFragmentAdapter(getSupportFragmentManager());
        customFragmentAdapter.getfragment(new FirstFragment(),"First");
        customFragmentAdapter.getfragment(new SecondFragment(),"Second");
        customFragmentAdapter.getfragment(new ThirdFragment(),"Third");
        customFragmentAdapter.getfragment(new FirstFragment(),"First");
        customFragmentAdapter.getfragment(new SecondFragment(),"Second");
        customFragmentAdapter.getfragment(new ThirdFragment(),"Third");
        customFragmentAdapter.getfragment(new FirstFragment(),"First");
        customFragmentAdapter.getfragment(new SecondFragment(),"Second");
        customFragmentAdapter.getfragment(new ThirdFragment(),"Third");

        return customFragmentAdapter;
    }
}