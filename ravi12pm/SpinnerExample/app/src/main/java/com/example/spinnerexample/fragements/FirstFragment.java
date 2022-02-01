package com.example.spinnerexample.fragements;

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

import com.example.spinnerexample.R;


public class FirstFragment extends Fragment {
Button movetosecond;
EditText emailedit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        movetosecond = view.findViewById(R.id.movetosecond);
       emailedit = view.findViewById(R.id.editemail);
        movetosecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String emailtext = emailedit.getText().toString().trim();


                Fragment fragment = new SecondFragment();
                Bundle bundle = new Bundle();

                bundle.putString("email",emailtext);
                bundle.putInt("age",23);
                fragment.setArguments(bundle);




                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmnetcontainer,fragment);
                fragmentTransaction.commit();
            }
        });
    }
}