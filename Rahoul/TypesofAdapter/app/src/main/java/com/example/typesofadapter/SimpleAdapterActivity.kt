package com.example.typesofadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class SimpleAdapterActivity : AppCompatActivity() {

    var imaglist: IntArray = intArrayOf(R.drawable.arebic,R.drawable.right,R.drawable.nature,R.drawable.naturetwo,R.drawable.sample);
    var namelist: Array<String> = arrayOf("first","second","Third","Fourt","Fift");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_adapter)
        val listView = findViewById<ListView>(R.id.simplie_listview);

        val arraylist: ArrayList<HashMap<String,String>> = ArrayList()

        for(  i in imaglist.indices){
            val hashMap:HashMap<String,String>  = HashMap()
            hashMap.put("name",namelist[i])
            hashMap.put("image",imaglist[i].toString())

            arraylist.add(hashMap)
        }

        var from :Array<String> = arrayOf("name","image")
        var to:IntArray = intArrayOf(R.id.array_name,R.id.array_image)
        val customSimpleAdapter = CustomSimpleAdapter(applicationContext,arraylist,R.layout.array_rows,from,to)

        listView.adapter = customSimpleAdapter

        listView.setOnItemClickListener { parent, view, position, id ->

            Toast.makeText(applicationContext,namelist[position].toString(),Toast.LENGTH_SHORT).show()
        }

    }
}