package com.example.tabsactivity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tabsactivity.fragments.Chat;
import com.example.tabsactivity.fragments.Home;
import com.example.tabsactivity.fragments.User;

public class NewAdapter extends FragmentStateAdapter {
    private static final int CARD_ITEM_SIZE = 10;
    public NewAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new Home();
            case 1:
               return new Chat();
            case 2:
               return new User();
            default:
                return null;
        }

    }
    @Override public int getItemCount() {
        return CARD_ITEM_SIZE;
    }
}
