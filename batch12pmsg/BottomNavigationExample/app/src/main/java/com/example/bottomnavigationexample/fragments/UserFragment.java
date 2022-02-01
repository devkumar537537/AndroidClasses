package com.example.bottomnavigationexample.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bottomnavigationexample.R;


public class UserFragment extends Fragment {
Spinner spinner;
Button spinnerbtn;
TextView spiinertext;
    String text;
String[] citieslist= {"Mohali","Ambala","Moginand","kathal","Chandigarh","Moga","Goa","Delhi","bhutan","Mohali","Ambala","Moginand","kathal","Chandigarh","Moga","Goa","Delhi","bhutan","Mohali","Ambala","Moginand","kathal","Chandigarh","Moga","Goa","Delhi","bhutan","Mohali","Ambala","Moginand","kathal","Chandigarh","Moga","Goa","Delhi","bhutan"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinner = view.findViewById(R.id.spinnerlayout);
        spinnerbtn = view.findViewById(R.id.picktext);
        spiinertext = view.findViewById(R.id.textviewspinner);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),R.layout.spinnertextview,citieslist);
        spinner.setAdapter(arrayAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                     text= citieslist[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spiinertext.setText(text);
            }
        });
    }
}