package com.example.bottomsheetexample;

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

public class BottomSheetExample extends BottomSheetDialogFragment {
    EditText emaillayout,passwordlayout;
    Button loginbtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottomsheetxml,container,false);
emaillayout = view.findViewById(R.id.emaillyoaut);
passwordlayout = view.findViewById(R.id.passwordlayout);
loginbtn = view.findViewById(R.id.logInbtn);

loginbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String emailtext = emaillayout.getText().toString();
        String passwortext = passwordlayout.getText().toString();

        Toast.makeText(view.getContext(), "email => "+emailtext+" \n "+passwortext, Toast.LENGTH_SHORT).show();
    }
});

        return view;
    }
}
