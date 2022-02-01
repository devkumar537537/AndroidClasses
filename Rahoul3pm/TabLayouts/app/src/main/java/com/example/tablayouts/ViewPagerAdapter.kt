package com.example.tablayouts

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.tablayouts.fragements.ChatFragment
import com.example.tablayouts.fragements.SettingFragment
import com.example.tablayouts.fragements.UserFragment

class ViewPagerAdapter(var fragmentManager: FragmentManager):FragmentPagerAdapter(fragmentManager) {

    override fun getCount(): Int {
       return 3
    }

    override fun getItem(position: Int): Fragment {
        when(position)
        {
            0->{
                return UserFragment()
            }
            1->{
                return ChatFragment()
            }
            2->{
                return SettingFragment()
            }
            else->{
                return UserFragment()
            }
        }
    }
}