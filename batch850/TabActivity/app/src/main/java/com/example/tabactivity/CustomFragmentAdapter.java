package com.example.tabactivity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tabactivity.fragments.FirstFragments;
import com.example.tabactivity.fragments.SecondFragment;
import com.example.tabactivity.fragments.ThirdFragment;

@SuppressWarnings("deprecation")
public class CustomFragmentAdapter extends FragmentPagerAdapter {

    public CustomFragmentAdapter( FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new FirstFragments();
            case 1:
                return new SecondFragment();
            case 2:
                return new ThirdFragment();
            default:
            return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
