package com.example.tablayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.get
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager:ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.tablayout)
        viewPager = findViewById(R.id.viewpager)

        var adapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        seticon()
    }

    private fun seticon() {
        var textview = LinearLayout.inflate(applicationContext,R.layout.tablayout,null) as TextView
        textview.text = "User"
        textview.setCompoundDrawablesWithIntrinsicBounds(R.drawable.user,0,0,0)
        tabLayout.getTabAt(0)!!.customView = textview

        var textview1 = LinearLayout.inflate(applicationContext,R.layout.tablayout,null) as TextView
        textview1.text = "Chat"
        textview1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.chat,0,0,0)
        tabLayout.getTabAt(1)!!.customView = textview1

        var textview2 = LinearLayout.inflate(applicationContext,R.layout.tablayout,null) as TextView
        textview2.text = "Setting"
        textview2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.home,0,0,0)
        tabLayout.getTabAt(2)!!.customView = textview2
    }
}

