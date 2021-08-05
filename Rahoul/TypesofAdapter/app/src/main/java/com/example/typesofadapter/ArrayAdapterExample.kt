package com.example.typesofadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class ArrayAdapterExample : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_array_adapter_example)
        var listview = findViewById<ListView>(R.id.array_listve_view)
        var listviewdata : MutableList<Item> = ArrayList<Item>()

        listviewdata.add(Item("First",R.drawable.arebic))
        listviewdata.add(Item("Second",R.drawable.download))
        listviewdata.add(Item("Third",R.drawable.first))
        listviewdata.add(Item("First",R.drawable.arebic))
        listviewdata.add(Item("Second",R.drawable.download))
        listviewdata.add(Item("Third",R.drawable.first))
        listviewdata.add(Item("First",R.drawable.arebic))
        listviewdata.add(Item("Second",R.drawable.download))
        listviewdata.add(Item("Third",R.drawable.first))

        var adapter = CustomAdapter(applicationContext,listviewdata,R.layout.array_rows)

        listview.adapter = adapter
     listview.setOnItemClickListener { parent, view, position, id ->

         Toast.makeText(applicationContext,"clickec item at position ${listviewdata.get(position).name}",Toast.LENGTH_SHORT).show()
     }
    }
}