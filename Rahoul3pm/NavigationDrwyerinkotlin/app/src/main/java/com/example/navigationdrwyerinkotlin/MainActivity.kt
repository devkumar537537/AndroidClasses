package com.example.navigationdrwyerinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.navigationdrwyerinkotlin.fragments.HomeFragment
import com.example.navigationdrwyerinkotlin.fragments.NotificatiFragment
import com.example.navigationdrwyerinkotlin.fragments.SettingFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {


    private lateinit var navigationView: NavigationView
    private lateinit var drawer: DrawerLayout
    private lateinit var navHeader: View
    private lateinit var imgNavHeaderBg: ImageView
    private lateinit var imgProfile: ImageView
    private lateinit var txtName: TextView
    private lateinit var txtWebsite: TextView
    private lateinit var toolbar: Toolbar

    // toolbar titles respected to selected nav menu item
    private lateinit var activityTitles: Array<String>

    var urlNavHeaderBg = "https://picsum.photos/200/300"
    private  val urlProfileImg = "https://picsum.photos/200/300";

    // index to identify current nav menu item
    var navItemIndex = 0

    // tags used to attach the fragments
    private  val TAG_HOME = "home"
    private val TAG_NOTIFICATIONS = "notifications"
    private  val TAG_SETTINGS = "settings"
    var CURRENT_TAG: String = TAG_HOME


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // mHandler = new Handler();
        drawer = findViewById(R.id.drawyerlatyout)
        navigationView = findViewById(R.id.navigationview)
        navHeader = navigationView.getHeaderView(0)
        txtName = navHeader.findViewById(R.id.name)
        txtWebsite = navHeader.findViewById(R.id.website)
        imgNavHeaderBg = navHeader.findViewById(R.id.img_header_bg)
        imgProfile = navHeader.findViewById(R.id.img_profile)
        activityTitles = resources.getStringArray(R.array.nav_item_activity_titles)

        loadNavHeader()
        setUpNavigationView()
        if (savedInstanceState == null) {
            navItemIndex = 0
            CURRENT_TAG = TAG_HOME
            loadHomeFragment()
        }
    }

    private fun loadHomeFragment() {

        setToolbarTitle()

        if (supportFragmentManager.findFragmentByTag(CURRENT_TAG) != null) {
            drawer!!.closeDrawers()
            return
        }

        val fragment =gethomefragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentcontainer, fragment, CURRENT_TAG)
        fragmentTransaction.commitAllowingStateLoss()


        //Closing drawer on item click
        drawer!!.closeDrawers()

        // refresh toolbar menu
        invalidateOptionsMenu()
    }

    private fun gethomefragment(): Fragment {
        when (navItemIndex) {
            0 -> {
                // home
                val homeFragments = HomeFragment()
                toolbar!!.title = "Home"
                return homeFragments
            }
            1 -> {
                // notifications fragment
                val notificationsFragment = NotificatiFragment()
                toolbar!!.title = "Notification"
                return notificationsFragment
            }
            2 -> {
                // settings fragment
                val settingsFragment = SettingFragment()
                toolbar!!.title = "Setting"
                return settingsFragment
            }
            else -> return HomeFragment()
        }
    }

    private fun setToolbarTitle() {
        supportActionBar!!.setTitle(activityTitles[navItemIndex])
    }

    private fun loadNavHeader() {


        txtName!!.text = "Dev kumar"
        //rightmade
        txtWebsite!!.text = "www.cbitss.com"

Glide.with(this).load(urlNavHeaderBg).into(imgNavHeaderBg)
        Glide.with(this).load(urlProfileImg).into(imgNavHeaderBg)
    }

    private fun setUpNavigationView() {
        navigationView!!.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    navItemIndex = 0
                    CURRENT_TAG = TAG_HOME
                }
                R.id.nav_notifications -> {
                   navItemIndex = 1
                    CURRENT_TAG = TAG_NOTIFICATIONS
                }
                R.id.nav_settings -> {
                  navItemIndex = 2
                   CURRENT_TAG = TAG_SETTINGS
                }
                else -> navItemIndex = 0
            }
            loadHomeFragment()
            true
        }


        val actionBarDrawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.openDrawer,
            R.string.closeDrawer
        ){
            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
                Toast.makeText(applicationContext,"drawer closed",Toast.LENGTH_SHORT).show()
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                Toast.makeText(applicationContext,"drawer open",Toast.LENGTH_SHORT).show()
            }
        }

        drawer!!.setDrawerListener(actionBarDrawerToggle)

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState()
    }
}