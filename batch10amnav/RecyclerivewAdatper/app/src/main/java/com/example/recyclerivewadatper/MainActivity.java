package com.example.recyclerivewadatper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<RecylerModel>  userlist;
EditText emailedit,passworedit;
Button submitbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userlist = new ArrayList<>();
        recyclerView = findViewById(R.id.recylerview);
        emailedit = findViewById(R.id.emailedit);
        passworedit = findViewById(R.id.numberedit);
        submitbtn = findViewById(R.id.submit);


//        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(layoutManager);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);

//        userlist.add(new RecylerModel("Download",R.drawable.download));
//        userlist.add(new RecylerModel("Heart",R.drawable.heart));
//        userlist.add(new RecylerModel("None",R.drawable.none));
//        userlist.add(new RecylerModel("one",R.drawable.one));
//        userlist.add(new RecylerModel("River",R.drawable.rivere));
//        userlist.add(new RecylerModel("Sky",R.drawable.sky));
//        userlist.add(new RecylerModel("Two",R.drawable.two));
//        userlist.add(new RecylerModel("Corona",R.drawable.corona));
//        userlist.add(new RecylerModel("UniverOne",R.drawable.univers));
//        userlist.add(new RecylerModel("UniversTwo",R.drawable.universetwo));
//        userlist.add(new RecylerModel("UniversFour",R.drawable.universfour));
//        userlist.add(new RecylerModel("UniverThree",R.drawable.universthree));
//        userlist.add(new RecylerModel("BookOne",R.drawable.bookone));
//        userlist.add(new RecylerModel("BookTwo",R.drawable.booktwo));
//        userlist.add(new RecylerModel("BookThree",R.drawable.bookthree));



        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String emailtext = emailedit.getText().toString();

              userlist.add(new RecylerModel(emailtext,R.drawable.bookthree));

                CustomRecylerAdapter customRecylerAdapter = new CustomRecylerAdapter(userlist,getApplicationContext());
                recyclerView.setAdapter(customRecylerAdapter);

            }
        });

    }
}