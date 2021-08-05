package com.example.webviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingBarExample extends AppCompatActivity {
RatingBar ratingBar;
Button pickratingbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar_example);
        connectxml();

        pickratingbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              float ratingresult =  ratingBar.getRating();
                Toast.makeText(RatingBarExample.this, "Selected Rating "+String.valueOf(ratingresult), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void connectxml(){
        ratingBar = findViewById(R.id.ratingbar);
        pickratingbar = findViewById(R.id.pickratinbtn);
    }
}