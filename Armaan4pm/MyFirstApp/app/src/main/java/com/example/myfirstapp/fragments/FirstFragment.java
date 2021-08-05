package com.example.myfirstapp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.myfirstapp.R;


public class FirstFragment extends Fragment {
   Button movetosecond;
EditText edit_email;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_first, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        movetosecond  = view.findViewById(R.id.movetosecondbtn);
        edit_email = view.findViewById(R.id.emailfrag);
        movetosecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailt_text = edit_email.getText().toString().trim();
                Fragment fragment = new Secondfragment();
                Bundle bundle = new Bundle();
                bundle.putString("email",emailt_text);
                fragment.setArguments(bundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmcontainer,fragment);
                fragmentTransaction.commit();
            }
        });

    }


}