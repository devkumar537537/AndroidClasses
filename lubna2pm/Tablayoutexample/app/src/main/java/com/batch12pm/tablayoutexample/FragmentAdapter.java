package com.batch12pm.tablayoutexample;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.batch12pm.tablayoutexample.fragements.ChatFragment;
import com.batch12pm.tablayoutexample.fragements.SettingFragment;
import com.batch12pm.tablayoutexample.fragements.UserFragment;

@SuppressWarnings("deprecation")
public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(@NonNull FragmentManager fm) {
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
                return new SettingFragment();
            default:
                return  null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
