package com.example.relativelayouexample.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.relativelayouexample.R;

public class FirstFragment extends Fragment {

Button movetosecond;
ListView listView;
String[] numberlist = {"3423424","34523423","3242342","324234","324324","324324","65756756","4534534","5634534","3423424","34523423","3242342","324234","324324","324324","65756756","4534534","5634534","34523423","3242342","324234","324324","324324","65756756","4534534","5634534"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        movetosecond =view.findViewById(R.id.movetosecon);
        listView = view.findViewById(R.id.numberlistview);
        movetosecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new SecondFragment();
                Bundle bundle =new Bundle();
                bundle.putString("email","abc@gmail.com");
                bundle.putInt("number",3242342);
                fragment.setArguments(bundle);


                FragmentManager fragmentManager =getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer,fragment);
                fragmentTransaction.commit();
            }
        });

        ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(getContext(),R.layout.dropdownlayout,numberlist);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                PopupMenu popupMenu=new PopupMenu(getContext(),listView);
                popupMenu.getMenuInflater().inflate(R.menu.optionsmenu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        switch (id)
                        {
                            case R.id.firstoption:
                                sum(4,5);
                                break;
                            case R.id.secondoption:
                                multi(4,5);
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
//                String gettext= numberlist[position];
//                Toast.makeText(getContext(), "selected text "+gettext, Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void sum(int a,int b)
    {
        Toast.makeText(getContext(), "sum is "+(a+b), Toast.LENGTH_SHORT).show();
    }
    public void multi(int a,int b)
    {
        Toast.makeText(getContext(), "multi is "+(a*b), Toast.LENGTH_SHORT).show();
    }

}