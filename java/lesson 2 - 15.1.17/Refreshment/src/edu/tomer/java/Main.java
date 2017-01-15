package edu.tomer.java;

public class Main {

    public static void main(String[] args) {

        int firstNumber = 3;
        int secondNumber = 4;

        //int a = distance(firstNumber, secondNumber);
        //System.out.println(a);
        //int b = multi(firstNumber, secondNumber);
        //System.out.println(b);
        //int c = quatient(firstNumber, secondNumber);
        //System.out.println(c);
        //int d = remainder(firstNumber, secondNumber);
        //System.out.println(d);
        int e = power(firstNumber, secondNumber);
        System.out.println(e);
    }

    public static int sqrt(int x){
        return 0;
    }



    public static int power(int x, int y){
        int result = x;
        for (int i = 1; i < y; i++){
            result = multi(result, x);
            // result *= x;
        }
        return result;
    }

    public static int quatient(int x, int y) {  // x / y;
        int counter = 0;
        /*
        int helper = y;
        while (helper <= x){
            helper += y;
            counter++;
        }
        */
        for (int i = y; i <= x; i += y){
            counter++;
        }
        return counter;
    }

    public static int remainder(int x, int y) {
        return distance(multi(quatient(x,y),y),x);
    }

    public static int distance(int x, int y) {
        int small = x;
        int large = y;
        if (small > large){
            small = y;
            large = x;
        }
        //System.out.println("The smaller number is: " + small);
        //System.out.println("The larger number is: " + large);
        int counter = 0;
        for (int i = small; i < large; i++){
            counter++;
        }
        return counter;
    }

    public static int multi(int x, int y) {
        int small = x;
        int large = y;
        if (small > large){
            small = y;
            large = x;
        }
        int result = 0;
        for (int i = 0; i < small; i++){
            result += large;
        }
        return result;
    }
}
