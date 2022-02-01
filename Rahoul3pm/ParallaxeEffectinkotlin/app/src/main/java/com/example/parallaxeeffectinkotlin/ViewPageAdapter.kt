package com.example.parallaxeeffectinkotlin

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPageAdapter(fragementmangaer: FragmentManager) : FragmentPagerAdapter(fragementmangaer) {

    var fragmelist: ArrayList<Fragment> = ArrayList()
    var titlelist: ArrayList<String> = ArrayList()
    override fun getCount(): Int {
       return fragmelist.size
    }

    override fun getItem(position: Int): Fragment {
       return fragmelist.get(position)
    }

    fun getfragment(fragment: Fragment,title:String)
    {
        fragmelist.add(fragment)
        titlelist.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titlelist.get(position)
    }
}