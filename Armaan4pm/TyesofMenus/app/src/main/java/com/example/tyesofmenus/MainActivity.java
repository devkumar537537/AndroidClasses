package com.example.tyesofmenus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    Button pickdatebtn,generatealertdialog,customtoast,producesnackbar;
    DatePicker datePicker;
    TextView dateview;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pickdatebtn = findViewById(R.id.datepickerbtn);
        datePicker = findViewById(R.id.datepickerview);
        dateview = findViewById(R.id.dateview);
        customtoast = findViewById(R.id.customtoast);
        producesnackbar = findViewById(R.id.snackbar);

        producesnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"this is testing",Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "you click undo action", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
        customtoast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(getApplicationContext());
                LayoutInflater layoutInflater =(LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           View view = layoutInflater.inflate(R.layout.customtoastlayout,null );
           toast.setView(view);
 TextView textView = view.findViewById(R.id.UserName);
 textView.setText("Android");

           toast.setGravity(Gravity.NO_GRAVITY,300,300);
           toast.setDuration(Toast.LENGTH_LONG);
           toast.show();

            }
        });
        builder = new AlertDialog.Builder(this);
        generatealertdialog = findViewById(R.id.generatealertdiatl);
        generatealertdialog.setOnClickListener(new View.OnClickListener() {
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
        String date_text = getdate();
        dateview.setText(date_text);
pickdatebtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String datetext = getdate();
        dateview.setText(datetext);
    }
});
    }


    private String getdate()
    {
        int date = datePicker.getDayOfMonth();
        int month = datePicker.getMonth()+1;
        int year = datePicker.getYear();

        String datetext = " Updated date => "+date+"/"+month+"/"+year;
        return datetext;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.firstotion)
        {
            add(2,3);
        }else if(item.getItemId() == R.id.submenufirst)
        {
            minus(6,5);
        }else if(item.getItemId() == R.id.submenusecond)
        {
            Toast.makeText(this, "title "+item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    private void add(int a,int b)
    {
        int sum = a+b;
        Toast.makeText(this, "The sum is "+sum, Toast.LENGTH_SHORT).show();
    }

    private void minus(int a,int b)
    {
        int minus = a-b;
        Toast.makeText(this, "The minus is "+minus, Toast.LENGTH_SHORT).show();
    }
}