package com.example.sharepreference;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.core.view.GestureDetectorCompat;

public class SharePreferenceLogices {

    public static final String MY_PREFERN_NAME = "com.example.sharepreference";

    public static void insert(String value, String key, Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_PREFERN_NAME,Context.MODE_PRIVATE);
     SharedPreferences.Editor editor = sharedPreferences.edit();

     editor.putString(key,value);
        editor.apply();

         }


         public static  String showvalue(String key,Context context)
         {
             SharedPreferences sharedPreferences =  context.getSharedPreferences(MY_PREFERN_NAME,Context.MODE_PRIVATE);

            return sharedPreferences.getString(key,"default");
         }

    public static void deletekey(String key,Context context)
    {
        SharedPreferences settings = context.getSharedPreferences(MY_PREFERN_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = settings.edit();
        editor.remove(key);
        editor.commit();
    }
}
