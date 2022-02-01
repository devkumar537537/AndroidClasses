package com.example.sampleprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RelativeExample extends AppCompatActivity {
TextView questionview;
RadioButton optA,optB,optC,optd,reopt;
Button chekbtn,movetoconstraint;
RadioGroup radioGroup;

String[] questionslist = {" 1+2 = ?"};
String[] firstoption = {"3"};
String[] secondopion = {"2"};
String[] thirdoption = {"6"};
String[] fourthoption = {"9"};
String[] rightoptions = {"3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_example);
              connectxml();
              questionview.setText(questionslist[0]);
              optA.setText(firstoption[0]);
              optB.setText(secondopion[0]);
        optC.setText(thirdoption[0]);
        optd.setText(fourthoption[0]);

        chekbtn.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {
                int id = radioGroup.getCheckedRadioButtonId();

                reopt = findViewById(id);
                String responsetext = reopt.getText().toString();
                if(responsetext.equals(rightoptions[0]))
                {
                    Toast.makeText(getApplicationContext(), "you are right", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(getApplicationContext(), "YOur are wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
        movetoconstraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RelativeExample.this,ConstraintExample.class);
                startActivity(intent);
            }
        });
    }

private void connectxml()
{
questionview = findViewById(R.id.questiontext);

    optA = findViewById(R.id.firtoptin);
    optB = findViewById(R.id.secondoptionn);
    optC = findViewById(R.id.thirdption);
    optd = findViewById(R.id.fourtption);
    chekbtn = findViewById(R.id.checbtn);
    radioGroup = findViewById(R.id.questionbtngroutp);
    movetoconstraint = findViewById(R.id.movetoconstaraint);

}
}