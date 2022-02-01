package com.example.tablayoutexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewapger);
        tabLayout = findViewById(R.id.tablayout);

        CustomFragmentAdapter cone = new CustomFragmentAdapter(getSupportFragmentManager());

        viewPager.setAdapter(cone);
        tabLayout.setupWithViewPager(viewPager);
setupicon();
    }

    private void setupicon() {

//        TextView textView =(TextView) LinearLayout.inflate(this,R.layout.tabview,null);
//        textView.setText("Chat");
//        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.chat,0,0,0);
//        tabLayout.getTabAt(0).setCustomView(textView);

        TextView textView =(TextView) LinearLayout.inflate(this,R.layout.tabview,null);
    textView.setText("Chat");
    textView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.chat,0,0,0);
    tabLayout.getTabAt(0).setCustomView(textView);

        TextView textView1 =(TextView) LinearLayout.inflate(this,R.layout.tabview,null);
        textView1.setText("User");
        textView1.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.user,0,0,0);
        tabLayout.getTabAt(1).setCustomView(textView1);


        TextView textView2 =(TextView) LinearLayout.inflate(this,R.layout.tabview,null);
        textView2.setText("Setting");
        textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.home,0,0,0);
        tabLayout.getTabAt(2).setCustomView(textView2);
    }
}