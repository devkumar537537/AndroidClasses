package com.example.animationexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
ImageView imageView;
TextView textView;

Button button,sequence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageviefadein);
        button = findViewById(R.id.applyanim);
        textView = findViewById(R.id.sequesttext);
        sequence = findViewById(R.id.sequesncbtn);
        sequence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sequencanim);

                textView.startAnimation(animation);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadin);
//                imageView.startAnimation(animation)
              Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotateanimation);

                imageView.startAnimation(animation);
            }
        });
    }
}