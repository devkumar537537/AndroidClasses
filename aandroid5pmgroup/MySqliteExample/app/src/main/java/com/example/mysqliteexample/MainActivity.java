package com.example.mysqliteexample;

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
   SqliteHelpClass sqliteHelpClass;
   TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindview();
        sqliteHelpClass = new SqliteHelpClass(getApplicationContext());

        insertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_text = name.getText().toString();

                String surnamet_text = surname.getText().toString();
                String marks_text = marks.getText().toString();
                insertvalues(name_text,surnamet_text,marks_text);
            }
        });
        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdata();
            }
        });
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idtext = idedit.getText().toString();
                String name_text = name.getText().toString();

                String surnamet_text = surname.getText().toString();
                String marks_text = marks.getText().toString();
             updatevalues(idtext,name_text,surnamet_text,marks_text);
            }
        });
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idtext = idedit.getText().toString();
                deltebalues(idtext);
            }
        });
    }

    private void deltebalues(String idtext) {
       int resutl =  sqliteHelpClass.deletedata(idtext);
       if(resutl<0)
       {
           Toast.makeText(this, "Value not deleted", Toast.LENGTH_SHORT).show();
       }else{
           Toast.makeText(this, "Value  deleted", Toast.LENGTH_SHORT).show();
       }
    }

    private void updatevalues(String idtext, String name_text, String surnamet_text, String marks_text) {
      boolean result =   sqliteHelpClass.updatadata(idtext,name_text,surnamet_text,marks_text);
        if(result)
        {
            Toast.makeText(this, "Value updated", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(this, "Value updation failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void showdata() {
        Cursor cursor = sqliteHelpClass.getalldata();
        if(cursor.getCount() == 0)
        {
            Toast.makeText(this, "DAta is not present", Toast.LENGTH_SHORT).show();
        }else
        {
            StringBuilder builder = new StringBuilder();
           while (cursor.moveToNext())
           {
               builder.append("Name => "+cursor.getString(1)+"\n");
               builder.append("Marks => "+cursor.getString(3)+"\n\n");
           }

           textView.setText(builder.toString());
        }
    }

    private void insertvalues(String name_text, String surnamet_text, String marks_text) {
       boolean result =  sqliteHelpClass.insertdata(name_text,surnamet_text,marks_text);

       if(result)
       {
           Toast.makeText(MainActivity.this, "Value inserted", Toast.LENGTH_SHORT).show();
       }else{
           Toast.makeText(MainActivity.this, "Value inserted", Toast.LENGTH_SHORT).show();
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
        textView = findViewById(R.id.datatext);
    }
}