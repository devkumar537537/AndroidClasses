package com.cbitss.firstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
val TAG = "MainActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
           Log.e(TAG,"onCreate Mehtod Called")

//First time fragment open on MainActiivty
        val fragmentmanager = supportFragmentManager

        val fragmentTransaction = fragmentmanager.beginTransaction()

    fragmentTransaction.add(R.id.fragment_container,FirstFragment())

        fragmentTransaction.commit()

    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG,"onStart Mehtod Called")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG,"onResume Mehtod Called")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG,"onPause Mehtod Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG,"onDestroy Mehtod Called")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG,"onStop Mehtod Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG,"onRestart Mehtod Called")
    }
}