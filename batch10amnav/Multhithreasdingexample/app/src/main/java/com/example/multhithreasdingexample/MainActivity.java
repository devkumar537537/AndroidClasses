package com.example.multhithreasdingexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button button,secondbtn;
Handler handler;
TextView textView;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.startprocess);
        secondbtn = findViewById(R.id.secodprocess);
        handler = new Handler();
        textView = findViewById(R.id.texttime);
        secondbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "second process", Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            FirstProcess fone = new FirstProcess();
            fone.start();
            SecondProcess sone = new SecondProcess();
            sone.start();
            }
        });
    }
    private class FirstProcess extends Thread{
        @Override
        public void run() {
            super.run();
        

        }
    }

    private class SecondProcess extends Thread{
        @Override
        public void run() {
            super.run();
            for(int i =0;i<=10;i++)
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
                     textView.setText(String.valueOf(j));
                 }
             });
                Log.e(TAG, "process second"+i );
                if(i==1)
                {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            secondbtn.setEnabled(false);
                            Toast.makeText(getApplicationContext(), "second process start", Toast.LENGTH_SHORT).show();
                        }
                    });

                }

                if(i==10)
                {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            secondbtn.setEnabled(true);
                            Toast.makeText(getApplicationContext(), "second process complete", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }

        }
    }
}