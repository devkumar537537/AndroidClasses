package com.example.boundedservicekotlin

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var playsone:Button
    lateinit var stopsong:Button
    lateinit var puse:Button
    lateinit var boundedService: MyBoundedService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connextxml()



        var intent = Intent(applicationContext,MyBoundedService::class.java)
        bindService(intent,myconnextion,Context.BIND_AUTO_CREATE)
        playsone.setOnClickListener {
            boundedService.startsone()
        }
        puse.setOnClickListener {
            boundedService.paussong()
        }
        stopsong.setOnClickListener {
            boundedService.resetsong()
        }
    }

    private fun connextxml() {
        playsone = findViewById(R.id.playbtn)
        stopsong = findViewById(R.id.resetbtn)
        puse =findViewById(R.id.pausebtn)

    }



    private val myconnextion:ServiceConnection = object :ServiceConnection{
        override fun onServiceConnected(p0: ComponentName?, service: IBinder?) {
            val binder: MyBoundedService.MyBounderClass = service as MyBoundedService.MyBounderClass
           boundedService = binder.getbinder()

            Toast.makeText(boundedService, "service connected", Toast.LENGTH_SHORT).show()
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            Toast.makeText(boundedService, "service false", Toast.LENGTH_SHORT).show()
        }

    }
}