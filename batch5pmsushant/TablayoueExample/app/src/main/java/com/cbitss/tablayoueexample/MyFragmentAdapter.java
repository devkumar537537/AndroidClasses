package com.cbitss.tablayoueexample;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.cbitss.tablayoueexample.fragments.ChatFragment;
import com.cbitss.tablayoueexample.fragments.SettingFragment;
import com.cbitss.tablayoueexample.fragments.UserFragment;

@SuppressWarnings("deprecation")
public class MyFragmentAdapter extends FragmentPagerAdapter {

    public MyFragmentAdapter(@NonNull FragmentManager fm) {
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
                return new SettingFragment();
            case 2:
                return new UserFragment();
            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
