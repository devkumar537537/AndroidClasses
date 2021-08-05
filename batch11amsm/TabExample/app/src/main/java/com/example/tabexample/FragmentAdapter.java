package com.example.tabexample;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tabexample.fragments.ChatFragment;
import com.example.tabexample.fragments.HomeFragment;
import com.example.tabexample.fragments.SettingFragments;

@SuppressWarnings("deprecation")
public class FragmentAdapter extends FragmentPagerAdapter {


    public FragmentAdapter( FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new HomeFragment();
            case 1:
                return new ChatFragment();
            case 2:
                return new SettingFragments();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
