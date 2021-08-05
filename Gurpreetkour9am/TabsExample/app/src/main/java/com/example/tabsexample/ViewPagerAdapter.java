package com.example.tabsexample;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tabsexample.fragments.ChatFragment;
import com.example.tabsexample.fragments.StatusFragments;
import com.example.tabsexample.fragments.UserFragment;


@SuppressWarnings("deprecation")
public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new UserFragment();
            case 1:
                return new ChatFragment();
            case 2:
                return new StatusFragments();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
