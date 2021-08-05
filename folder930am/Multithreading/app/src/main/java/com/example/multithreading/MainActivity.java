package com.example.multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.FormatFlagsConversionMismatchException;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {
Switch aSwitch;
Button startthread,startconcurrent,stopthreadbtn,starthreadagain;
Handler mhandler;

    SecondProcess sone;
    SixProcessKilling scond;
    int i=0;
    int j=0;
    boolean isthreadrunning = false;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mhandler = new Handler();
        aSwitch  = findViewById(R.id.swtich);
        startthread = findViewById(R.id.startbtn);
        stopthreadbtn = findViewById(R.id.stopthread);
        starthreadagain = findViewById(R.id.startthreadforkilling);

        startconcurrent = findViewById(R.id.startconcurrent);
        stopthreadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(sone.isAlive()){

            }
            }
        });
        starthreadagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SixProcessKilling scond = new SixProcessKilling("Testing thread");

            }
        });
        startconcurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThirdProcess tone = new ThirdProcess();
                tone.start();
                try {
                    tone.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                FourthProcess fone = new FourthProcess();
                fone.start();
            }
        });
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    aSwitch.setText("On");
                 
                }else
                {
                    aSwitch.setText("Off");
                }
            }
        });
        startthread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if(isthreadrunning == false)
{
    sone= new SecondProcess();
    sone.start();
    isthreadrunning = true;
}else
{
    Toast.makeText(MainActivity.this, "Thread is already running", Toast.LENGTH_SHORT).show();
    Log.e(TAG, "onClick: Thread is already running");
}

            }
        });

        
    }


    class  FirstProcess extends Thread{
        @Override
        public void run() {
            super.run();
            for( i = 0;i<10;i++)
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                   mhandler.post(new Runnable() {
                       @Override
                       public void run() {
                           if(i == 8)
                           {

                               startthread.setText("EndProcess ");
        isthreadrunning = false;

                           }
                       }
                   });


                Log.e(TAG, "onCreate: "+i );
            }
        }
    }


    class  SecondProcess extends Thread{
        @Override
        public void run() {
            super.run();
            for( j = 0;j<10;j++)
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                mhandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(j == 8)
                        {
                            Toast.makeText(MainActivity.this, "First Process Started", Toast.LENGTH_SHORT).show();
                            FirstProcess fone = new FirstProcess();


                            fone.start();
                        }
                    }
                });


                Log.e(TAG, "onCreate: second "+j );
            }
        }
    }
    class  ThirdProcess extends Thread{
        @Override
        public void run() {
            super.run();
            for( i = 0;i<10;i++)
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                mhandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(i == 8)
                        {

                            startthread.setText("EndProcess ");


                        }
                    }
                });


                Log.e(TAG, "onCreate: "+i );
            }
        }
    }
    class  FourthProcess extends Thread{
        @Override
        public void run() {
            super.run();
            for( i = 0;i<10;i++)
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                mhandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(i == 8)
                        {

                            startthread.setText("EndProcess ");


                        }
                    }
                });


                Log.e(TAG, "onCreate: "+i );
            }
        }
    }
}