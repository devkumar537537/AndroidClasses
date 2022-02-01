package com.example.recyclercomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    lateinit var userlist: ArrayList<RecyclerMOdel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userlist = ArrayList()
        recyclerView = findViewById(R.id.recycleview)


var gridlayoubmaneager= GridLayoutManager(applicationContext,1,RecyclerView.HORIZONTAL,true)

        recyclerView.layoutManager = gridlayoubmaneager
        userlist.add(RecyclerMOdel(R.drawable.corona,"Corona"))
        userlist.add(RecyclerMOdel(R.drawable.download,"Download"))
        userlist.add(RecyclerMOdel(R.drawable.heart,"Heart"))
        userlist.add(RecyclerMOdel(R.drawable.none,"NOne"))
        userlist.add(RecyclerMOdel(R.drawable.one,"One"))
        userlist.add(RecyclerMOdel(R.drawable.rivere,"River"))
        userlist.add(RecyclerMOdel(R.drawable.corona,"Corona"))
        userlist.add(RecyclerMOdel(R.drawable.download,"Download"))
        userlist.add(RecyclerMOdel(R.drawable.heart,"Heart"))
        userlist.add(RecyclerMOdel(R.drawable.none,"NOne"))
        userlist.add(RecyclerMOdel(R.drawable.one,"One"))
        userlist.add(RecyclerMOdel(R.drawable.rivere,"River"))
        userlist.add(RecyclerMOdel(R.drawable.corona,"Corona"))
        userlist.add(RecyclerMOdel(R.drawable.download,"Download"))
        userlist.add(RecyclerMOdel(R.drawable.heart,"Heart"))
        userlist.add(RecyclerMOdel(R.drawable.none,"NOne"))
        userlist.add(RecyclerMOdel(R.drawable.one,"One"))
        userlist.add(RecyclerMOdel(R.drawable.rivere,"River"))
        var customadapter = CustomRecyclerADapter(userlist,applicationContext)

        recyclerView.adapter = customadapter

    }
}