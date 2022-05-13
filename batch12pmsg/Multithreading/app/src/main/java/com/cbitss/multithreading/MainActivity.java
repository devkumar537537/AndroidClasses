package com.cbitss.multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button startthreadbtn ,secondthreadbtn;
    private static final String TAG = "MainActivity";
    TextView textView;
Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startthreadbtn =findViewById(R.id.startthread);
        secondthreadbtn =findViewById(R.id.secondbtn);
        textView =findViewById(R.id.mutlitheradingexample);
        handler = new Handler();
        secondthreadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondClass stwo =new SecondClass();
                stwo.start();
                Toast.makeText(MainActivity.this, "secondbtn", Toast.LENGTH_SHORT).show();
            }
        });
        startthreadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             FirstClass fone =new FirstClass();
             fone.start();
            }
        });

    }
    class FirstClass extends Thread{
        @Override
        public void run() {
            super.run();
            Log.e(TAG, "Thread Name "+Thread.currentThread() );
            for(int i =0;i<10;i++)
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.e(TAG, "FirstThread "+i );

            }
        }
    }
    class SecondClass extends Thread{
        @Override
        public void run() {
            super.run();
            Log.e(TAG, "Thread Name "+Thread.currentThread() );
            for(int i =0;i<=10;i++)
            {
                int j=i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(i == 5)
                {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "process reached at 5", Toast.LENGTH_SHORT).show();
                            secondthreadbtn.setText("Middle State");
                        }
                    });

                }
                if(i == 10)
                {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "process reached at 10", Toast.LENGTH_SHORT).show();
                            secondthreadbtn.setText("Final State State");
                            textView.setText(""+j);
                        }
                    });

                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        textView.setText(""+j);
                    }
                });
                Log.e(TAG, "SecondThread "+i );

            }
        }
    }
}