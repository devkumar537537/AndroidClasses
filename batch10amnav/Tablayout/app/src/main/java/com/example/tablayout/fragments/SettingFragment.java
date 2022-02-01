package com.example.tablayout.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.tablayout.R;

public class SettingFragment extends Fragment {
Button producebtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        producebtn = view.findViewById(R.id.coustomtoast);
        producebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

          Toast toast = new Toast(getContext());
                LayoutInflater layoutInflater =(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view2 = layoutInflater.inflate(R.layout.customtoast,null,false);

            toast.setView(view2);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_HORIZONTAL,600,600);
            toast.show();
            }
        });
    }
}