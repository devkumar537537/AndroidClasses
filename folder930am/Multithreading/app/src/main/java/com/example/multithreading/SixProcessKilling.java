package com.example.multithreading;

public class SixProcessKilling implements Runnable {
    private boolean exit;

    private String name;
    Thread t;


    SixProcessKilling(String threadname)
    {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        exit = false;
        t.start(); // Starting the thread
    }
    @Override
    public void run() {
        int i = 0;
        while (!exit) {
            System.out.println(name + ": " + i);
            i++;
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                System.out.println("Caught:" + e);
            }
        }
        System.out.println(name + " Stopped.");
    }
    public void stop()
    {
        exit = true;
    }
}
