package com.example.sharedpreferenceinkotlinrahoulr

import android.content.Context

class SharePreferenceOperation(var contextt: Context) {
    val MY_PREFERN_NAME = "com.example.sharedpreferenceinkotlinrahoulr"
    val sharedpresseobj = contextt.getSharedPreferences(MY_PREFERN_NAME,Context.MODE_PRIVATE)
    fun insetvalue(keytext:String,valuetext:String)
    {



        val editor = sharedpresseobj.edit()
        editor.putString(keytext,valuetext)
        editor.apply()
    }

    fun showvalue(keytext:String):String?{

        return sharedpresseobj.getString(keytext, "Nothing")
    }

    fun deletekey(key: String?) {

        sharedpresseobj.edit().remove(key).commit()
    }
}