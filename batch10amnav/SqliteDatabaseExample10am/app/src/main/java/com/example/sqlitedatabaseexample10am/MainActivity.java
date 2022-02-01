package com.example.sqlitedatabaseexample10am;

import androidx.appcompat.app.AlertDialog;
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

showbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       showdata();
    }
});

updatebtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String name_text = name.getText().toString();

        String surnamet_text = surname.getText().toString();
        String marks_text = marks.getText().toString();
        String userid  = idedit.getText().toString();

        updatevalues(name_text,surnamet_text,marks_text,userid);
    }
});

deletebtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String userid  = idedit.getText().toString();
        deletemethod(userid);
    }
});



    }

    private void deletemethod(String userid) {
        int result= sqliteHelperClass.deletedata(userid);
        if(result >0 )
        {
            Toast.makeText(getApplicationContext(), "value deleted", Toast.LENGTH_SHORT).show();
        }else

        {
            Toast.makeText(getApplicationContext(), "value deletion failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void updatevalues(String name_text, String surnamet_text, String marks_text, String userid) {
       boolean res =  sqliteHelperClass.updatetable(userid,name_text,surnamet_text,marks_text);
        if(res)
        {
            Toast.makeText(getApplicationContext(), "value updated", Toast.LENGTH_SHORT).show();
        }else

        {
            Toast.makeText(getApplicationContext(), "value updation failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void showdata() {

        Cursor cursor = sqliteHelperClass.showdata();
if(cursor.getCount() ==  0)
{
    showwmessage("NOthing","No data present");
}else
{
    StringBuffer stringBuffer = new StringBuffer();//" "

    while (cursor.moveToNext())
    {
        stringBuffer.append("ID: "+cursor.getString(0)+"\n");//" ID : 1"
        stringBuffer.append("NAME: "+cursor.getString(1)+"\n");

        stringBuffer.append("SURNAME: "+cursor.getString(2)+"\n");
        stringBuffer.append("MARKS: "+cursor.getString(3)+"\n\n");
    }
textView.setText(stringBuffer.toString());

}

    }
    private void showwmessage(String title, String body) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(body);
        builder.setCancelable(true);
        builder.show();
    }
    private void insertvalues(String name_text, String surnamet_text, String marks_text) {
      boolean res =  sqliteHelperClass.insertvalues(name_text,surnamet_text,marks_text);
      if(res)
      {
          Toast.makeText(getApplicationContext(), "value inserted", Toast.LENGTH_SHORT).show();
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
        textView = findViewById(R.id.textview);
    }
}