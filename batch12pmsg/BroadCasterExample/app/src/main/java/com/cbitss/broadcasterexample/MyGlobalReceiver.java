package com.cbitss.broadcasterexample;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyGlobalReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
    String action = intent.getAction();
        if (action.equals("android.intent.action.AIRPLANE_MODE")
        ) {
           Intent intent1 =new Intent(context,MainActivity.class);
           intent1.putExtra("network","netband");
            context.startActivity(intent1);

        }
    }
}
