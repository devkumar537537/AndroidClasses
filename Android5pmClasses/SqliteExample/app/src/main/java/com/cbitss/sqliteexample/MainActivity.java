package com.cbitss.sqliteexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText name,surname,marks,idedit;
Button insertbtn,showbtn,updatebtn,deletebtn;
DatabasHelperClass mydatabaser ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindviews();

     mydatabaser = new DatabasHelperClass(getApplicationContext());
        insertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertvalues();
            }
        });
        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showdata();
            }
        });

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatedata();
            }
        });
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteddata();
            }
        });
    }

    private void deleteddata() {
        String id_text = idedit.getText().toString();
        int result = mydatabaser.deletedata(id_text);
        if(result >0)
        {
            Toast.makeText(this, "Data Deleted", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(this, "Deletion failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void updatedata() {
        String name_text = name.getText().toString();
       String id_text = idedit.getText().toString();
        String surnamet_text = surname.getText().toString();
        String marks_text = marks.getText().toString();
        boolean result = mydatabaser.updatadata(id_text,name_text,surnamet_text,marks_text);
        if(result == true)
        {
            Toast.makeText(this, "Value updated", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(this, "Value is not updated", Toast.LENGTH_SHORT).show();
        }
    }

    private void showdata() {
        Cursor cursor = mydatabaser.getAllData();
        if(cursor.getCount() == 0)
        {
           showwmessage("Error","Nothis is Present");
        }else
        {
            StringBuffer stringBuffer = new StringBuffer();

            while (cursor.moveToNext())
            {
                stringBuffer.append("ID: "+cursor.getString(0)+"\n");
                stringBuffer.append("NAME: "+cursor.getString(1)+"\n");
                stringBuffer.append("SURNAME: "+cursor.getString(2)+"\n");
                stringBuffer.append("MARKS: "+cursor.getString(3)+"\n\n");
            }
            showwmessage("Data",stringBuffer.toString());
        }
    }
public void showwmessage(String title,String message)
{
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle(title);
    builder.setMessage(message);
    builder.setCancelable(true);
    builder.show();

}
    private void insertvalues() {
        String name_text = name.getText().toString();

        String surnamet_text = surname.getText().toString();
        String marks_text = marks.getText().toString();
   boolean inserstresult = mydatabaser.inserdata(name_text,surnamet_text,marks_text);

   if(inserstresult == true)
   {
       Toast.makeText(this, "Insert Successfully", Toast.LENGTH_SHORT).show();
   }else
   {
       Toast.makeText(this, "Data insertion failed", Toast.LENGTH_SHORT).show();
   }



    }

    private void bindviews() {
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