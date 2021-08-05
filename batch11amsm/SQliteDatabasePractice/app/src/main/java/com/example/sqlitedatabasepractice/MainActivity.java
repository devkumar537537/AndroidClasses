package com.example.sqlitedatabasepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,surname,marks,idedit;
    Button insertbtn,showbtn,deletebtn,updatebtn;
    Sqlithelperclass sqlithelperclass ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindview();
  sqlithelperclass = new Sqlithelperclass(getApplicationContext());

insertbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String name_text = name.getText().toString();

        String surnamet_text = surname.getText().toString();
        String marks_text = marks.getText().toString();
        insertvalues(name_text,surnamet_text,marks_text);
    }
});
    }

    private void insertvalues(String name_text, String surnamet_text, String marks_text) {
       boolean result =  sqlithelperclass.inservalues(name_text,surnamet_text,marks_text);

       if(result)
       {
           Toast.makeText(getApplicationContext(), "Value inserted", Toast.LENGTH_SHORT).show();
       }else
       {
           Toast.makeText(getApplicationContext(), "value insertion failed", Toast.LENGTH_SHORT).show();
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
    }
}