package com.example.googlespreasheeexample

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MyPasswordAdapter(var items: ArrayList<Item>, var context: Context) :
    RecyclerView.Adapter<MyPasswordAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.name.text = item.userdate
        holder.date.text=item.username
        holder.itemView.setOnClickListener {
            val intent = Intent(context, MyCretdialDetail::class.java)
            intent.putExtra("myname", item)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       var name: TextView
        var date: TextView

        init {
            name = itemView.findViewById(R.id.list_user_name)
            date = itemView.findViewById(R.id.list_user_number)
        }
    }
}
