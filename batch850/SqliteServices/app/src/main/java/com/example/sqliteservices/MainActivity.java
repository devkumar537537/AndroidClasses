package com.example.sqliteservices;

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
    SqliteHelper sqliteHelper;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindview();
        sqliteHelper = new SqliteHelper(getApplicationContext());
        
        insertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_Text = name.getText().toString().trim();
                String surname_text = surname.getText().toString().trim();
                String marks_text = marks.getText().toString().trim();
                
                insertdata(name_Text,surname_text,marks_text);
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
                String id_text = idedit.getText().toString().trim();
                String name_Text = name.getText().toString().trim();
                String surname_text = surname.getText().toString().trim();
                String marks_text = marks.getText().toString().trim();
                updatevalues(id_text,name_Text,surname_text,marks_text);
            }
        });
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id_text = idedit.getText().toString().trim();
                deleterecord(id_text);
            }
        });
    }

    private void deleterecord(String id_text) {
        int result = sqliteHelper.deletedata(id_text);
        if(result > 0)
        {
            Toast.makeText(this, "Deletion successfull", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(this, "Deletion failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void updatevalues(String id_text, String name_text, String surname_text, String marks_text) {
       boolean reult = sqliteHelper.updatadata(id_text,name_text,surname_text,marks_text);
        if(reult)
        {
            Toast.makeText(this, "update Successfull", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(this, "updation failed", Toast.LENGTH_SHORT).show();
        }

    }

    private void showdata() {
        Cursor cursor = sqliteHelper.getAllData();
        if(cursor.getCount() == 0)
        {
            Toast.makeText(this, "Data is not present", Toast.LENGTH_SHORT).show();
        }else
        {

            StringBuffer stringBuffer = new StringBuffer();

            while (cursor.moveToNext())
            {
                stringBuffer.append("name => "+ cursor.getString(1)+"\n");
                stringBuffer.append("Marks => "+cursor.getString(3)+"\n\n");

            }
            textView.setText(stringBuffer.toString());

        }
    }

    private void insertdata(String name_text, String surname_text, String marks_text) {
      boolean reuslt =  sqliteHelper.insertdata(name_text,surname_text,marks_text);
      if(reuslt)
      {
          Toast.makeText(this, "Insertion Successfull", Toast.LENGTH_SHORT).show();
      }else
      {
          Toast.makeText(this, "Insertion failed", Toast.LENGTH_SHORT).show();
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
        textView = findViewById(R.id.datatextview);
    }

}