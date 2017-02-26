package edu.tomer.java;

public class Main {

    public static void main(String[] args) {

        int i = 5;

        System.out.println(i > 0 ? "WOW" : "NO...");
        int r = i > 0 ? wow() : no();
        /*
        if (i > 0){
            System.out.println("WOW");

        }else{
            System.out.println("NO...");
        }
        */

    }

    private static int no() {
        return 0;
    }

    private static int wow() {
        return 1;
    }
}
