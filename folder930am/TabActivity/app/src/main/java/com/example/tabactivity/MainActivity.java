package com.example.tabactivity;

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
        viewPager = findViewById(R.id.viewpager);

        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());

        viewPager.setAdapter(viewPageAdapter);

        tabLayout.setupWithViewPager(viewPager);
        seticons();
    }

    private void seticons() {

        TextView textView = (TextView) LinearLayout.inflate(this,R.layout.tabname,null);
        textView.setText("Home");
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.home,0,0,0);
        tabLayout.getTabAt(0).setCustomView(textView);

        TextView textView1 = (TextView) LinearLayout.inflate(this,R.layout.tabname,null);
        textView1.setText("Chat");
        textView1.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.chat,0,0,0);
        tabLayout.getTabAt(1).setCustomView(textView1);

        TextView textView2 = (TextView) LinearLayout.inflate(this,R.layout.tabname,null);
        textView2.setText("User");
        textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.user,0,0,0);
        tabLayout.getTabAt(2).setCustomView(textView2);
    }
}