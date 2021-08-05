package com.example.tabsexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.faragmentviewpage);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        seticon();
    }

    private void seticon() {
//        TextView textView = (TextView) LinearLayout.inflate(this,R.layout.tabs,null);

        TextView textView = (TextView) LinearLayout.inflate(getApplicationContext(),R.layout.texttabs,null);
        textView.setText("User");
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.home,0,0,0);
        tabLayout.getTabAt(0).setCustomView(textView);


        TextView textView1 = (TextView) LinearLayout.inflate(getApplicationContext(),R.layout.texttabs,null);
        textView1.setText("Chat");
        textView1.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.chat,0,0,0);
        tabLayout.getTabAt(1).setCustomView(textView1);

        TextView textView2 = (TextView) LinearLayout.inflate(getApplicationContext(),R.layout.texttabs,null);
        textView2.setText("Status");
        textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.user,0,0,0);
        tabLayout.getTabAt(2).setCustomView(textView2);
    }


}