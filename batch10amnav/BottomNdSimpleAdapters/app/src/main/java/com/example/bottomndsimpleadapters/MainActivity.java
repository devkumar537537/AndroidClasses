package com.example.bottomndsimpleadapters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bottomndsimpleadapters.fragements.Chat;
import com.example.bottomndsimpleadapters.fragements.FirstFragment;
import com.example.bottomndsimpleadapters.fragements.HomeFragemets;
import com.google.android.material.bottomnavigation.BottomNavigationView;


@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomnavigation);
        openfragment(new HomeFragemets());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.homeicon:
                        openfragment(new HomeFragemets());
                        break;
                    case R.id.chattab:
                        openfragment(new Chat());
                        break;
                    case R.id.logout:
                        openfragment(new FirstFragment());
                        break;
                }
                return true;
            }
        });

    }
    private void openfragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentcontianer,fragment);
        fragmentTransaction.commit();
    }
}