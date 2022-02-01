package com.example.bottomndsimpleadapters.fragements;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bottomndsimpleadapters.CustomSimpleAdapter;
import com.example.bottomndsimpleadapters.R;

import java.util.ArrayList;
import java.util.HashMap;


public class HomeFragemets extends Fragment {

ListView listView;
ArrayList<HashMap<String,String>> userlist;
    int[] imageid = {R.drawable.arebic,R.drawable.download,R.drawable.first,R.drawable.naturetwo,R.drawable.arebic,R.drawable.naturetwo,R.drawable.first,R.drawable.naturetwo,R.drawable.first,R.drawable.naturetwo};
    String[] namelist = {"First","Second","Third","Fourth","First","Second","Third","Fourth","Third","Fourth"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_fragemets, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.listview);
        userlist = new ArrayList<>();

        for(int i =0;i<namelist.length;i++)
        {
            HashMap<String,String> usermap = new HashMap<>();

            usermap.put("image",imageid[i]+"");
            usermap.put("name",namelist[i]);
            userlist.add(usermap);
        }

        String[] from = {"image","name"};
        int[] to = {R.id.imageview_row,R.id.textview_row};

        CustomSimpleAdapter customSimpleAdapter = new CustomSimpleAdapter(getContext(),userlist,R.layout.listview_row_formate,from,to);
        listView.setAdapter(customSimpleAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), "this is  click", Toast.LENGTH_SHORT).show();
            }
        });
    }
}