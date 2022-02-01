package com.example.parallaxeeffect;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class CustomFragmentAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragmentList =new ArrayList<>();
    ArrayList<String> titlelist=new ArrayList<>();

    public CustomFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    public void setfragment(Fragment fragment,String ttitle)
    {
        fragmentList.add(fragment);
        titlelist.add(ttitle);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titlelist.get(position);
    }
}
