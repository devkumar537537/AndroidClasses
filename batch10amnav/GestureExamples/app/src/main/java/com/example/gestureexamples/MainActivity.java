package com.example.gestureexamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener
{
    private static final String TAG = "MainActivity";

    private GestureDetectorCompat mDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDetector = new GestureDetectorCompat(this,this);

        mDetector.setOnDoubleTapListener(this);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
if(this.mDetector.onTouchEvent(event)){
    return  true;
}
return  super.onTouchEvent(event);

    }


    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Log.e(TAG, "onSingleTapConfirmed: " );
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        Log.e(TAG, "onDoubleTap: " );
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        Log.e(TAG, "onDoubleTapEvent: " );
        return true;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        Log.e(TAG, "onDown: ");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        Log.e(TAG, "onShowPress: ");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Log.e(TAG, "onSingleTapUp: " );
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Log.e(TAG, "onScroll: ");
        startActivity(new Intent(MainActivity.this,SecondActivity.class));
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        Log.e(TAG, "onLongPress: " );
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Log.e(TAG, "onFling: " );
        return true;
    }
}