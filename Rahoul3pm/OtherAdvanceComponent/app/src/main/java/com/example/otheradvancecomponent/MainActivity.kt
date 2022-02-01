package com.example.otheradvancecomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var spinner: Spinner
    var citylist = arrayOf("[--Select--the--City--]","Mohali","DElhi","Derabassi","Chandigarh","Ambala","Panchukla","Sirsa","RajGhat","Mohali","DElhi","Derabassi","Chandigarh","Ambala","Panchukla","Sirsa","RajGhat","Mohali","DElhi","Derabassi","Chandigarh","Ambala","Panchukla","Sirsa","RajGhat")

    lateinit var ratingBar: RatingBar
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner)

        ratingBar = findViewById(R.id.rativar)
        button = findViewById(R.id.submit)


        button.setOnClickListener {
            var responst = ratingBar.rating
            Toast.makeText(applicationContext,"selected rating $responst",Toast.LENGTH_SHORT).show()
        }
        var arrayadapter = ArrayAdapter<String>(applicationContext,R.layout.spinnerlayout,citylist)
        arrayadapter.setDropDownViewResource(R.layout.spinnerlayout)

        spinner.adapter = arrayadapter

        spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {

                var text = citylist[position]
                if(text.equals("[--Select--the--City--]"))
                {
                    Toast.makeText(applicationContext,"selected atleast city",Toast.LENGTH_SHORT).show()
                }else
                {
                    Toast.makeText(applicationContext,"selected city $text",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        });


    }
}

class MainActivitys: AppCompatActivity() {
    private lateinit var navigationView: NavigationView
    private lateinit var drawer: DrawerLayout = null
    private lateinit var navHeader: View? = null
    private lateinit var imgNavHeaderBg: ImageView? = null
    private lateinit var imgProfile: ImageView? = null
    private lateinit var txtName: TextView? = null
    private lateinit var txtWebsite: TextView? = null
    private lateinit var toolbar: Toolbar? = null

    // toolbar titles respected to selected nav menu item
    private lateinit var activityTitles: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // mHandler = new Handler();
        drawer = findViewById(R.id.drawyer_layout)
        navigationView = findViewById(R.id.nav_view)
        navHeader = navigationView.getHeaderView(0)
        txtName = navHeader.findViewById(R.id.name)
        txtWebsite = navHeader.findViewById(R.id.website)
        imgNavHeaderBg = navHeader.findViewById(R.id.img_header_bg)
        imgProfile = navHeader.findViewById(R.id.img_profile)
        activityTitles = resources.getStringArray(R.array.nav_item_activity_titles)
        loadNavHeader()
        setUpNavigationView()
        if (savedInstanceState == null) {
            MainActivity.Companion.navItemIndex = 0
            MainActivity.Companion.CURRENT_TAG = MainActivity.Companion.TAG_HOME
            loadHomeFragment()
        }
    }

    private fun loadHomeFragment() {


        // set toolbar title
        setToolbarTitle()
        if (supportFragmentManager.findFragmentByTag(MainActivity.Companion.CURRENT_TAG) != null) {
            drawer!!.closeDrawers()
            return
        }
        val fragment = homeFragment
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment, MainActivity.Companion.CURRENT_TAG)
        fragmentTransaction.commitAllowingStateLoss()


        //Closing drawer on item click
        drawer!!.closeDrawers()

        // refresh toolbar menu
        invalidateOptionsMenu()
    }// settings fragment// notifications fragment

    // home
    private val homeFragment: Fragment
        private get() = when (MainActivity.Companion.navItemIndex) {
            0 -> {
                // home
                val homeFragment = Home()
                toolbar!!.title = "Home"
                homeFragment
            }
            1 -> {
                // notifications fragment
                val notificationsFragment = Notification()
                toolbar!!.title = "Notification"
                notificationsFragment
            }
            2 -> {
                // settings fragment
                val settingsFragment = Setting()
                toolbar!!.title = "Setting"
                settingsFragment
            }
            else -> Home()
        }

    private fun setToolbarTitle() {
        supportActionBar!!.setTitle(activityTitles[navItemIndex])
    }

    private fun setUpNavigationView() {
        navigationView!!.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    MainActivity.Companion.navItemIndex = 0
                    MainActivity.Companion.CURRENT_TAG = MainActivity.Companion.TAG_HOME
                }
                R.id.nav_notifications -> {
                    MainActivity.Companion.navItemIndex = 1
                    MainActivity.Companion.CURRENT_TAG = MainActivity.Companion.TAG_NOTIFICATIONS
                }
                R.id.nav_settings -> {
                    MainActivity.Companion.navItemIndex = 2
                    MainActivity.Companion.CURRENT_TAG = MainActivity.Companion.TAG_SETTINGS
                }
                else -> MainActivity.Companion.navItemIndex = 0
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
        ) {
            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
                Toast.makeText(applicationContext, "drwyer closed", Toast.LENGTH_SHORT).show()
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                Toast.makeText(applicationContext, "drwyer open", Toast.LENGTH_SHORT).show()
            }
        }
        
        drawer!!.setDrawerListener(actionBarDrawerToggle)

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState()
    }

    private fun loadNavHeader() {
        txtName!!.text = "Dev kumar"
        //rightmade
        txtWebsite!!.text = "www.cbitss.com"


        // loading header background image
        Glide.with(this).load(MainActivity.Companion.urlNavHeaderBg).into(imgNavHeaderBg)

        // Loading profile image
        Glide.with(this).load(MainActivity.Companion.urlProfileImg).into(imgProfile)
    }

    companion object {
        // urls to load navigation header background image
        // and profile image
        private const val urlNavHeaderBg = "https://picsum.photos/200/300"
        private const val urlProfileImg = "https://picsum.photos/200/300"

        // index to identify current nav menu item
        var navItemIndex = 0

        // tags used to attach the fragments
        private const val TAG_HOME = "home"
        private const val TAG_NOTIFICATIONS = "notifications"
        private const val TAG_SETTINGS = "settings"
        var CURRENT_TAG: String = MainActivity.Companion.TAG_HOME
    }
}