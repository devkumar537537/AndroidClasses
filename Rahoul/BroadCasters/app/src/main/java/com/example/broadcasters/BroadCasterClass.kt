package com.example.broadcasters

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadCasterClass : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        val acrtionString = intent?.action
        Toast.makeText(context,acrtionString,Toast.LENGTH_SHORT).show()
    }

}