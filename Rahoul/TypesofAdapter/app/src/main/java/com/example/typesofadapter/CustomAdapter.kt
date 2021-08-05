package com.example.typesofadapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(var contextlloc: Context,var itelist:MutableList<Item>,var layoutrsourc: Int) : ArrayAdapter<Item>(contextlloc,layoutrsourc,itelist) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

      var view = convertView
        var layoutInflater = contextlloc.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        view = layoutInflater.inflate(R.layout.array_rows,null)
        val imageView = view.findViewById<ImageView>(R.id.array_image);
        val textview = view.findViewById<TextView>(R.id.array_name);

        textview.setText(itelist.get(position).name)
        imageView.setImageResource(itelist.get(position).imageurl)
        return view
    }

    override fun getCount(): Int {
        return itelist.size
    }
}