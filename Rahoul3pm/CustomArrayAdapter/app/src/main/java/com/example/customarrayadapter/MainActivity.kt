package com.example.customarrayadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    lateinit var listView: ListView
    lateinit var userlist:ArrayList<ItemModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
listView = findViewById(R.id.listview)
        userlist = ArrayList()
        userlist.add(ItemModel(R.drawable.download,"First","Second"))
        userlist.add(ItemModel(R.drawable.none,"None","ntwo"))
        userlist.add(ItemModel(R.drawable.download,"First","Second"))
        userlist.add(ItemModel(R.drawable.none,"None","ntwo"))
        userlist.add(ItemModel(R.drawable.download,"First","Second"))
        userlist.add(ItemModel(R.drawable.none,"None","ntwo"))
        userlist.add(ItemModel(R.drawable.download,"First","Second"))
        userlist.add(ItemModel(R.drawable.none,"None","ntwo"))
        userlist.add(ItemModel(R.drawable.download,"First","Second"))
        userlist.add(ItemModel(R.drawable.none,"None","ntwo"))
        userlist.add(ItemModel(R.drawable.download,"First","Second"))
        userlist.add(ItemModel(R.drawable.none,"None","ntwo"))
        userlist.add(ItemModel(R.drawable.download,"First","Second"))
        userlist.add(ItemModel(R.drawable.none,"None","ntwo"))

        var customadapter = CustomArrayADapter(applicationContext,userlist,R.layout.formate)
        listView.adapter = customadapter

    }
}