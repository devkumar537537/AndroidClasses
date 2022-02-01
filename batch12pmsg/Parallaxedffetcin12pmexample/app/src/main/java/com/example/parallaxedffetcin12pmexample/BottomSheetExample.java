package com.example.parallaxedffetcin12pmexample;

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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.bottomsheetlayout,container,false);

        Button  button = view.findViewById(R.id.checkbtn);
        EditText editText = view.findViewById(R.id.editname);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nametext = editText.getText().toString();

                Toast.makeText(getContext(), "data "+nametext, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
