package com.example.firebaseconcept930pm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.firebaseconcept930pm.helper.SqliteHelpterClass;

public class NotificatationActivity extends AppCompatActivity {
TextView notifcaview;
String value;
String title;
String date;
String body;
SqliteHelpterClass sqliteHelpterClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificatation);
        notifcaview =findViewById(R.id.textViewnotifcation);
        sqliteHelpterClass = new SqliteHelpterClass(getApplicationContext());
if(getIntent() !=null)
{
    title = getIntent().getStringExtra("title");
    date = getIntent().getStringExtra("date");
    body = getIntent().getStringExtra("body");
    sqliteHelpterClass.insertdata(title,date,body);
}
notifcaview.setText(value);
    }
}