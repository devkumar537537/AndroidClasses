package com.example.broadcasterexamples;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBraodCasteralone extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
           String  actionstring = intent.getAction();
        Toast.makeText(context, "action => "+actionstring, Toast.LENGTH_SHORT).show();
    }
}
