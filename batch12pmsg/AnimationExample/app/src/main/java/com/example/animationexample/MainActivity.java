package com.example.animationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button;
    private Button sequencbtn;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageview);
        button = findViewById(R.id.roatatebt);

        sequencbtn = findViewById(R.id.sequencbtn);
        textView = findViewById(R.id.textview);

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.together);

        imageView.startAnimation(animation);
    }
});
sequencbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
//        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounceeffect);
//
//        imageView.startAnimation(animation);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sequenceanimation);
        imageView.startAnimation(animation);
    }
});
    }
}