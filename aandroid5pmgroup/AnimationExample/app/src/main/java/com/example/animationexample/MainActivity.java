package com.example.animationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView rotateimage;
Button rotatebtn;
EditText emailedit,passwordedit;
Button submibtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectxml();
        Animation emaanim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.lr);
        emailedit.startAnimation(emaanim);
        Animation emaanim2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rl);
        passwordedit.startAnimation(emaanim2);
        Animation emaanim3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bt);
        submibtn.startAnimation(emaanim3);
rotatebtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotation);
    rotateimage.startAnimation(animation);

    }
});
    }

    private void connectxml() {
        rotatebtn = findViewById(R.id.rotatebtn);
        rotateimage = findViewById(R.id.rotateimage);
        submibtn = findViewById(R.id.submitbtn);
        emailedit = findViewById(R.id.emailedit);
        passwordedit = findViewById(R.id.paswordedit);
    }
}