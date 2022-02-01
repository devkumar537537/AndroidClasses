package com.example.basiccomponent;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
DatePicker datePicker;
TextView dateview;
Button pickdatebtn;
AlertDialog.Builder builder ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectxml();
       String date =  getdatetext();
       dateview.setText(date);
       //creating alert dialog
       builder = new AlertDialog.Builder(MainActivity.this);



       pickdatebtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String date =  getdatetext();
               dateview.setText(date);

               builder.setTitle("Date Confirmation")
                       .setMessage("Are you sure to submit Date ?")
                       .setIcon(R.drawable.warning)

                       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               Toast.makeText(getApplicationContext(), "submitted date "+date, Toast.LENGTH_SHORT).show();
                           }
                       })
                       .setNegativeButton("No", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               Toast.makeText(getApplicationContext(), "then select right date", Toast.LENGTH_SHORT).show();
                           }
                       })
                       .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               dialog.cancel();
                           }
                       })
                       .setCancelable(false)
                       .show();


           }
       });
    }

    private void connectxml() {
        dateview = findViewById(R.id.dateview);
        datePicker = findViewById(R.id.datepickerview);
        pickdatebtn = findViewById(R.id.pickdatebtn);
    }

    public String getdatetext()
    {
        int date = datePicker.getDayOfMonth();
        int month = datePicker.getMonth()+1;
        int year = datePicker.getYear();

        String finaldatetextstring = "updated Date => "+String.valueOf(date)+" / "+String.valueOf(month)+" /"+String.valueOf(year);
        return  finaldatetextstring;

    }
}