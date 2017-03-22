package edu.hackeru;

public class Main {

    public static void main(String[] args) {

        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();
        MyThread m3 = new MyThread();
        m1.start();
        m2.start();
        m3.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(MyThread.getCounter());

        /*
        System.out.println("wow");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("wiii");
        System.out.println("done");
        */

    }

}
