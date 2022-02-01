package com.example.parallaxedffetcin12pmexample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

@SuppressWarnings("deprecation")
public class CustomFragmentAdapter extends FragmentPagerAdapter {
    ArrayList<String> fragmenttitlelist = new ArrayList<>();
    ArrayList<Fragment> fragmentslist = new ArrayList<>();

    public CustomFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentslist.get(position);
    }

    @Override
    public int getCount() {
        return fragmentslist.size();
    }

    public void getfragment(Fragment fragment,String title)
    {
        fragmentslist.add(fragment);
        fragmenttitlelist.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmenttitlelist.get(position);
    }
}
