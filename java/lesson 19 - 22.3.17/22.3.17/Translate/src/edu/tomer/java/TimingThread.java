package edu.tomer.java;

/**
 * Created by hackeru on 19/03/2017.
 */
public class TimingThread extends Thread {

    private TimingListener listener;

    public TimingThread(TimingListener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        while(listener.isWorking()){
            listener.changeWords();
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
