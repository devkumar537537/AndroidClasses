package com.cbitss.navigationdrawyer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
private AppBarConfiguration mAppBarconfigrtaion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.drawyer_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawyer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarconfigrtaion = new AppBarConfiguration.Builder(R.id.first,R.id.seconde,R.id.third)
                .setDrawerLayout(drawerLayout)
                .build();
        NavController navController = Navigation.findNavController(this,R.id.nav_host_frament);
        NavigationUI.setupActionBarWithNavController(this,navController,mAppBarconfigrtaion);
        NavigationUI.setupWithNavController(navigationView,navController);




    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this,R.id.nav_host_frament);

        return NavigationUI.navigateUp(navController,mAppBarconfigrtaion) ||  super.onSupportNavigateUp();
    }
}