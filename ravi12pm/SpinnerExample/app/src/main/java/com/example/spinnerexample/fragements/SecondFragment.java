package com.example.spinnerexample.fragements;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.spinnerexample.R;


public class SecondFragment extends Fragment {
TextView secondtextview;
String emailvalue;
int agevalue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        secondtextview = view.findViewById(R.id.secondfragmenttextview);
        //getting value from firstfragment
       if( getArguments() != null)
       {
           emailvalue = getArguments().getString("email");
           agevalue = getArguments().getInt("age",12);
       }

       secondtextview.setText(" "+emailvalue+ " and \n "+agevalue);
    }
}