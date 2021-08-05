package com.example.tabactivity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tabactivity.fragements.Chat;
import com.example.tabactivity.fragements.Home;
import com.example.tabactivity.fragements.User;

@SuppressWarnings("deprecation")
public class ViewPageAdapter extends FragmentPagerAdapter {
    public ViewPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new Home();
            case 1:
                return new Chat();
            case 2:
                return new User();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
