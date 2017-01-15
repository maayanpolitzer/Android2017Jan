package edu.tomer.java;

public class Main {

    public static void main(String[] args) {

        int i = 30;
        int j = 6;
        boolean iAmMale = true;

        i = 5;
        iAmMale = false;

        boolean y = i == j;

        if (iAmMale){  // equals to iAmMale == true.
            // if true
            // yes
        }else{
            // if false
            // no
        }

        iAmMale = false;

        boolean r = isTheSame(4,78);

        int number = 10-6;

        r = changeValue(r); // same as: r = !r;
        System.out.println(r);

        char c = 'o';
        c = 'y';
        c = '=';
        c = '|';
        c = '{';
        c = '\'';
        c = '\\';


        String s = "dflkdslfn";
        s = "maayan!!!!!";

        c = '7';
        s = "7";
        int l = 7;

        String e = "8";

        String t = e + s + 56 + 3;
        System.out.print("maayan" + " wow: " + t);


    }

    public static boolean isTheSame(int x, int y){
        return x == y;
        /*
        if (x == y){
            return true;
        }else {
            return false;
        }
        */
    }

    public static boolean changeValue(boolean moshe){
        /*
        if (moshe){ // equals to if (moshe == true){
            return false;
        }else{
            return true;
        }
        */
        return !moshe;
    }

}
