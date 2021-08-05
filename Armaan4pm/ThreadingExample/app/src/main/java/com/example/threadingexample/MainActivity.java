package com.example.threadingexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText valuedidt;
Button showtoast,startthread;
Handler handler;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        valuedidt = findViewById(R.id.eeditext);
        showtoast = findViewById(R.id.showvaluefromedit);
        startthread = findViewById(R.id.starthread);

        showtoast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edittext = valuedidt.getText().toString().trim();
                Toast.makeText(MainActivity.this, "value is "+edittext, Toast.LENGTH_SHORT).show();
            }
        });
        startthread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            FirstProcess firstProcess = new FirstProcess();
            SecondProcess sone = new SecondProcess();
            sone.start();
            firstProcess.start();
            }
        });
    }

    class  FirstProcess extends Thread{
        @Override
        public void run() {
            super.run();
            for(int i =0;i<=12;i++)
            {
                int j = i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
             handler.post(new Runnable() {
                 @Override
                 public void run() {
                     if(j == 1)
                     {
                         Toast.makeText(MainActivity.this, "FirstProcess start", Toast.LENGTH_SHORT).show();
                     }
                     if(j == 5)
                     {
                         startthread.setText("middle process");
                     }
                 }
             });

                Log.e(TAG, "FirstProcess "+i );
            }
        }
    }
    class  SecondProcess extends Thread{
        @Override
        public void run() {
            super.run();
            for(int i =0;i<=12;i++)
            {
                int j = i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(j == 12)
                        {
                            Toast.makeText(MainActivity.this, "Second process end", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                Log.e(TAG, "FirstProcess "+i );
            }
        }
    }
}