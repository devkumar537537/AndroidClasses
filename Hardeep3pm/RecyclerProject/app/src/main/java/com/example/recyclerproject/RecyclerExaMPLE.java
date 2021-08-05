package com.example.recyclerproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerExaMPLE extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<ItemModel> arrayList;
Button showalredialog;
AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
showalredialog = findViewById(R.id.shoalrtedialbtn);
builder = new AlertDialog.Builder(this);
showalredialog.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        builder.setMessage("Are You Sure ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(RecyclerExaMPLE.this, "You choose No", Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.setTitle("Activity Close ?");
        alertDialog.show();
    }
});
        recyclerView = findViewById(R.id.recylerview);

        arrayList = new ArrayList<>();

        arrayList.add(new ItemModel("First",R.drawable.right));
        arrayList.add(new ItemModel("Second",R.drawable.download));
        arrayList.add(new ItemModel("Third",R.drawable.naturetwo));
        arrayList.add(new ItemModel("Foruth",R.drawable.weather));
        arrayList.add(new ItemModel("First",R.drawable.right));
        arrayList.add(new ItemModel("Second",R.drawable.download));
        arrayList.add(new ItemModel("Third",R.drawable.naturetwo));
        arrayList.add(new ItemModel("Foruth",R.drawable.weather));
        arrayList.add(new ItemModel("First",R.drawable.right));
        arrayList.add(new ItemModel("Second",R.drawable.download));
        arrayList.add(new ItemModel("Third",R.drawable.naturetwo));
        arrayList.add(new ItemModel("Foruth",R.drawable.weather));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
       // GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3);
        recyclerView.setLayoutManager(layoutManager);

        RecylerAdapter recylerAdapter = new RecylerAdapter(arrayList,getApplicationContext());
        recyclerView.setAdapter(recylerAdapter);
    }
}