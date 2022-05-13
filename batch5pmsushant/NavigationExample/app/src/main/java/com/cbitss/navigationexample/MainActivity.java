package com.cbitss.navigationexample;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.cbitss.navigationexample.fragments.ChatFragment;
import com.cbitss.navigationexample.fragments.HomeFragment;
import com.cbitss.navigationexample.fragments.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomview);
        openfragment(new HomeFragment());
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.homeid:
                      openfragment(new HomeFragment());
                        break;
                    case R.id.chatt:
                        openfragment(new ChatFragment());
                        break;
                    case R.id.settingg:
                        openfragment(new SettingFragment());
                        break;
                }
                return true;
            }
        });

    }
    public void openfragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentcontainer,fragment).commit();
    }

}