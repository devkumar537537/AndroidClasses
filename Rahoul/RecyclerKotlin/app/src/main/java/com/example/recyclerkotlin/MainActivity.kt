package com.example.recyclerkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        var arralist:ArrayList<ModelClass> = arrayListOf(
            ModelClass(R.drawable.download,"FirstUser","3242342"),
            ModelClass(R.drawable.right,"Second User","23423423"),
            ModelClass(R.drawable.sample,"Third User","56346345"),
            ModelClass(R.drawable.download,"FirstUser","3242342"),
            ModelClass(R.drawable.right,"Second User","23423423"),
            ModelClass(R.drawable.sample,"Third User","56346345"),
            ModelClass(R.drawable.download,"FirstUser","3242342"),
            ModelClass(R.drawable.right,"Second User","23423423"),
            ModelClass(R.drawable.sample,"Third User","56346345"),
            ModelClass(R.drawable.download,"FirstUser","3242342"),
            ModelClass(R.drawable.right,"Second User","23423423"),
            ModelClass(R.drawable.sample,"Third User","56346345")
        )
        var adapter = RecyclAdapter(arralist,applicationContext)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }
}