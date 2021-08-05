package com.example.mvvmexamples.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmexamples.R;
import com.example.mvvmexamples.databinding.FragmentFirstBinding;
import com.example.mvvmexamples.viemodels.FragmentFirstViewMode;


public class FirstFragment extends Fragment {
FragmentFirstBinding firstBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentFirstViewMode fragmentFirstViewMode = new FragmentFirstViewMode();
       firstBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_first,container,false);
       firstBinding.setFirstviewmodel(fragmentFirstViewMode);
       firstBinding.setLifecycleOwner(this);
       return firstBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}