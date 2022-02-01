package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.usermodels.UserModel
import com.squareup.picasso.Picasso

class CustomUserADapter(var userlist:ArrayList<UserModel>,var contextt:Context,var imagelist:ArrayList<ImageModel>): RecyclerView.Adapter<CustomUserADapter.MyViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomUserADapter.MyViewHolder {
  return MyViewHolder(LayoutInflater.from(contextt).inflate(R.layout.recyclerformat,parent,false))
    }

    override fun onBindViewHolder(holder: CustomUserADapter.MyViewHolder, position: Int) {
        var usermodel = userlist.get(position)
        var image = imagelist.get(position)
        var address = usermodel.address
        var geo = address!!.geo

        var company = usermodel.company

        holder.latitude.text = geo!!.lat
holder.emaillatyouo.text = usermodel.email
holder.catchpharses.text = company!!.catchPhrase
        Picasso.get().load(image.thumbnailUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imageview)
    }

    override fun getItemCount(): Int {
        return userlist.size
    }
    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var emaillatyouo:TextView
        var catchpharses:TextView
        var latitude:TextView
        var imageview:ImageView
        init {
            emaillatyouo = itemview.findViewById(R.id.emailayout)
            catchpharses = itemview.findViewById(R.id.cactchpharse)
            latitude = itemview.findViewById(R.id.lattitudetext)
            imageview = itemview.findViewById(R.id.imageview)
        }
    }
}