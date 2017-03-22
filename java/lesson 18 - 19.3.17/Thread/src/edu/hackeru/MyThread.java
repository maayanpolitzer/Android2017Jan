package edu.hackeru;

/**
 * Created by hackeru on 19/03/2017.
 */
public class MyThread extends Thread {

    private static int counter = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++){
            increment();
        }
        System.out.println(currentThread().getName() + " is DONE!");
    }

    private static synchronized void increment(){
        counter++;
    }

    public static int getCounter(){
        return counter;
    }
}
