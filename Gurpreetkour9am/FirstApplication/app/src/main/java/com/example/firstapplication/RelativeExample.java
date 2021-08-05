package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstapplication.fragments.FirstFragment;

public class RelativeExample extends AppCompatActivity {
TextView emailtextview,passwordtextview;
String emailvalue,passwordvalue;
    private static final String TAG = "RelativeExample";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_example);
        Log.e(TAG, "onCreate: " );
        emailtextview = findViewById(R.id.emaillayoutrelative);
        passwordtextview = findViewById(R.id.passwordlayoutrealtive);

        if(getIntent() == null)
        {
            Toast.makeText(RelativeExample.this,"no data in intent",Toast.LENGTH_SHORT).show();
        }else
        {
             emailvalue = getIntent().getStringExtra("email");
             passwordvalue= getIntent().getStringExtra("password");
             Toast.makeText(RelativeExample.this," emale  = > "+emailvalue+" \n password "+passwordvalue,Toast.LENGTH_LONG).show();
        }
        emailtextview.setText(emailvalue);
        passwordtextview.setText(passwordvalue);


        //fragmentopen code

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentcontainer,new FirstFragment());
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: " );
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: " );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: " );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: " );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: " );
    }
}