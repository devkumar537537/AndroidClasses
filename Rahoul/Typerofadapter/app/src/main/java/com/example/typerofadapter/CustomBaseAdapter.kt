package com.example.typerofadapter

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView


class BaseAdapterclassExample(var imagedatas: Array<Int>,var namedata:Array<String> ,var context: Context) :
    BaseAdapter() {
    var inflater: LayoutInflater
    override fun getCount(): Int {
        return imagedatas.size
    }

    override fun getItem(i: Int): Any {
        return i
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    override fun getView(i: Int, again: View, viewGroup: ViewGroup): View {
        var again = again
        again = inflater.inflate(R.layout., null)
        val icon: ImageView = again.findViewById(R.id.icon)
        icon.setImageResource(imagedatas[i])
        return again
    }

    init {
        inflater = LayoutInflater.from(context)
    }
}