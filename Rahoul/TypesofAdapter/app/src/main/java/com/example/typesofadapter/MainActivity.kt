package com.example.typesofadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import layout.CustomBaseAdapter

class MainActivity : AppCompatActivity() {
    lateinit var listview:ListView
    val imagelist:Array<Int> = arrayOf(R.drawable.sample,R.drawable.third,R.drawable.background,R.drawable.arebic,R.drawable.weather,R.drawable.first,R.drawable.right)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listview = findViewById(R.id.listview)

        val adapter = CustomBaseAdapter(imagelist,applicationContext)

        listview.adapter = adapter
    }
}