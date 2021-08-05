package com.cbitss.materildesigne;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
RatingBar ratingBar;
Button showbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ratingBar = findViewById(R.id.rating);
        ratingBar.setNumStars(6);
        showbtn = findViewById(R.id.showrating_btn);
        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = String.valueOf(ratingBar.getRating());

                Toast.makeText(MainActivity.this, "rating is "+rating, Toast.LENGTH_SHORT).show();
            }
        });
    }
}