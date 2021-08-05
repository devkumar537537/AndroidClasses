package com.example.firstapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.firstapplication.R;


public class FirstFragment extends Fragment {

Button movebtn;
EditText emailedit;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        movebtn = view.findViewById(R.id.movetosecond);
     emailedit = view.findViewById(R.id.editmail);
        movebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String emailtext = emailedit.getText().toString();
             Fragment fragment = new SecondFragment();
             Bundle bundle = new Bundle();
             bundle.putString("data",emailtext);
             fragment.setArguments(bundle);


                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer,fragment);
                fragmentTransaction.commit();
            }
        });
    }
}