package com.example.recyclerkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclAdapter(var arraylist: ArrayList<ModelClass>,var context:Context) : RecyclerView.Adapter<RecyclAdapter.MyViewHOlder>() {
   inner class MyViewHOlder(itemview: View): RecyclerView.ViewHolder(itemview){
    lateinit var username:TextView
    lateinit var usernumber:TextView
       lateinit var imageView: ImageView

       init {
           username = itemview.findViewById(R.id.textviewone)
           usernumber = itemview.findViewById(R.id.textviewtwo);
           imageView = itemview.findViewById(R.id.recyerl_image);
       }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclAdapter.MyViewHOlder {
        var view = LayoutInflater.from(context).inflate(R.layout.recycler_formate,parent,false)
        return MyViewHOlder(view)

    }

    override fun getItemCount(): Int {
                return arraylist.size
    }

    override fun onBindViewHolder(holder: RecyclAdapter.MyViewHOlder, position: Int) {

        var modelclass = arraylist.get(position)

        holder.usernumber.setText(modelclass.number)
        holder.username.setText(modelclass.name)
        holder.imageView.setImageResource(modelclass.imageurl)

    }
}