package com.example.multithreading;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStore;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button showvalue,startthread;
EditText getvalue;
    private static final String TAG = "MainActivity";
Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        combinedxml();
        thirdprocess();
startthread.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        FirstProcess pone = new FirstProcess();
        pone.start();

    }
});

showvalue.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String text = getvalue.getText().toString().trim();
        Toast.makeText(MainActivity.this, "it is "+text, Toast.LENGTH_SHORT).show();
    }
});
    }

    private void combinedxml() {
        showvalue = findViewById(R.id.showvaluefromedit);
        startthread = findViewById(R.id.starthread);
        getvalue = findViewById(R.id.eeditext);
    }

class  FirstProcess extends  Thread{
    @Override
    public void run() {
        super.run();
        for(int i = 0;i<11;i++)
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
                    if(j == 10)
                    {
                        SecondProcess sone = new SecondProcess();
                        sone.start();
                        showvalue.setText("value is 7 here");
                        Toast.makeText(MainActivity.this, "valu is 7 here", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            Log.e(TAG, "onCreate: "+i );
        }
    }
}
    class  SecondProcess extends  Thread{
        @Override
        public void run() {
            super.run();
            for(int i = 0;i<11;i++)
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
                        if(j == 7)
                        {
                            startthread.setText("value is 7 here");
                            Toast.makeText(MainActivity.this, "valu is 7 here", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                Log.e(TAG, "second process "+i );
            }
        }
    }

    public void thirdprocess()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<11;i++)
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
                            if(j == 7)
                            {
                                startthread.setText("value is 7 here");
                                Toast.makeText(MainActivity.this, "valu is 7 here", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                    Log.e(TAG, "second process "+i );
                }
            }
        }).start();
    }
}