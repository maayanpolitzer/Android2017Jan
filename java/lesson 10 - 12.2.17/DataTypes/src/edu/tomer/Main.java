package edu.tomer;

public class Main {

    public static void main(String[] args) {

        // Convert upward:
        byte day = 56;
        short s = day;
        System.out.println(s);

        // convert downward:
        // casting.
        long e = 3L;
        int i = (int) e;

        // by Helper classes:
        int f = 4;
        Integer w = new Integer(f);
        short k = w.shortValue();
        System.out.println(k);

        //float f = 5.345f;



    }
}
