package com.example.tablayoutexample;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tablayoutexample.fragments.ChatFragment;
import com.example.tablayoutexample.fragments.SettingFragment;
import com.example.tablayoutexample.fragments.UserFragment;

@SuppressWarnings("deprecation")
public class CustomFragmentAdapter extends FragmentPagerAdapter {
    public CustomFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new ChatFragment();
            case 1:
                return new UserFragment();
            case 2:
                return new SettingFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
