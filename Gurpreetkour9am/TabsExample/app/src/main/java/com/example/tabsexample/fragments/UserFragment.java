package com.example.tabsexample.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tabsexample.R;


public class UserFragment extends Fragment {
Button showtaostbtn;
EditText editname;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editname = view.findViewById(R.id.nameedit);
        showtaostbtn= view.findViewById(R.id.showtoast);

        showtaostbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_text = editname.getText().toString();
                Toast tone = new Toast(view.getContext());
                LayoutInflater layoutInflater = getLayoutInflater();

                View view2 = layoutInflater.inflate(R.layout.coustom_toast_layout,(ViewGroup) view.findViewById(R.id.cousto_toast));
                TextView namtext = view2.findViewById(R.id.username);
                namtext.setText(name_text);

                tone.setView(view2);
                tone.setDuration(Toast.LENGTH_LONG);
                tone.setGravity(Gravity.CENTER_HORIZONTAL,0,100);
                tone.show();



            }
        });

    }
}