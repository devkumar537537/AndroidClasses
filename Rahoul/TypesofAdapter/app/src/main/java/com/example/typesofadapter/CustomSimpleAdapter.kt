package com.example.typesofadapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SimpleAdapter
import android.widget.Toast

class CustomSimpleAdapter(var contextloc:Context,
                          var arraylist: ArrayList<HashMap<String,String>>,
                          resource :Int,
                          from : Array<String>,
                          to : IntArray)  : SimpleAdapter(contextloc,arraylist,resource,from,to){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = super.getView(position, convertView, parent)

        val imageView = view?.findViewById<ImageView>(R.id.array_image);
        imageView?.setOnClickListener {

            Toast.makeText(view.context,arraylist[position]["name"],Toast.LENGTH_SHORT).show();
        }
        return  view
    }
}