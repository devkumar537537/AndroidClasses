package com.dailydose.lifehackes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    Context context;
    View mview;
    String url = null;
    private ViewHolder.Clicklistner mclicklistner;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mview = itemView;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mclicklistner.onItemClick(v, getAdapterPosition(), url);
            }
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    public void setDetails(Context context, String images) {
        ImageView imageView = itemView.findViewById(R.id.imageViewFirebase);
        url = images;
        Glide.with(context)
                .load(images)
                .into(imageView);

    }

    public void setOnClickListner(ViewHolder.Clicklistner clickListner) {
        mclicklistner = clickListner;
    }

    public interface Clicklistner {
        void onItemClick(View view, int position, String url);

    }
}
