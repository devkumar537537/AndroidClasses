package com.batch12pm.basicadvancecomponent;

import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;

public class TimePikcerExample extends AppCompatActivity {
TimePicker timePicker;
TextView viewtime;
CardView cardView;
TestModel testModel;
SecondModel secondModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_pikcer_example);
        cardView = findViewById(R.id.pickdatebtn);
        viewtime = findViewById(R.id.timeveiw);
        timePicker = findViewById(R.id.timperlayout);
       String restul =  gettime();
       if(getIntent() != null)
       {
           testModel = (TestModel) getIntent().getSerializableExtra("myarray");
           secondModel = testModel.getSecondModel();
       }
       viewtime.setText(restul);
       viewtime.setText(testModel.getName()+ " "+secondModel.getEmail());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String restul =  gettime();
                viewtime.setText(restul);
            }
        });

    }

    private String gettime()
    {
      int hours= timePicker.getHour();
      int minuste = timePicker.getMinute();
      String timetext ="update time :=> "+hours+":"+minuste;
      return timetext;
    }
}