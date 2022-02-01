package com.example.parallaxeeffectinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.example.tablayouts.fragements.ChatFragment
import com.example.tablayouts.fragements.SettingFragment
import com.example.tablayouts.fragements.UserFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var takeout: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tablayout)
        viewPager = findViewById(R.id.viewpage)
        takeout = findViewById(R.id.putlloutbtnbottom)

        takeout.setOnClickListener {
            var bottomsheet= BottomSheetExample()
            bottomsheet.show(supportFragmentManager,"Bottom Sheet")
        }

        var viewpageadapter = getadapter()

        viewPager.adapter= viewpageadapter
        tabLayout.setupWithViewPager(viewPager)



        tabLayout.setOnTabSelectedListener(object : OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
                when (tab.position) {
                    0 -> ChatFragment()
                    1 -> SettingFragment()
                    2 -> UserFragment()
                    3-> ChatFragment()
                    4 -> SettingFragment()
                    5 -> UserFragment()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }

    private fun getadapter(): ViewPageAdapter {
        var viewpageadapter = ViewPageAdapter(supportFragmentManager)
        viewpageadapter.getfragment(ChatFragment(),"Chat")
        viewpageadapter.getfragment(SettingFragment(),"Setting")
        viewpageadapter.getfragment(UserFragment(),"User")
        viewpageadapter.getfragment(ChatFragment(),"Chat")
        viewpageadapter.getfragment(SettingFragment(),"Setting")
        viewpageadapter.getfragment(UserFragment(),"User")
        viewpageadapter.getfragment(ChatFragment(),"Chat")
        viewpageadapter.getfragment(SettingFragment(),"Setting")
        viewpageadapter.getfragment(UserFragment(),"User")

        return viewpageadapter

    }
}