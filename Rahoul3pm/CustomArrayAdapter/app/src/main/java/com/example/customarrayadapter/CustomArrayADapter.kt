package com.example.customarrayadapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.util.*
import kotlin.collections.ArrayList


class  CustomArrayADapter(var context2:Context,var userlist: ArrayList<ItemModel>,var resources:Int):
    ArrayAdapter<ItemModel>(context2,resources){


    override fun getCount(): Int {

        return userlist.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var layoutInflater = context2.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var view = layoutInflater.inflate(R.layout.formate,null,false)

        val imageView = view.findViewById<ImageView>(R.id.formateImage)
        val nametext = view.findViewById<TextView>(R.id.format_name)
        val numbertext = view.findViewById<TextView>(R.id.format_number)
        val clickbtn = view.findViewById<Button>(R.id.formate_button)

        var itemodel = userlist.get(position)
        imageView.setImageResource(itemodel.imageUrl)
        nametext.text = itemodel.name
        numbertext.text = itemodel.number

        return view
    }
}
