package com.example.sqlitepracticeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,surname,marks,idedit;
    Button insertbtn,showbtn,deletebtn,updatebtn;
  SqliteHelperClass sqliteHelperClass;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindview();
        sqliteHelperClass = new SqliteHelperClass(getApplicationContext());
        insertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_text = name.getText().toString();

                String surnamet_text = surname.getText().toString();
                String marks_text = marks.getText().toString();
                insertvalues(name_text,surnamet_text,marks_text);
            }
        });

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_text = name.getText().toString();

                String surnamet_text = surname.getText().toString();
                String marks_text = marks.getText().toString();

                String idtext = idedit.getText().toString();
                updatevalues(name_text,surnamet_text,marks_text,idtext);
            }
        });
        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showdata();
                //showdatewihtid();
            }
        });
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idtext = idedit.getText().toString();
                deletinmain(idtext);
            }
        });
    }

    private void deletinmain(String idtext) {
      boolean res =  sqliteHelperClass.deletedata(idtext);
        if(res)
        {
            Toast.makeText(getApplicationContext(), "deletion successfull", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(getApplicationContext(), "deletion failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void showdatewihtid() {
        String idtext = idedit.getText().toString();
        Cursor cursor = sqliteHelperClass.getdatawithconditon(idtext) ;
        if (cursor.getCount() == 0) {
            textView.setText("No data found");
        } else {
            StringBuilder stringBuilder = new StringBuilder();


            while (cursor.moveToNext()) {
                stringBuilder.append("ID => " + cursor.getString(0) + "\n");
                stringBuilder.append("name => " + cursor.getString(1) + "\n");
                stringBuilder.append("surname => " + cursor.getString(2) + "\n");
                stringBuilder.append("marks => " + cursor.getString(3) + "\n\n");

            }
            textView.setText(stringBuilder);
        }
    }

    private void showdata() {
        Cursor cursor =sqliteHelperClass.getdata();

        if(cursor.getCount() == 0)
        {
            textView.setText("No data found");
        }else
        {
            StringBuilder stringBuilder = new StringBuilder();



            while (cursor.moveToNext())
            {
                stringBuilder.append("ID => "+cursor.getString(0)+"\n");
                stringBuilder.append("name => "+cursor.getString(1)+"\n");
                stringBuilder.append("surname => "+cursor.getString(2)+"\n");
                stringBuilder.append("marks => "+cursor.getString(3)+"\n\n");

            }
            textView.setText(stringBuilder);
        }


    }

    private void updatevalues(String name_text, String surnamet_text, String marks_text, String idtext) {
        boolean res =sqliteHelperClass.updatevalues(idtext,name_text,surnamet_text,marks_text);
        if(res)
        {
            Toast.makeText(getApplicationContext(), "updation successfull", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(getApplicationContext(), "updation failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void insertvalues(String name_text, String surnamet_text, String marks_text) {
boolean res =sqliteHelperClass.insertvalue(name_text,surnamet_text,marks_text);
if(res)
{
    Toast.makeText(getApplicationContext(), "insertion successfull", Toast.LENGTH_SHORT).show();
}else
{
    Toast.makeText(getApplicationContext(), "insertion failed", Toast.LENGTH_SHORT).show();
}
    }

    private void bindview() {
        name = findViewById(R.id.student_name);
        surname =findViewById(R.id.student_surnmae);
        marks = findViewById(R.id.student_marks);
        insertbtn = findViewById(R.id.insert_btn);
        showbtn = findViewById(R.id.Show_btn);
        idedit = findViewById(R.id.student_id);
        updatebtn = findViewById(R.id.updatebtn);
        deletebtn = findViewById(R.id.deletebtn);
        textView = findViewById(R.id.textview);
    }
}