package edu.hackeru;

import edu.hackeru.l.TU;

import java.util.Arrays;

public class Main extends TU {

    static int counter = 90;
    private int age = 30;

    public static void main(String[] args) {
        System.out.println(TU.counter);

    }

    private static void finalThings() {
        final X x1 = new X(true);
        x1.setC(4532);
    }

    private static void interfaces() {
        R r1 = new R();
        J j1 = new R();
        R r2 = (R) j1;

        J[] js = new J[2];
        js[0] = new X(true);
        js[1] = new R();

        J j6 = js[1];
        if (j6 instanceof R){
            R r9 = (R) j6;
            r9.wow(89);
        }
    }

    private static void arraysAndList() {
        //int arr2[] = new int[4];
        int[] arr = new int[4]; // {0,0,0,0}
        arr[0] = 45;            // {45,0,0,0}
        arr[3] = -700;          // {45,0,0,-700}
        arr = new int[]{6,5,4,3};
        int[] arr3 = {4,3,5,8};

        Y[] ys = new Y[5]; // {null, null, null, null, null}
        ys[0] = new Y();
/*
        System.out.println(arr[2]);
        System.out.println(arr3.length);

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
*/
        System.out.println(Arrays.toString(arr));

        // ArrayList - resizable array.
        /*
        ArrayList<String> list = new ArrayList<>();
        list.add("Maayan");
        list.add("tom");
        list.add(1, "Shmuel");
        list.contains("Maayan");
        System.out.println(list.get(2));
       */
    }

    private static void objects() {
        X x1 = new X(567L);
        X x2 = new X(-123);
        X x3 = new X(false);
        x1.setC(345);
        //System.out.println(x1.getC());
        //System.out.println(x2.getC());
        Y y = new Y();

        X x5 = new Y();
        Y y10 = (Y) x5;
        y10.male = false;
    }

    private static int sum(int x, int y) {
        for (int j = 0; j < 6; j++) {
            if (j == 4){
                continue;
            }
            System.out.println(j);

            for (int i = 0; i < 100; i++) {
                if (i == 125) {
                    break;
                }
            }
        }
        return -1;
    }

    private void wow() {
        System.out.println("wow");
        System.out.println(counter);

    }

    private static void primitiveTypes() {
        boolean b = false;  // bit  // Boolean

        byte b1 = 1; // 1 byte - 8 bit. // Byte
        short s = 32766;// 2 bytes. // Short
        int i = 1000000;   // 4 bytes. // Integer
        long l = 234344598098L; // 8 bytes. // Long

        float f = 34.4f;     // 4 bytes.    // Float
        double e = 234.5345678;    // 8 bytes.  // Double

        char c = '@';   // 2 bytes. // Character

        // convert upward:
        long rr = i;
        // convert downward:

        // casting.
        short gt = (short) i;
        float r4 = (float) e;
        int ii = (int) r4;

        // helper classes:
        Integer iq = new Integer(i);
        short is = iq.shortValue();
    }

}

