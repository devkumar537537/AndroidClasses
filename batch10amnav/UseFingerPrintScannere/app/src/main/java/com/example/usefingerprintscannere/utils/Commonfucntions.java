package com.example.usefingerprintscannere.utils;

import android.content.Context;
import android.widget.Toast;

public class Commonfucntions {
    Context context;

    public Commonfucntions(Context context) {
        this.context = context;
    }

    public void notifiyuser(String title)
    {
        Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
    }
}
