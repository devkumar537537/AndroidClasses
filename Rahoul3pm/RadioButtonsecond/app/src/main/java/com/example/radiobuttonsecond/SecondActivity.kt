package com.example.radiobuttonsecond

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    lateinit var  mytextview:TextView
    lateinit var emailvalue:String
    lateinit var namevalue : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        mytextview = findViewById(R.id.firstextview)
       emailvalue= intent.getStringExtra("email")!!
        namevalue = intent.getStringExtra("name")!!


        mytextview.text = " $emailvalue \n $namevalue"
    }
}