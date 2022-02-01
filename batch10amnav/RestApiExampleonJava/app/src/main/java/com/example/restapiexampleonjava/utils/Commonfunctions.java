package com.example.restapiexampleonjava.utils;

import android.content.Context;
import android.widget.Toast;

public class Commonfunctions {
    Context context;

    public Commonfunctions(Context context) {
        this.context = context;
    }

    public void showtoast(String title)
    {
        Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
    }
    public static String IMAGEBASE_URL= "https://image.tmdb.org/t/p/w500";
    public static String API_KEY= "925f18a206f7c7a799534028b372c6b0";
    public static String Language= "en-US";
}
