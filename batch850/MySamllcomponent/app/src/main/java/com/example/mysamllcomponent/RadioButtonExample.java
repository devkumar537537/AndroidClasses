package com.example.mysamllcomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RadioButtonExample extends AppCompatActivity {

    RadioButton responsebtn;
    RadioGroup radioGroup;
    Button submit,getratingbtn;
    TextView questiontext;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_example);
     connectxml();
     getratingbtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
           float result =  ratingBar.getRating();
             Toast.makeText(RadioButtonExample.this, "selected rating "+String.valueOf(result), Toast.LENGTH_SHORT).show();
         }
     });
questiontext.setText(R.string.firstquestion);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = -1;
              id =  radioGroup.getCheckedRadioButtonId();
              if(id >0)
              {
                  responsebtn = findViewById(id);
                  String responsetext = responsebtn.getText().toString();

                  if(responsetext.equals("Nine")){
                      Toast.makeText(RadioButtonExample.this, "Right Answer", Toast.LENGTH_SHORT).show();
                  }else {
                      Toast.makeText(RadioButtonExample.this, "You got wrong", Toast.LENGTH_SHORT).show();
                  } 
              }else
              {
                  Toast.makeText(RadioButtonExample.this, "Please select options", Toast.LENGTH_SHORT).show();
              }
              
            }
        });
    }
    private void connectxml()
    {
        submit = findViewById(R.id.submintanser);
        radioGroup = findViewById(R.id.radiogroup);
        questiontext = findViewById(R.id.questiontext);
        ratingBar = findViewById(R.id.radtingbar);
        getratingbtn = findViewById(R.id.getratinbtn);
    }
}