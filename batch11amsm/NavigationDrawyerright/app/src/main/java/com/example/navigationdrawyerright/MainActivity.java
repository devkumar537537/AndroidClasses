package com.example.navigationdrawyerright;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.navigationdrawyerright.fragments.ChatFragment;
import com.example.navigationdrawyerright.fragments.HomeFragment;
import com.example.navigationdrawyerright.fragments.SettingFragment;
import com.google.android.material.navigation.NavigationView;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {



    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private ImageView imgNavHeaderBg, imgProfile;
    private TextView txtName, txtWebsite;
    private Toolbar toolbar;


    // urls to load navigation header background image
    // and profile image
    private static final String urlNavHeaderBg = "https://picsum.photos/200/300";
    private static final String urlProfileImg = "https://picsum.photos/200/300";

    // index to identify current nav menu item
    public static int navItemIndex = 0;

    // tags used to attach the fragments
    private static final String TAG_HOME = "home";

    private static final String TAG_NOTIFICATIONS = "Chat";
    private static final String TAG_SETTINGS = "settings";
    public static String CURRENT_TAG = TAG_HOME;

    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;


    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mHandler = new Handler();
        drawer =  findViewById(R.id.drawerlayout);
        navigationView =  findViewById(R.id.navigationview);


        // Navigation view header
        navHeader = navigationView.getHeaderView(0);
        txtName =  navHeader.findViewById(R.id.name);
        txtWebsite = navHeader.findViewById(R.id.website);
        imgNavHeaderBg =  navHeader.findViewById(R.id.img_header_bg);
        imgProfile =  navHeader.findViewById(R.id.img_profile);

        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);



        // load nav menu header data
        loadNavHeader();

        // initializing navigation menu
        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }
    }

    private void loadHomeFragment() {

        selectNavMenu();

        // set toolbar title
        setToolbarTitle();

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();


            return;
        }

        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
//                        android.R.anim.fade_out);

                fragmentTransaction.replace(R.id.fragmentcontainer, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };


        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }



        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private Fragment getHomeFragment() {

        switch (navItemIndex) {
            case 0:
                // home
                HomeFragment homeFragment = new HomeFragment();
                toolbar.setTitle("Home");
                return homeFragment;

            case 1:
                // notifications fragment
                ChatFragment notificationsFragment = new ChatFragment();
                toolbar.setTitle("Chat");
                return notificationsFragment;

            case 2:
                // settings fragment
                SettingFragment settingsFragment = new SettingFragment();
                toolbar.setTitle("Setting");
                return settingsFragment;
            default:
                return new HomeFragment();
        }
    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }

    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private void setUpNavigationView() {
navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected( MenuItem item) {

        int id= item.getItemId();
        switch (id)
        {
            case R.id.homemenu:
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
                break;

            case R.id.chatmenu:
                navItemIndex = 1;
                CURRENT_TAG = TAG_NOTIFICATIONS;
                break;
            case R.id.settingmenu:
                navItemIndex = 2;
                CURRENT_TAG = TAG_SETTINGS;
                break;

            default:
                navItemIndex = 0;
        }
        loadHomeFragment();

        return true;
    }




});

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.openDrawer,R.string.closeDrawer){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);


            }


            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);


            }


        };
drawer.setDrawerListener(actionBarDrawerToggle);
actionBarDrawerToggle.syncState();
    }

    private void loadNavHeader() {
        txtName.setText("Dev kumar");
        //rightmade
        txtWebsite.setText("www.cbitss.com");


        // loading header background image
Glide.with(this).load(urlNavHeaderBg).into(imgNavHeaderBg);


        // Loading profile image
        Glide.with(this).load(urlProfileImg).into(imgProfile);
    }
}