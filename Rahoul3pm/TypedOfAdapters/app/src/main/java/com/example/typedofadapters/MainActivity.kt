package com.example.typedofadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    lateinit var listview:ListView
    lateinit var userlist:MutableList<ItemClass>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listview = findViewById(R.id.listview)
        userlist = ArrayList<ItemClass>()



        userlist.add(ItemClass(R.drawable.download,"First"))
        userlist.add(ItemClass(R.drawable.fragemtlifescyre,"Second"))
        userlist.add(ItemClass(R.drawable.none,"third"))
        userlist.add(ItemClass(R.drawable.one,"fourth"))
        userlist.add(ItemClass(R.drawable.two,"Fifth"))
        userlist.add(ItemClass(R.drawable.download,"First"))
        userlist.add(ItemClass(R.drawable.fragemtlifescyre,"Second"))
        userlist.add(ItemClass(R.drawable.none,"third"))
        userlist.add(ItemClass(R.drawable.one,"fourth"))
        userlist.add(ItemClass(R.drawable.two,"Fifth"))
        userlist.add(ItemClass(R.drawable.download,"First"))
        userlist.add(ItemClass(R.drawable.fragemtlifescyre,"Second"))
        userlist.add(ItemClass(R.drawable.none,"third"))
        userlist.add(ItemClass(R.drawable.one,"fourth"))
        userlist.add(ItemClass(R.drawable.two,"Fifth"))
        userlist.add(ItemClass(R.drawable.download,"First"))
        userlist.add(ItemClass(R.drawable.fragemtlifescyre,"Second"))
        userlist.add(ItemClass(R.drawable.none,"third"))
        userlist.add(ItemClass(R.drawable.one,"fourth"))
        userlist.add(ItemClass(R.drawable.two,"Fifth"))

        var customadapter = CusomBAseAdapter(userlist,applicationContext)
        listview.adapter = customadapter
    }
}