package com.example.navigationdrawyerr.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigationdrawyerr.R;


public class Home extends Fragment {

RadioGroup radioGroup;
Button checkbtn,boxbtn;
CheckBox lap,mob,bike;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        radioGroup =view.findViewById(R.id.radiogorup);
        checkbtn = view.findViewById(R.id.checkbtn);
boxbtn = view.findViewById(R.id.checkchecbox);
lap = view.findViewById(R.id.laptop);
mob = view.findViewById(R.id.mobile);
bike = view.findViewById(R.id.bike);

boxbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        int price = 0;
        if(lap.isChecked())
        {
            price = price+150000;
        }

        if(mob.isChecked())
        {
            price = price+80000;
        }

        if(bike.isChecked())
        {
            price = price+200000;
        }

        Toast.makeText(view.getContext(), "price => "+price, Toast.LENGTH_SHORT).show();
    }
});
        checkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int  id = -1;
                id = radioGroup.getCheckedRadioButtonId();
                if(id < 0)
                {
                    Toast.makeText(view.getContext(), "Select the option", Toast.LENGTH_SHORT).show();
                }else
                {
                    RadioButton radioButton = view.findViewById(id);
                    String valuetext = radioButton.getText().toString();

                    if(valuetext.equals("Third")){
                        Toast.makeText(view.getContext(), "You are rigth", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(view.getContext(), "You are wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}