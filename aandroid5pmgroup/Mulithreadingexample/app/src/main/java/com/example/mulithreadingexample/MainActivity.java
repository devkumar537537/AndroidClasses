package com.example.mulithreadingexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText anyedit;
Button startbtn,showtaost;
Handler handler;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anyedit = findViewById(R.id.anaythign);
        startbtn = findViewById(R.id.startthread);
        showtaost = findViewById(R.id.sthowtoast);
        handler = new Handler();
        showtaost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String anytext =  anyedit.getText().toString().trim();
                Toast.makeText(MainActivity.this, "message "+anytext, Toast.LENGTH_SHORT).show();
            }
        });
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
     FirstProcess fone = new FirstProcess();
     fone.start();
     SecondProcess sone = new SecondProcess();
     sone.start();
            }
        });
    }

class  FirstProcess extends Thread{
    @Override
    public void run() {

        for(int i = 0;i<=12;i++)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i == 7)
            {
                showtaost.setText("middleprocess");
            }
            int j = i;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    if(j== 12)
                    {
                        Toast.makeText(MainActivity.this, "Process finished", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            Log.e(TAG, "onClick: "+i );
        }
    }
}
    class  SecondProcess extends Thread{
        @Override
        public void run() {

            for(int i = 0;i<=12;i++)
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(i == 7)
                {
                    showtaost.setText("middleprocess");
                }
                int j = i;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(j== 12)
                        {
                            Toast.makeText(MainActivity.this, "Process finished", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                Log.e(TAG, "onClick: "+i );
            }
        }
    }

}