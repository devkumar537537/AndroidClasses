package com.dailydose.lifehackes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.MyViewHolder> {
    Activity activity;
    private Context context;
    private List<HomeItems> homeList;
    private Intent intent;

    public HomeRecyclerViewAdapter(Activity activity, Context context, List<HomeItems> homeList) {
        this.activity = activity;
        this.context = context;
        this.homeList = homeList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(context);
        view = mInflater.inflate(R.layout.home_card_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        final int[] backgroundColors = {R.color.list_color1, R.color.list_color2, R.color.list_color3,
                R.color.list_color4, R.color.list_color5, R.color.list_color6, R.color.list_color7, R.color.list_color8};
        int bgColor = ContextCompat.getColor(context, backgroundColors[position % 8]);
        holder.relativeLayout.setBackgroundColor(bgColor);
        holder.textViewTitle.setText(homeList.get(position).getTitle());
        holder.thumbnail.setImageResource(homeList.get(position).getThumbnail());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = holder.textViewTitle.getText().toString();
                Intent(position, title);
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeList.size();
    }

    public void Intent(int position, String name) {
        intent = new Intent(context, QuotesShowActivity.class);
        intent.putExtra("position", position);
        intent.putExtra("title", name);
        context.startActivity(this.intent);
        activity.overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        ImageView thumbnail;
        RelativeLayout relativeLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.homeRecyclerViewText);
            thumbnail = itemView.findViewById(R.id.homeRecyclerViewThumbnail);
            relativeLayout = itemView.findViewById(R.id.bg_Recycler);
        }
    }
}
