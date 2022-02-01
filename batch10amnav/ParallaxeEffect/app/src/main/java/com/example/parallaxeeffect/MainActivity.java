package com.example.parallaxeeffect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.parallaxeeffect.fragements.FirstFragment;
import com.example.parallaxeeffect.fragements.SecondFragment;
import com.example.parallaxeeffect.fragements.ThirdFragment;
import com.google.android.material.tabs.TabLayout;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout  tabLayout;
    Button openbottomsheet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpage);
        tabLayout = findViewById(R.id.tablayout);
        openbottomsheet = findViewById(R.id.putlloutbtnbottom);
        CustomFragmentAdapter customFragmentAdapter = getfragmentadapter();
         viewPager.setAdapter(customFragmentAdapter);
         tabLayout.setupWithViewPager(viewPager);



         openbottomsheet.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 BottomSheet bottomSheet = new BottomSheet();


                 bottomSheet.show(getSupportFragmentManager(),"MyBottomSheet");


             }
         });
    }

    private CustomFragmentAdapter getfragmentadapter() {
        CustomFragmentAdapter customFragmentAdapter = new CustomFragmentAdapter(getSupportFragmentManager());

        customFragmentAdapter.setfragment(new FirstFragment(),"First");
        customFragmentAdapter.setfragment(new SecondFragment(),"Second");
        customFragmentAdapter.setfragment(new ThirdFragment(),"Third");
        customFragmentAdapter.setfragment(new FirstFragment(),"First");
        customFragmentAdapter.setfragment(new SecondFragment(),"Second");
        customFragmentAdapter.setfragment(new ThirdFragment(),"Third");
        return customFragmentAdapter;
    }
}