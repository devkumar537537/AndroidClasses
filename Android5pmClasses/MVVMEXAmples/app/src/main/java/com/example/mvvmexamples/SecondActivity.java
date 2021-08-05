package com.example.mvvmexamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.mvvmexamples.Fragment.FirstFragment;
import com.example.mvvmexamples.databinding.ActivitySecondBinding;
import com.example.mvvmexamples.viemodels.SecondModel;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySecondBinding activitySecondBinding = DataBindingUtil.setContentView(this,R.layout.activity_second);
        activitySecondBinding.setSeocndomode(new SecondModel());
        activitySecondBinding.executePendingBindings();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.contianer,new FirstFragment());
        fragmentTransaction.commit();
    }
}