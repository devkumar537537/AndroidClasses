package com.example.sharepreferecence;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreferences {
    public static final String MY_PREFERN_NAME = "com.example.sharepreferecence";

    public static void insertvalue(String value, String key, Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_PREFERN_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,value);
        editor.apply();
    }


    public static String showvalue(String key,Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_PREFERN_NAME,Context.MODE_PRIVATE);
       String getvalue = sharedPreferences.getString(key,"default");

        return getvalue;
    }

    public static void deletevalue(String key,Context context)
    {
      SharedPreferences sharedPreferences = context.getSharedPreferences(MY_PREFERN_NAME,Context.MODE_PRIVATE);
      SharedPreferences.Editor editor = sharedPreferences.edit();
      editor.remove(key);
      editor.commit();
    }
}
