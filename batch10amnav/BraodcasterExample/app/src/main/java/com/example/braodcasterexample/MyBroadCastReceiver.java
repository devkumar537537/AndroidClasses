package com.example.braodcasterexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        String action = intent.getAction();
        Toast.makeText(context,"Airplane mode change" , Toast.LENGTH_SHORT).show();
        if (action.equals("android.intent.action.AIRPLANE_MODE")
        ) {

            Toast.makeText(context, "You implemented global recevier", Toast.LENGTH_SHORT).show();
        }


    }
}
