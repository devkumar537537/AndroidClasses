package com.example.sampleprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ConstraintExample extends AppCompatActivity {

    TextView questionview;
    RadioButton optA,optB,optC,optd,reopt;
    Button chekbtn;
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
        setContentView(R.layout.activity_constraint_example);
        connectxml();
        questionview.setText(questionslist[0]);
        optA.setText(firstoption[0]);
        optB.setText(secondopion[0]);
        optC.setText(thirdoption[0]);
        optd.setText(fourthoption[0]);

        chekbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = -1;
                id= radioGroup.getCheckedRadioButtonId();
                if(id < 0)
                {
                    Toast.makeText(getApplicationContext(), "select alteast one optin", Toast.LENGTH_SHORT).show();
                }else
                {
                    reopt = findViewById(id);
                    String responstext = reopt.getText().toString().trim();

                    if(responstext.equals(rightoptions[0])){
                        Toast.makeText(getApplicationContext(), "You are right", Toast.LENGTH_SHORT).show();
                    }else
                    {
                        Toast.makeText(getApplicationContext(), "You are wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void connectxml() {
        optA = findViewById(R.id.firtoptin);
        optB = findViewById(R.id.secondoptionn);
        optC = findViewById(R.id.thirdption);
        optd = findViewById(R.id.fourtption);
        chekbtn = findViewById(R.id.ccheckbtn);
        questionview = findViewById(R.id.questtext);
        radioGroup = findViewById(R.id.radiogroupp);

    }
}