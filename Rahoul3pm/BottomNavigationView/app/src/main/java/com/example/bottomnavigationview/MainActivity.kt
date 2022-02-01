package com.example.bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottomnavigationview.fragements.ChatFragment
import com.example.bottomnavigationview.fragements.HomeFragment
import com.example.bottomnavigationview.fragements.LoginFragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

@SuppressWarnings("deprecation")
class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomnavigation)
        openfragment(HomeFragment())
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
           when(item.itemId)
           {
               R.id.homeicon->{
                   openfragment(HomeFragment())
               }
               R.id.chaticonn->{
                   openfragment(ChatFragment())
               }
               R.id.logicon->{
                   openfragment(LoginFragment())
               }
           }
            true

        }
    }

    private fun openfragment(fragmen:Fragment) {

        var fragmentManager = supportFragmentManager
        var fragmentransction = fragmentManager.beginTransaction()
        fragmentransction.replace(R.id.fragmentcontainter,fragmen)
        fragmentransction.commit()
    }
}