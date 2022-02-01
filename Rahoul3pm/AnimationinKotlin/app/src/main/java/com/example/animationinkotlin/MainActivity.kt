package com.example.animationinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var zoominbtn:Button
    lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        zoominbtn = findViewById(R.id.zoominbtn)
        imageView = findViewById(R.id.imageview)

        zoominbtn.setOnClickListener {
            var animation = AnimationUtils.loadAnimation(applicationContext,R.anim.zoomin)
            imageView.startAnimation(animation)

//            var animation = AnimationUtils.loadAnimation(applicationContext,R.anim.rotate)
//            imageView.startAnimation(animation)


        }
    }
}