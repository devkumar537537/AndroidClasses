package com.batch12pm.fragmentexample.fragements;

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

import com.batch12pm.fragmentexample.R;


public class FirstFragment extends Fragment {
Button movetosecond;
EditText emailedit,numberedit;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       numberedit =view.findViewById(R.id.numbereditt);
       emailedit = view.findViewById(R.id.emaileditt);
        movetosecond= view.findViewById(R.id.movetosecondfragment);
        movetosecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtext = emailedit.getText().toString();
                String numbertext = numberedit.getText().toString();
                int number  = Integer.parseInt(numbertext);
                Fragment fragment = new SecondFragment();
                Bundle bundle = new Bundle();
                bundle.putString("email",emailtext);
                bundle.putInt("number",number);
                fragment.setArguments(bundle);

                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer,fragment);
                fragmentTransaction.commit();
            }
        });


    }
}