package com.cbitss.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.cbitss.bottomnavigation.fragments.HomeFragment
import com.cbitss.bottomnavigation.fragments.SettingFragment
import com.cbitss.bottomnavigation.fragments.UserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomview:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomview = findViewById(R.id.bottomview)
         openFragmet(HomeFragment())



        bottomview.setOnItemSelectedListener {
            val id = it.itemId
            when(id)
            {
                R.id.home_id->{
                    openFragmet(HomeFragment())
                }
                R.id.user_id->{
                    openFragmet(UserFragment())
                }
                R.id.setting_id->{
                    openFragmet(SettingFragment())
                }
            }
            true
        }
    }
    fun openFragmet(fragment:Fragment){
        val fragmentManager = supportFragmentManager
        val fragmenttransction = fragmentManager.beginTransaction();
        fragmenttransction.replace(R.id.fragmentcontaineter,fragment)
        fragmenttransction.commit()
    }
}