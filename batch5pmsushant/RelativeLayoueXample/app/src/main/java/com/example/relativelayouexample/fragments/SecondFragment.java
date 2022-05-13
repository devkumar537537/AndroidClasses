package com.example.relativelayouexample.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.relativelayouexample.R;


public class SecondFragment extends Fragment {
TextView textView;
String emailvalue;
        int numbervalue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.secondfragmenttext);
        if(getArguments() != null)
        {
            emailvalue = getArguments().getString("email");
            numbervalue = getArguments().getInt("number");
        }

        textView.setText("email is "+emailvalue+" \n numbe is "+numbervalue);
    }
}