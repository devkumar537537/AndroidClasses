package com.example.biomatricexample

import android.content.Context
import android.widget.Toast

class Commonfunctions {
    fun notifyuser(title:String,context: Context){
        Toast.makeText(context,title,Toast.LENGTH_SHORT).show()
    }
}