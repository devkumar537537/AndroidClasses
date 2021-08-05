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
ImageView imageView,imageviewtwo;
Button button,buttontwo,sequensebtn;
TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageview);
        button = findViewById(R.id.rotatianimation);
        buttontwo = findViewById(R.id.rotatianimationtwo);
        imageviewtwo = findViewById(R.id.imageviewtwo);
        sequensebtn = findViewById(R.id.sequesncbtn);
        textView = findViewById(R.id.sequesttext);
        sequensebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sequesh);
textView.startAnimation(animation);
            }
        });
        buttontwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadin);
                imageviewtwo.startAnimation(animation);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                imageView.startAnimation(animation);
            }
        });
    }
}