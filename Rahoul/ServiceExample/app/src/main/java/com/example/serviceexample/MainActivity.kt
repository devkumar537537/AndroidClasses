package com.example.serviceexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startbtn = findViewById<Button>(R.id.startservice)
        val stopbtn = findViewById<Button>(R.id.stopservice)

        startbtn.setOnClickListener {
            val intent = Intent(applicationContext,MyService::class.java)
            startService(intent)
        }
        stopbtn.setOnClickListener {
            val intent = Intent(applicationContext,MyService::class.java)
            stopService(intent)
        }
    }
}