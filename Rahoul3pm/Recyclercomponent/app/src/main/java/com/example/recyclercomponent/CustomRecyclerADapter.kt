package com.example.recyclercomponent

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList


class CustomRecyclerADapter(var userlist:ArrayList<RecyclerMOdel> ,var context2:Context):
RecyclerView.Adapter<CustomRecyclerADapter.MyViewHolder>()
{


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomRecyclerADapter.MyViewHolder {
     var view = LayoutInflater.from(context2).inflate(R.layout.recyclerformate,parent,false)
    var myview = MyViewHolder(view)
    return myview
    }

    override fun onBindViewHolder(holder: CustomRecyclerADapter.MyViewHolder, position: Int) {
        var model = userlist.get(position)
        holder.imageView.setImageResource(model.imageurl)
        holder.numberview.text = model.username

        holder.clickbtn.setOnClickListener {
            var random = Random()
               var color = Color.argb(255,random.nextInt(255),random.nextInt(255),random.nextInt(255))

            holder.relativeLayout.setBackgroundColor(color)

        }
    }

    override fun getItemCount(): Int {
       return userlist.size
    }



    inner class MyViewHolder(itemview:View):RecyclerView.ViewHolder(itemview)
    {

        var imageView: ImageView
        var numberedit: EditText
        var numberview: TextView
        var clickbtn: CardView
        var relativeLayout: RelativeLayout
        init {
            imageView = itemView.findViewById(R.id.imageview)
            numberedit = itemView.findViewById(R.id.edititext)
            numberview = itemView.findViewById(R.id.userview)
            clickbtn = itemView.findViewById(R.id.myclickbtn)
            relativeLayout = itemView.findViewById(R.id.realativelayout)
        }
    }
}