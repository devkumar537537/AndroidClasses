package com.example.basiccomponent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Spinner spinner;
Button showalertbtn,pickbtn;
AlertDialog.Builder builder;
RatingBar ratingBar;
String[] ciites = {"Select the City","Mohali","Chandigarh","Panchkula","Ambala","Derabassi","Zirakpur","Mohali","Chandigarh","Panchkula","Ambala","Derabassi","Zirakpur"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
       showalertbtn = findViewById(R.id.producedialog);
        ratingBar = findViewById(R.id.ratingbar);
        pickbtn = findViewById(R.id.pickrating);
        builder = new AlertDialog.Builder(this);
        pickbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();
                Toast.makeText(MainActivity.this, "selected rating "+rating, Toast.LENGTH_SHORT).show();
            }
        });
        //alertdialog

        showalertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("Do you want to left this acitvity? ")

                    .setTitle("Closing Activity ")
                    .setIcon(R.drawable.warning)
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            Toast.makeText(MainActivity.this, "you choose yes action ?", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "You choose to staye here ?", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNeutralButton("Cancle", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            Toast.makeText(MainActivity.this, "You choose neutral btn", Toast.LENGTH_SHORT).show();
                        }
                    });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        //spinner
        ArrayAdapter<String> cityadatper = new ArrayAdapter<String>(this,R.layout.listtiem,ciites);
        spinner.setAdapter(cityadatper);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = ciites[position];
                Toast.makeText(MainActivity.this, "selectedciyt "+text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}