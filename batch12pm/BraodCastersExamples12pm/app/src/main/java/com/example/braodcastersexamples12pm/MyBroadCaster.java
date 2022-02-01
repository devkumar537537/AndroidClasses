package com.example.braodcastersexamples12pm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class MyBroadCaster extends BroadcastReceiver {
    Context context;
    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        String actionString = intent.getAction();

        Toast.makeText(context,"action "+actionString,Toast.LENGTH_LONG).show();
        if(actionString.equals("android.intent.action.AIRPLANE_MODE"))
        {
            Toast.makeText(context, "You implemented global recevier", Toast.LENGTH_SHORT).show();
        }else{
            showwifidialog("INternnet","internet");
        }
    }

    public void showwifidialog(String title,String message)
    {
        AlertDialog.Builder alerdialog= new AlertDialog.Builder(context);
        alerdialog.setMessage(message);
        alerdialog.setTitle(title);
        alerdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerdialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerdialog.show();
    }
}
