package com.batch12pm.parallaxeffectproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

@SuppressWarnings("deprecation")
public class ViewPagerADapter extends FragmentPagerAdapter {
ArrayList<Fragment> fragmentlist = new ArrayList<>();
ArrayList<String> fragmenttitle = new ArrayList<>();


    public ViewPagerADapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    public void getfragtitle(Fragment fragment,String title)
    {
        fragmentlist.add(fragment);
        fragmenttitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmenttitle.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return fragmenttitle.size();
    }
}
