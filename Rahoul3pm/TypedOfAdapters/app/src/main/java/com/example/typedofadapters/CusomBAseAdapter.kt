package com.example.typedofadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class CusomBAseAdapter(var userlist:MutableList<ItemClass>,var context: Context): BaseAdapter() {

    override fun getCount(): Int {
        return userlist.size
    }

    override fun getItem(position: Int): Any {
       return userlist.get(position)
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        var infalter = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = infalter.inflate(R.layout.baseitemlayout,null)
        var imageviw = view.findViewById<ImageView>(R.id.imageview)
        var textview = view.findViewById<TextView>(R.id.textname)
        var button = view.findViewById<Button>(R.id.submit)
        var edittext = view.findViewById<EditText>(R.id.nameedit);

        var item = userlist.get(position)
        imageviw.setImageResource(item.imageurl)
        textview.text = item.name

button.setOnClickListener {
    var textt = edittext.text.toString()
    textview.text = textt
}
        return view
    }
}