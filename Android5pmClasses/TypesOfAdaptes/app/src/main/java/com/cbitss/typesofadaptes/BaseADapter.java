package com.cbitss.typesofadaptes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BaseADapter extends BaseAdapter {
    int[] imagedata;
    Context context;
    String[] namelist;

    public BaseADapter(int[] imagedata, Context context,String[] namelist) {
        this.imagedata = imagedata;
        this.context = context;
        this.namelist = namelist;
    }

    @Override
    public int getCount() {
        return imagedata.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.list_formate,null);
        ImageView iconimageview  = view.findViewById(R.id.list_format_imagvview);
        TextView name = view.findViewById(R.id.listview_text);
        name.setText(namelist[position]);
        iconimageview.setImageResource(imagedata[position]);
        return view;
    }
}
