package com.batch12pm.parallaxeffectproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetExample  extends BottomSheetDialogFragment {

    Button submitbtn;
    EditText editText;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottomsheet,container,false);
        submitbtn = view.findViewById(R.id.submitbtn);
        editText  = view.findViewById(R.id.emailedit);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailvale = editText.getText().toString();
                Toast.makeText(getContext(),"email is "+emailvale,Toast.LENGTH_LONG).show();

            }
        });

        return view;
    }
}
